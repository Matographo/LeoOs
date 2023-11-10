package Commands;

import LeoOS.LeoOs;

import java.io.IOException;

public class Exit implements Command{
    @Override
    public String[] execute(String[] arguments) throws IOException {
        new Logout().execute(arguments);
        LeoOs.LOGIN = false;
        LeoOs.END = true;
        return null;
    }
}
