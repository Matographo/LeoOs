package Commands;
import LeoOS.LeoOs;
import java.io.File;
import java.io.FileNotFoundException;

public class Cd implements Command{
    @Override
    public String[] execute(String[] arguments) throws FileNotFoundException {
        if(arguments.length > 0) {
            if(arguments[0].equals("..")) {
                if(!LeoOs.currendDir.toString().equals("C:\\")) {
                    LeoOs.currendDir = LeoOs.currendDir.getParentFile();
                    return null;
                }
            } else if (arguments[0].equals("...")) {
                if(!LeoOs.currendDir.getParentFile().getAbsolutePath().equals("C:\\")) {
                    LeoOs.currendDir = LeoOs.currendDir.getParentFile().getParentFile();
                    return null;
                }
            } else {
                File newP = new File(LeoOs.currendDir.toString() + "\\" + arguments[0]);
                if (newP.isDirectory()) {
                    LeoOs.currendDir = newP;
                } else {
                    throw new FileNotFoundException("Der Ordner " + newP.toString() + " existiert nicht");
                }
            }
        }
        return null;
    }
}
