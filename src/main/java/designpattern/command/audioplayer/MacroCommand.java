package designpattern.command.audioplayer;

import java.util.List;
import java.util.ArrayList;

/**
 * Author: blueaken
 * Date: 3/3/16 10:18 PM
 */
public interface MacroCommand extends Command {
    List<Command> cmdList = new ArrayList<>();

    public void add(Command command);

    public void remove(Command command);
}
