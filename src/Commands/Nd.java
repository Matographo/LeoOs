package Commands;

import LeoOS.LeoOs;
import java.io.File;
import java.nio.file.FileAlreadyExistsException;

public class Nd implements Command{
    @Override
    public String[] execute(String[] arguments) throws FileAlreadyExistsException {
        File file;
        System.out.println("Dein eingegebenes Argument: " + arguments[0]);
        for(int i=0; i<arguments.length; i++) {
            file = new File(LeoOs.currendDir + "\\" +arguments[i]);
            if(!file.exists()) {
                file.mkdir();
                System.out.println("Ihr ordner wurde hinzugefuegt");
            } else {
                throw new FileAlreadyExistsException("Dieser Ordner existiert bereits!");
            }
        }
        return null;
    }
}
