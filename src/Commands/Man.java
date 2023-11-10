package Commands;

import LeoOS.TextColor;

public class Man implements Command{
    @Override
    public String[] execute(String[] arguments) {
        String[] manMain = {"Das sind alle befehle die es in LeoOS gibt:",
                "pwd: Zeigt den Aktuellen Pfad",
                "cd: Wechselt den Ordner in oder aus einem Ordner",
                "nf: Neue Datei erstellen",
                "nd: Neuen Ordner erstellen",
                "ls: Listet jeden inhalt des Ordners auf",
                "rm: Loescht Dateien oder Ordner",
                "re: Liest den Text aus einer Datei aus",
                "wr: Schreibt neuen Text in eine Datei",
                "cp: Kopiert den Text aus einer Datei in eine Neu erstellte Datei",
                "mv: Verschiebt eine Datei",
                "man: Zeigt befehle von LeoOS an",
                "logout: Loggt den Benutzer aus",
                "time: Gibt die aktuelle Uhrzeit an",
                "game: Listet alle zur verfuegung stehenden Spiele auf zum starten",
                "programs: Listet alle zur verfuegung stehenden Programme auf zum starten",
                "whoami: Wie dein Benutzername lautet",
                "wc: Wie viele Woerter in einer Datei sind",
                "lc: Wie viele Zeilen in einer Datei sind",
                "loc: Wie viele Zeilen Code in einer Datei sind",
                "find: Findet Dateien oder Ordner mit diesem Namen in allen drunter liegenden Ordnern",
                "exit: Loggt den Benutzer aus und schliesst LeoOS",
                "exitE: Schliesst LeoOS.LeoOs ohne Logout(Kann zu speicher Fehlern kommen)",
                "history: Zeigt alle zuletzt verwendeten Befehle an",
                "setting: Stellt die Farbcodes von verschiedenen Ausgaben ein",
                "newUser: Legt einen neuen Benutzer an(Admin rechte verlangt)"};
        return manMain;
    }
}
