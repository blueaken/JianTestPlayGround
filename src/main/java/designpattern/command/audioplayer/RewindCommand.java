package designpattern.command.audioplayer;

/**
 * Author: blueaken
 * Date: 3/3/16 10:15 PM
 */
public class RewindCommand implements Command {

    private AudioPlayer myAudio;

    public RewindCommand(AudioPlayer audioPlayer){
        myAudio = audioPlayer;
    }
    @Override
    public void execute() {
        myAudio.rewind();
    }

}
