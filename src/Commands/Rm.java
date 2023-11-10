package Commands;

import LeoOS.LeoOs;
import LeoOS.TextColor;

import java.io.File;

public class Rm implements Command{
    @Override
    public String[] execute(String[] arguments) {
        if(arguments.length > 0) {
            for(int i=0; i < arguments.length; i++) {
                File f = new File(LeoOs.currendDir + "\\" + arguments[i]);
                if (f.isFile()) {
                    f.delete();
                } else if (f.isDirectory()) {
                    System.out.println("Wollen sie alles in dem Ordner " + f.getName() + " loeschen?\n(y/n) -> ");
                    if (LeoOs.scan.nextLine().equals("y")) {
                        System.out.println(deleteD(f) + "Dateien/Ordner wurden geloescht");
                    }
                }
            }
        }
        return null;
    }

    private int deleteD(File f) {
        File[] file = f.listFiles();
        int geloescht = 0;
        for (File a : file) {
            if(a.isDirectory()) {
                geloescht += deleteD(a);
            } else if (a.isFile()) {
                a.delete();
                geloescht++;
            }
        }
        f.delete();
        return geloescht+1;
    }
}
