import LeoOS.LeoOs;
public class LeoOsMain {
    public static void main(String[] args) {
        try {
            new LeoOs().start();
        } catch (Exception e) {
            System.out.println("\u001B[31m" + e.getMessage() + "\u001B[0m");
        }
    }
}
