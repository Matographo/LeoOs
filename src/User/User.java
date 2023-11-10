package User;

import java.io.*;
import LeoOS.*;

public class User {
    private String userName;
    private String userPassword;
    private String userHomeDirectory;
    private UserSettings userSettings;
    private boolean admin;

    public User(String userName, String userPassword, String userHomeDirectory) throws IOException {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userHomeDirectory = userHomeDirectory;
        userSettings = new UserSettings(userHomeDirectory);
        userSettings.updateSettings();
        admin = readAdmin();
    }

    public void changeUserName(String newName) {
        this.userName = newName;
    }

    public void changeUserPassword(String newPassword) {
        this.userPassword = newPassword;
    }

    public void changeSettings(UserSettings settings) {
        this.userSettings = settings;
    }

    public boolean isAdmin() {
        return admin;
    }

    public UserSettings getUserSettings() {
        return userSettings;
    }

    public String getUserPath() {
        return userHomeDirectory;
    }

    private void saveSettings() {

    }

    private void saveNewName() {

    }

    private void saveNewPassword() {

    }

    private boolean readAdmin() throws IOException {
        File admin = new File(LeoOs.leoOs.getLeoOsPath() + "\\Settings\\Admin\\" + userName + ".txt");
        BufferedReader br = new BufferedReader(new FileReader(admin));
        if(br.readLine().equals("true")) {
            return true;
        }
        return false;
    }

}
