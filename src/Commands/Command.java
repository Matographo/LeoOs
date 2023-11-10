package Commands;

import java.io.IOException;

public interface Command {
    String[] execute(String[] arguments) throws IOException;
}
