package Commands;

import LeoOS.LeoOs;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Count implements Command, ReadFile {
    @Override
    public String[] execute(String[] arguments) throws IOException {
        int words = 0;
        String[] count = null;
        String[] line;
        if(arguments.length > 0) {
            ArrayList<String> fileContent = getFileContent(LeoOs.currendDir + "\\" + arguments[0]);
            if(fileContent != null) {
                for(String content : fileContent) {
                    if(content != null) {
                        line = content.split(" ");
                        words += line.length;
                    }
                }
                count = new String[]{words + " woerter in ihrer Datei."};
            }
        }
        return count;
    }

    private void lc(String[] arguments) throws IOException {
        int lines = 0;
        if(arguments.length > 0) {
            File f = new File(LeoOs.currendDir + "\\" + arguments[0]);
            if(f.isFile()) {
                BufferedReader fR = new BufferedReader(new FileReader(f));
                String output;
                while((output=fR.readLine()) != null) {
                    if(!output.strip().isEmpty()) {
                        lines++;
                    }
                }
                System.out.println(lines + " Zeilen in ihrer Datei.");
            }
        }
    }

    private void loc(String[] arguments) throws IOException {
        int lines = 0;
        if(arguments.length > 0) {
            File f = new File(LeoOs.currendDir + "\\" + arguments[0]);
            if(f.isFile()) {
                BufferedReader fR = new BufferedReader(new FileReader(f));
                String output;
                while((output=fR.readLine()) != null) {
                    if(!output.strip().isEmpty() || !output.strip().startsWith("\\") ) {
                        lines++;
                    }
                }
                System.out.println(lines + " Zeilen code in ihrer Datei.");
            }
        }
    }
}
