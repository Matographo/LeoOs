package User;

import java.io.*;

public class UserSettings {
    private final String userPath;
    private String directoryColor;
    private String fileColor;
    private String errorColor;
    private String questionColor;
    private String gameColor;
    private String programColor;
    private String desktopPath;

    public UserSettings(String userPath) {
        this.userPath = userPath;
    }

    public void updateSettings() throws IOException {
        directoryColor = intToColor(Integer.parseInt(readSettingFile(".dirColor.txt")));
        fileColor = intToColor(Integer.parseInt(readSettingFile(".fileColor.txt")));
        errorColor = intToColor(Integer.parseInt(readSettingFile(".errColor.txt")));
        questionColor = intToColor(Integer.parseInt(readSettingFile(".questionColor.txt")));
        gameColor = intToColor(Integer.parseInt(readSettingFile(".gameColor.txt")));
        programColor = intToColor(Integer.parseInt(readSettingFile(".programColor.txt")));
    }

    public String getDesktopPath() {
        return desktopPath;
    }

    public void setDesktopPath(String desktopPath) {
        if(desktopPath != null) {
            this.desktopPath = desktopPath;
        }
    }

    public String getProgramColor() {
        return programColor;
    }

    public void setProgramColor(int i) throws IOException {
        this.programColor = intToColor(i);
        String save = ""+i;
        writeSettingFile(save, ".programColor.txt");
    }

    public String getGameColor() {
        return gameColor;
    }

    public void setGameColor(int i) throws IOException {
        this.gameColor = intToColor(i);
        String save = ""+i;
        writeSettingFile(save, ".gameColor.txt");
    }

    public String getQuestionColor() {
        return questionColor;
    }

    public void setQuestionColor(int i) throws IOException {
        this.questionColor = intToColor(i);
        String save = ""+i;
        writeSettingFile(save, ".questionColor.txt");
    }

    public String getErrorColor() {
        return errorColor;
    }

    public void setErrorColor(int i) throws IOException {
        this.errorColor = intToColor(i);
        String save = ""+i;
        writeSettingFile(save, ".errColor.txt");
    }

    public String getFileColor() {
        return fileColor;
    }

    public void setFileColor(int i) throws IOException {
        this.fileColor = intToColor(i);
        String save = ""+i;
        writeSettingFile(save, ".fileColor.txt");
    }

    public String getDirectoryColor() {
        return directoryColor;
    }

    public void setDirectoryColor(int i) throws IOException {
        this.directoryColor = intToColor(i);
        String save = ""+i;
        writeSettingFile(save, ".dirColor.txt");
    }


    public String readSettingFile(String zusatz) throws IOException {
        File f = new File(userPath + "\\Settings\\" + zusatz);
        if(f.isFile()) {
            BufferedReader fR = new BufferedReader(new FileReader(f));
            String ausgabe = fR.readLine();
            return ausgabe;
        }
        return null;
    }

    public void writeSettingFile(String save, String zusatz) throws IOException {
        File f = new File(userPath + "\\Settings\\" + zusatz);
        if (f.exists()) {
            FileWriter fw = new FileWriter(f);
            fw.write(save);
            fw.close();
        }
    }

    private String intToColor(int i) {
        int t,b;
        String farbe = "";
        if(i<10) {
            t = i;
            b = 0;
        } else {
            t = (i / 10) % 10;
            b = i % 10;
        }
        switch (t) {
            case 1 -> farbe += "\u001B[30m";
            case 2 -> farbe += "\u001B[31m";
            case 3 -> farbe += "\u001B[32m";
            case 4 -> farbe += "\u001B[33m";
            case 5 -> farbe += "\u001B[34m";
            case 6 -> farbe += "\u001B[35m";
            case 7 -> farbe += "\u001B[36m";
            case 8 -> farbe += "\u001B[37m";
            default -> farbe += "\u001B[29m";
        };

        switch (b) {
            case 1 -> farbe += "\u001B[40m";
            case 2 -> farbe += "\u001B[41m";
            case 3 -> farbe += "\u001B[42m";
            case 4 -> farbe += "\u001B[43m";
            case 5 -> farbe += "\u001B[44m";
            case 6 -> farbe += "\u001B[45m";
            case 7 -> farbe += "\u001B[46m";
            case 8 -> farbe += "\u001B[47m";
            default -> farbe += "";
        };
        return farbe;
    }
}
