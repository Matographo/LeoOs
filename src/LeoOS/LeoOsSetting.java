package LeoOS;

import java.io.*;

public class LeoOsSetting {

    private String programPath;
    private String leoOsPath;
    private String usersPath;
    private String gamePath;

    public LeoOsSetting() throws IOException {
        File f = new File(new java.io.File(".").getCanonicalPath() + "\\leoOsSettings\\leoOsPath.txt");
        BufferedReader br = new BufferedReader(new FileReader(f));
        leoOsPath = br.readLine();
        File t = new File(leoOsPath);
        if(!t.isDirectory()) {
            leoOsPath = null;
            throw new FileNotFoundException("Der dateipfad zu der Os ist beschaedigt!");
        }
        t = new File(leoOsPath + "\\DefaultUser\\Games");
        if(!t.isDirectory()) {
            throw new FileNotFoundException("Der dateipfad zu den Games ist nicht vorhanden");
        }
            gamePath = t.getAbsolutePath();
        t = new File(leoOsPath + "\\DefaultUser\\Programs");
        if(!t.isDirectory()) {
            throw new FileNotFoundException("Der dateipfad zu den Programmen ist beschaedigt");
        }
            programPath = t.getAbsolutePath();
        t = new File(leoOsPath + "\\Users");
        if(!t.isDirectory()) {
            throw new FileNotFoundException("Der dateipfad zu den Usern ist beschaedigt");
        }
            usersPath = t.getAbsolutePath();
    }

    public String getProgramPath() {
        return programPath;
    }

    public void setProgramPath(String programPath) {
        this.programPath = programPath;
    }

    public String getLeoOsPath() {
        return leoOsPath;
    }

    public void setLeoOsPath(String leoOsPath) {
        this.leoOsPath = leoOsPath;
    }

    public String getUsersPath() {
        return usersPath;
    }

    public String getGamePath() {
        return gamePath;
    }

    public void setGamePath(String gamePath) {
        this.gamePath = gamePath;
    }

    public void setUsersPath(String usersPath) {
        this.usersPath = usersPath;
    }

}
