package designpattern.command.audioplayer;

/**
 * Author: blueaken
 * Date: 3/3/16 10:14 PM
 */
public class PlayCommand implements Command {

    private AudioPlayer myAudio;

    public PlayCommand(AudioPlayer audioPlayer){
        myAudio = audioPlayer;
    }

    /**
     * 执行方法
     */
    @Override
    public void execute() {
        myAudio.play();
    }

}
