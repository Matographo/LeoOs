package Commands;

import LeoOS.LeoOs;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Inbox implements Command, ReadFile, WriteFile {

    File inboxPath;

    public Inbox() throws IOException {
        inboxPath = new File(LeoOs.userDirectory + "\\Programs\\.inboxData");
        if(!inboxPath.exists()) {
            inboxPath.createNewFile();
        }
    }

    @Override
    public String[] execute(String[] arguments) throws IOException {
        if(arguments.length == 0) {
            inInbox();
        } else {
            String inboxMessage = "";
            for(int i=0; i<arguments.length; i++) {
                inboxMessage += arguments[i];
                writeInInbox(inboxMessage);
            }

        }
        return new String[0];
    }

    private void inInbox () throws IOException {
        boolean inboxActive = true;
        while(inboxActive) {
            showInboxOptions();
            inboxActive = askOption();
        }
    }

    private void writeInInbox(String message) throws IOException {
        ArrayList<String> inboxContent = getFileContent(inboxPath.getPath());
        inboxContent.add(message);
        setFileContent(inboxPath.getPath(), inboxContent);
    }

    private void showInboxOptions() {
        System.out.println("\n\nWaehlen sie ihre Option: \n" +
                "1) In Inbox schreiben\n" +
                "2) Inbox anzeigen\n");
    }

    private boolean askOption() throws IOException {
        boolean inboxActive = true;
        String auswahl = LeoOs.scan.nextLine();
        switch (auswahl) {
            case "1" -> operationInInboxSchreiben();
            case "2" -> showInbox();
            case "0" -> inboxActive = false;
            default -> System.out.println("Sie haben eine falsche eingabe betaetigt. Bitte halten sie sich an die vorgaben");
        }
        return inboxActive;
    }

    private void operationInInboxSchreiben() throws IOException {
        System.out.println("Schreiben sie nun den text fuer ihre Inbox: ");
        writeInInbox(LeoOs.scan.nextLine());
    }

    private void showInbox() throws IOException {
        ArrayList<String> inboxContent = getFileContent(inboxPath.getPath());
        inboxContent.stream().forEach(System.out::println);
    }
}