package LeoOS;

public class TextColor {
    private String color;

    /**
     * Hier wird der Klasse uebergeben, welche Farben fuer den Text und welche Farbe fuer den Hintergrund
     * benutzt werden soll
     *
     * 0=Schwarz; 1=Rot; 2=Gruen; 3=Gelb; 4=Blau; 5=Lila; 6=Cyan; 7=Grau
     *
     * @param t Die Farbe fuer den Text
     * @param b Die Farbe fuer den Hintergrund
     */
    public TextColor(int t, int b) {
        switch (t) {
            case 0 -> color = "\u001B[30m";
            case 1 -> color = "\u001B[31m";
            case 2 -> color = "\u001B[32m";
            case 3 -> color = "\u001B[33m";
            case 4 -> color = "\u001B[34m";
            case 5 -> color = "\u001B[35m";
            case 6 -> color = "\u001B[36m";
            case 7 -> color = "\u001B[37m";
            default -> color = "";
        }
        switch (b) {
            case 0 -> color += "\u001B[40m";
            case 1 -> color += "\u001B[41m";
            case 2 -> color += "\u001B[42m";
            case 3 -> color += "\u001B[43m";
            case 4 -> color += "\u001B[44m";
            case 5 -> color += "\u001B[45m";
            case 6 -> color += "\u001B[46m";
            case 7 -> color += "\u001B[47m";
            default -> color += "";
        }
    }

    /**
     * Hier wird die Zahl fuer den Hintergrund uebergeben. Der Boolean ist irrelevant,
     * er ist nur dafuer da, um zu sagen, dass es fuer den Hintergrund ist
     * @param b Die Farbe fuer den Hintergrund
     * @param x Dass es ein Hintergrund ist
     */
    public TextColor(int b, boolean x) {
        this(-1, b);
    }

    /**
     * Hier wird nur die Farbe fuer den Text uebergeben
     * @param t Die Farbe des Textes
     */
    public TextColor(int t) {
        this(t,-1);
    }

    /**
     * Hier bekommt man den String der die Farbe Codiert zurueck
     * @return Die Farbe
     */
    public String getColor() {
        return color;
    }

    /**
     * Gibt den reset text zurueck um die farben wieder auf Default zu setzen
     * @return Reset code
     */
    public static String getR() {
        return "\u001B[0m";
    }
}
