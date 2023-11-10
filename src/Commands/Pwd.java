package Commands;

import LeoOS.LeoOs;

public class Pwd implements Command{
    @Override
    public String[] execute(String[] arguments) {
        String[] path = {LeoOs.currendDir.getPath()};
        return path;
    }
}
