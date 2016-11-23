package designpattern.command.audioplayer;

/**
 * Author: blueaken
 * Date: 3/3/16 10:20 PM
 */
public class MacroAudioCommand implements MacroCommand {

    @Override
    public void add(Command command) {
        cmdList.add(command);
    }

    @Override
    public void remove(Command command) {
        cmdList.remove(command);
    }

    @Override
    public void execute() {
        for (Command command : cmdList) {
            command.execute();
        }
    }
}
