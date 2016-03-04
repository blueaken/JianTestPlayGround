package designpattern.command.audioplayer;

/**
 * Author: blueaken
 * Date: 3/3/16 10:15 PM
 */
public class StopCommand implements Command {
    private AudioPlayer myAudio;

    public StopCommand(AudioPlayer audioPlayer){
        myAudio = audioPlayer;
    }
    @Override
    public void execute() {
        myAudio.stop();
    }

}
