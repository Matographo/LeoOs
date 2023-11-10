package LeoOS;

import Commands.*;
import User.User;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LeoOs {

    public static User user;
    public static String userDirectory;
    public static boolean END;
    public static boolean LOGIN;
    public static File currendDir;
    public static LeoOsSetting leoOs;
    public static Scanner scan = new Scanner(System.in);
    public static LoadingScreen loadScreen;

    public LeoOs() throws IOException {
        END = false;
        leoOs = new LeoOsSetting();
        loadScreen = new LoadingScreen();
    }

    public void start() throws IOException, InterruptedException {
        loadScreen.showStartScreen();
        while(!END) {
            alleBenutzerAnzeigen();
            benutzerWaehlen();
            benutzerWahl();
        }
    }



    private void benutzerWahl() {

    }

    private void fakeLoad() throws InterruptedException {
        for(int i=0; i<=100; i++) {
            loadScreen.showLoadingScreen();
            Thread.sleep(10);
            loadScreen.increaseLoading();
        }
        loadScreen.resetLoadscreen();
    }

    private void alleBenutzerAnzeigen() throws IOException {
        System.out.println("Waehlen sie einen Benutzer aus: ");
        File users = new File(leoOs.getUsersPath());
        File[] allUsers = users.listFiles();
        for (File a : allUsers) {
            if(a.isDirectory()) {
                System.out.println(a.getName());
            }
        }
    }

    private void benutzerWaehlen() throws IOException {
        System.out.print("-> ");
        String input = scan.nextLine();
        File users = new File(leoOs.getUsersPath());
        File[] allUsers = users.listFiles();
        for (File a : allUsers) {
            if (input.equals(a.getName())) {
                System.out.print("\nGeben sie ihr Password ein -> ");
                passwortAbfragen(a.getName());
            }
        }
    }

    private void passwortAbfragen(String user) throws IOException {
        String input = scan.nextLine();
        File f_user = new File(leoOs.getUsersPath() + "\\" + user + "\\Settings\\.userPassword.txt");
        try {
            BufferedReader br = new BufferedReader(new FileReader(f_user));
            String password = br.readLine();
            if (input.equals(password)) {
                fakeLoad();
                System.out.println("Sie sind nun eingeloggt:  ");
                this.user = new User(user, password, leoOs.getUsersPath() + "\\" + user);
                userLoading(leoOs.getUsersPath() + "\\" + user);
            } else {
                System.out.println("Ihr Password ist leider falsch!\n");
            }
        } catch (FileNotFoundException | InterruptedException e) {
            System.out.println("Tut mir leid, wir haben ihr Password leider nicht gefunden\n\n");
        }
    }

    private void userLoading(String u) throws InterruptedException {
        LOGIN = true;
        currendDir = new File(u);
        userDirectory = u;
        ExecuteCommand commandExecution = new ExecuteCommand();
        while (LOGIN) {
            try {
                String command = scan.nextLine();
                commandExecution.execute(command, user.getUserSettings());
            } catch (InputMismatchException e) {
                System.out.println(user.getUserSettings().getErrorColor() + "Sie haben eine Falsche Eingabe gemacht. " +
                        "Anstatt einer Zahl einen Text!" + TextColor.getR());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}