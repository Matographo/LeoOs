package Commands;

import LeoOS.LeoOs;
import LeoOS.TextColor;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;

public class Cp implements Command, ReadFile, WriteFile{
    @Override
    public String[] execute(String[] arguments) throws IOException {
        if(arguments.length > 1) {
            File f = new File(LeoOs.currendDir + "\\" + arguments[0]);
            File f2 = new File(LeoOs.currendDir + "\\" + arguments[1]);
            setFileContent(f2.getPath(),getFileContent(f.getPath()));
        }
        return null;
    }
}
