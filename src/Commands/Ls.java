package Commands;
import LeoOS.LeoOs;
import LeoOS.TextColor;
import java.io.File;

public class Ls implements Command{
    private String fileColor;
    private String directoryColor;

    public Ls(String fileColor, String directoryColor) {
        this.fileColor = fileColor;
        this.directoryColor = directoryColor;
    }

    @Override
    public String[] execute(String[] arguments) {
        File[] files = LeoOs.currendDir.listFiles();
        String[] fileList = new String[files.length];
        for(int i=0; i<fileList.length; i++) {
            if(files[i].isFile()) {
                fileList[i] = fileColor + files[i].getName() + TextColor.getR();
            } else {
                fileList[i] = directoryColor + files[i].getName() + TextColor.getR();
            }
        }
        return fileList;
    }

    void setFileColor(String fileColor) {
        this.fileColor = fileColor;
    }

    void setDirectoryColor(String directoryColor) {
        this.directoryColor = directoryColor;
    }
}
