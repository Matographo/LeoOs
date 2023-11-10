package Commands;

import LeoOS.LeoOs;
import LeoOS.TextColor;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.util.InputMismatchException;

public class NewUser implements Command{
    @Override
    public String[] execute(String[] arguments) throws IOException {
        if(LeoOs.user.isAdmin()) {
            BufferedWriter bw;
            System.out.println("Wie soll der neue User.User heißen?");
            String userName = LeoOs.scan.nextLine();
            System.out.println("Geben sie ihr neues Passwort ein!");
            String userPasswort = LeoOs.scan.nextLine();
            System.out.println("Soll der neue User Administrationsrechte haben?" +
                    "\n(y/n)");
            String adminRights = LeoOs.scan.nextLine();
            File adminRightsFile = new File(LeoOs.leoOs.getLeoOsPath() + "\\Settings\\Admin\\" + userName + ".txt");
            adminRightsFile.createNewFile();
            bw = new BufferedWriter(new FileWriter(adminRightsFile));
            if(adminRights.equals("y")) {
                bw.write("true");
                bw.close();
            } else if (adminRights.equals("n")) {
            } else {
                throw new InputMismatchException("Sie haben eine falsche Eingabe gemacht");
            }
            File users = new File(LeoOs.leoOs.getUsersPath());
            File[] allUsers = users.listFiles();
            boolean exist = false;
            for (File a : allUsers) {
                if(a.isDirectory()) {
                    if(a.getName().equalsIgnoreCase(userName)) {
                        exist = true;
                        break;
                    }
                }
            }
            if(!exist) {
                File newUser = new File(LeoOs.leoOs.getUsersPath() + "\\" + userName);
                newUser.mkdir();
                File osSettings = new File(LeoOs.leoOs.getLeoOsPath() + "\\DefaultUser");
                File[] defaultDirectorys = osSettings.listFiles();
                for(File allDirectorys : defaultDirectorys) {
                    File newDirectory = new File(newUser.getPath() + "\\" + allDirectorys.getName());
                    newDirectory.mkdir();
                }
                osSettings = new File(osSettings.getPath() + "\\Settings");
                defaultDirectorys = osSettings.listFiles();
                for(File allFiles : defaultDirectorys) {
                    File newSettings = new File(newUser.getPath() + "\\Settings\\" + allFiles.getName());
                    newSettings.createNewFile();
                    if(newSettings.getName().equals(".errColor.txt")) {
                        bw = new BufferedWriter(new FileWriter(newSettings));
                        bw.write("2");
                    } else if (newSettings.getName().equals(".userPassword.txt")) {
                        bw = new BufferedWriter(new FileWriter(newSettings));
                        bw.write(userPasswort);
                    } else if(newSettings.getName().contains("Color")){
                        bw = new BufferedWriter(new FileWriter(newSettings));
                        bw.write("0");
                    }
                    bw.close();
                }
            } else {
                throw new FileAlreadyExistsException("Dieser User existiert bereits!");
            }
        } else {
            throw new IllegalAccessError("Tut mir leid, sie sind nicht berechtigt einen neuen User anzulegen");
        }
        return null;
    }
}
