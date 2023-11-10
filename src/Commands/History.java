package Commands;

import LeoOS.LeoOs;
import LeoOS.TextColor;

import java.io.*;
import java.util.ArrayList;

public class History implements Command, WriteFile, ReadFile{

    private String command;
    public History() {
    }
    public History(String command) {
        this.command = command;
    }

    @Override
    public String[] execute(String[] arguments) throws IOException {
        File f = new File(LeoOs.user.getUserPath() + "\\Settings\\.history.txt");
        if(f.isFile()) {
            BufferedReader fR = new BufferedReader(new FileReader(f));
            ArrayList<String> historyLine = new ArrayList<>();
            String output;
            while((output=fR.readLine()) != null) {
                historyLine.add(output);
            }
            return historyLine.toArray(new String[historyLine.size()]);
        } else {
            throw new FileNotFoundException("Es ist leider ein Fehler bei dem finden der History Datei entstanden");
        }
    }

    public void addHistory(String historyCommand) throws IOException {
        ArrayList<String> historyLine;
        File f = new File(LeoOs.user.getUserPath() + "\\Settings\\.history.txt");
        if(f.isFile()) {
            historyLine = getFileContent(f.getPath());
            historyLine.add(historyCommand);
            setFileContent(f.getPath(), historyLine);
        } else {
            throw new FileNotFoundException("Es ist leider ein Fehler bei dem finden der History Datei entstanden");
        }
    }
}
