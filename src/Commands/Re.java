package Commands;

import LeoOS.LeoOs;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Re implements Command{
    @Override
    public String[] execute(String[] arguments) throws IOException {

        ArrayList<String> readedFile = new ArrayList<>();
        if(arguments.length > 0) {
            File f = new File(LeoOs.currendDir + "\\" + arguments[0]);
            if(f.isFile()) {
                BufferedReader fR = new BufferedReader(new FileReader(f));
                String output = "";
                while((output=fR.readLine()) != null) {
                    readedFile.add(output);
                }
            }
        }
        return readedFile.toArray(new String[readedFile.size()]);
    }
}
