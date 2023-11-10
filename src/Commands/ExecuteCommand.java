package Commands;

import LeoOS.TextColor;
import User.UserSettings;

import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;

public class ExecuteCommand {

    private String[] argumentList;
    private String command;
    private String[] appendix;
    private Command commandFunction;
    UserSettings uS;


    public void execute(String argument, UserSettings uS) throws IOException {
        History history = new History(argument);
        history.addHistory(argument);
        this.uS = uS;
        argumentList = argTeiler(argument);
        command = argumentList[0];
        appendix = new String[argumentList.length-1];
        commandFunction = null;
        if(argumentList.length > 1) {
            System.arraycopy(argumentList, 1, appendix, 0, argumentList.length-1);
        } else {
            argumentList = null;
        }
        switch (command) {
            case "pwd" ->      commandFunction = new Pwd();
            case "cd" ->       commandFunction = new Cd();
            case "nf" ->       commandFunction = new Nf();
            case "nd" ->       commandFunction = new Nd();
            case "ls" ->       commandFunction = new Ls(uS.getFileColor(), uS.getDirectoryColor());
            case "rm" ->       commandFunction = new Rm();
            case "re" ->       commandFunction = new Re();
            case "wr" ->       commandFunction = new Wr();
            case "cp" ->       commandFunction = new Cp();
            case "mv" ->       commandFunction = new Mv();
            case "man" ->      commandFunction = new Man();
            case "logout" ->   commandFunction = new Logout();
            case "time" ->     commandFunction = new Time();
            case "game" ->     commandFunction = new Game();
            case "programs" -> commandFunction = new Programs();
            case "whoami" ->   commandFunction = new Whoami();
            case "count" ->    commandFunction = new Count();
            case "find" ->     commandFunction = new Find();
            case "exit" ->     commandFunction = new Exit();
            case "history" ->  commandFunction = new History();
            case "settings" -> commandFunction = new Settings(uS);
            case "newUser" ->  commandFunction = new NewUser();
            case "inbox" ->    commandFunction = new Inbox();
            case "" -> System.out.print("");
            default -> System.out.println(uS.getErrorColor() + "Command nicht erkannt!" + TextColor.getR());
        }
        if(commandFunction != null) {
            executeCommands(commandFunction, appendix);
        }
    }

    private String[] stringToArguments(String line) {
        String[] arguments;
        ArrayList<String> argumentCollector = new ArrayList<>();
        arguments = line.split("\"");
            if(arguments.length > 1 && arguments.length%2 != 0) {
                throw new IllegalArgumentException("Sie haben die Anfuehrungszeichen nicht richtig verwendet!");
            }
        for (int i=0; i<arguments.length; i++) {
            arguments[i] = arguments[i].strip();
            if(i%2 != 0 || i==0) {
                argumentCollector.add(arguments[i]);
            } else {
                String[] subarguments = arguments[i].split(" ");
                for (String subToken : subarguments) {
                    if(!(subToken == null || subToken.isEmpty())) {
                        argumentCollector.add(subToken);
                    }
                }
            }

        }
        return argumentCollector.toArray(new String[argumentCollector.size()]);
    }

    private void executeCommands(Command command, String[] commandLine) {
        String[] output;
        try{
            output = command.execute(commandLine);
            if(output != null) {
                for (String line : output) {
                    if (line != null) {
                        System.out.println(line);
                    }
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println(uS.getErrorColor() + e);
        } catch (FileAlreadyExistsException e) {
            System.out.println(uS.getErrorColor() + e);
        } catch (DirectoryNotEmptyException e) {
            System.out.println(uS.getErrorColor() + e);
        } catch (IOException e) {
            System.out.println(uS.getErrorColor() + e);
        } finally {
            System.out.println(TextColor.getR());
        }
    }

    private String[] argTeiler(String s) {
        String[] command;
        if(s.contains("\"")) {
            command = s.split("\"");
            command[0] = command[0].strip();
            return command;
        } else {
            return command = s.split(" ");
        }
    }
}
