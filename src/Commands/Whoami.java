package Commands;

import LeoOS.LeoOs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Whoami implements Command{
    @Override
    public String[] execute(String[] arguments) throws IOException {
        File user = new File(LeoOs.userDirectory + "\\Settings\\.userName.txt");
        BufferedReader br = new BufferedReader(new FileReader(user));
        String[] userName = br.readLine().split(" ");
        return userName;
    }
}
