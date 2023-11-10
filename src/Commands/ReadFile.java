package Commands;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public interface ReadFile {

    default ArrayList<String> getFileContent(String path) throws IOException {
        File file = new File(path);
        BufferedReader fileReader = new BufferedReader(new FileReader(file));
        ArrayList<String> content = new ArrayList<>();
        String nextLine;
        if(file.exists() && file.isFile()) {
            while ((nextLine = fileReader.readLine()) != null) {
                content.add(nextLine);
            }
            return content;
        }
        return null;
    }
}
