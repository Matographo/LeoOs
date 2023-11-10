package Commands;

import LeoOS.LeoOs;

import java.io.File;
import java.io.IOException;

public class Nf implements Command{
    @Override
    public String[] execute(String[] arguments) throws IOException {
        File file;
        for(int i=0; i<arguments.length; i++) {
            file = new File(LeoOs.currendDir + "\\" +arguments[i]);
            if(!file.exists()) {
                file.createNewFile();
            }
        }
        return null;
    }
}
