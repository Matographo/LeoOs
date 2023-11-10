package Commands;

import LeoOS.LeoOs;
import LeoOS.TextColor;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Array;
import java.util.ArrayList;

public class Find implements Command{
    @Override
    public String[] execute(String[] arguments) throws FileNotFoundException {
        if(arguments.length > 0) {
            String[] foundetPaths;
            if((foundetPaths = find(LeoOs.currendDir + "\\", arguments[0])) == null) {
                throw new FileNotFoundException("Es konnte keine Datei mit diesem Namen gefunden werden");
            } else {
                return foundetPaths;
            }
        }
        return null;
    }
    private String[] find(String path, String find) {
        ArrayList<String> found = new ArrayList<>();
        File f = new File(path);
        File testFile = new File(path + "\\" + find);
        if(testFile.exists()) {
            found.add(path + "\\" + find);
        }
        File[] mengeOrdnerInhalt = f.listFiles();
        if(mengeOrdnerInhalt == null) {
            return found.toArray(new String[found.size()]);
        }
        for(int i=0; i< mengeOrdnerInhalt.length; i++) {
            if(mengeOrdnerInhalt[i].isDirectory()) {
                String[] recursivFind;
                if((recursivFind = find(mengeOrdnerInhalt[i].getPath(), find)) == null) {
                    return found.toArray(new String[found.size()]);
                } else {
                    for(String foundetPath : recursivFind) {
                        found.add(foundetPath);
                    }
                }
            }
        }
        return found.toArray(new String[found.size()]);
    }
}
