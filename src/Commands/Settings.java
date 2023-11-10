package Commands;

import LeoOS.LeoOs;
import LeoOS.TextColor;
import User.*;

import java.io.*;

public class Settings implements Command{

    UserSettings u;

    public Settings(UserSettings u) {
        this.u = u;
    }

    @Override
    public String[] execute(String[] arguments) throws IOException {
        settingMenu();
        settingChoice();
        return null;
    }

    private void settingMenu() {
        System.out.println("Was willst du neu einstellen? : ");
        System.out.println("1) Desktop Pfad\n" +
                u.getFileColor() + "2) Datei Farbe\n" + TextColor.getR() +
                u.getDirectoryColor() + "3) Ordner Farbe\n" + TextColor.getR() +
                u.getErrorColor() + "4) Error Farbe\n" + TextColor.getR() +
                u.getGameColor() + "5) Spiel Farbe\n" + TextColor.getR() +
                u.getProgramColor() + "6) Programm Farbe\n" + TextColor.getR() +
                u.getQuestionColor() + "7) Frage/Aufforderungs Farbe\n" + TextColor.getR() +
                "8) User Name\n" +
                "9) Passwort aendern\n");
    }

    private void settingChoice() throws IOException {
        int input = LeoOs.scan.nextInt();
        switch (input) {
            case 1: u.setDesktopPath(chooseDeskPath());
                break;
            case 2: u.setFileColor(colorChoose());
                break;
            case 3: u.setDirectoryColor(colorChoose());
                break;
            case 4: u.setErrorColor(colorChoose());
                break;
            case 5: u.setGameColor(colorChoose());
                break;
            case 6: u.setProgramColor(colorChoose());
                break;
            case 7: u.setQuestionColor(colorChoose());
                break;
            case 8: changeUserName();
                break;
            case 9: changeUserPassword();
                break;
            default:
        }
    }

    private String chooseDeskPath() {
        System.out.println("Geben sie einen neuen Pfad ein: ");
        String p = LeoOs.scan.nextLine();
        p = LeoOs.scan.nextLine();
        File file = new File(p);
        if(file.exists() && file.isDirectory()) {
            return p;
        } else {
            System.out.println(u.getErrorColor() + "Sie haben einen ungueltigen Pfad gewaehlt!" + TextColor.getR());
        }
        return null;
    }

    private int colorChoose() {
        System.out.println("Die erste Zahl ist die Farbe des Textes und die Zweite des Hintergrunds.");
        System.out.println("Schreiben sie eine 0 an den anfang, wenn sie nur Hintergrundfarbe wollen");
        System.out.println("Schreiben sie nur eine Zahl, wenn sie nur den Farbtext haben wollen");
        System.out.println("Waehlen sie ihre beliebige farbe aus:");
        byte j = 0;
        for(int i=30; i<38; i++) {
            if(i==38) {
                i=40;
            }
            j++;
            System.out.println("\u001B[" + i + "m" + j + ")" + TextColor.getR());
        }
        return LeoOs.scan.nextInt();
    }

    private void changeUserName() throws IOException {
        System.out.println("Geben sie ihren neuen Usernamen ein: ");
        String newUserName = LeoOs.scan.nextLine();
        newUserName = LeoOs.scan.nextLine();
        File newUser = new File(LeoOs.userDirectory + "\\Settings\\.userName.txt");
        BufferedWriter bw = new BufferedWriter(new FileWriter(newUser));
        bw.write(newUserName);
        bw.close();
    }

    private void changeUserPassword() throws IOException {
        System.out.println("Geben sie ihr altes Passwort ein: ");
        String passwort = LeoOs.scan.nextLine();
        passwort = LeoOs.scan.nextLine();
        File passwortFile = new File(LeoOs.user.getUserPath() + "\\Settings\\.userPassword.txt");
        BufferedReader br = new BufferedReader(new FileReader(passwortFile));
        if(passwort.equals(br.readLine())) {
            System.out.println("Geben sie ihr neues Passwort ein: ");
            passwort = LeoOs.scan.nextLine();
            BufferedWriter bw = new BufferedWriter(new FileWriter(passwortFile));
            bw.write(passwort);
            bw.close();
        } else {
            System.out.println(u.getErrorColor() + "Sie haben das Falsche Passwort eingegeben!" + TextColor.getR());
        }
    }
}
