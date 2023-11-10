package Commands;

import java.io.*;
import java.util.ArrayList;

public interface WriteFile {

    default void setFileContent(String path, ArrayList<String> content) throws IOException {
        File file = new File(path);
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file));
        if(file.exists() && file.isFile()) {
            for(String line : content) {
                fileWriter.write(line + "\n");
            }
            fileWriter.close();
        } else {
            throw new FileNotFoundException("Der Pfad Existiert nicht");
        }
    }
}
