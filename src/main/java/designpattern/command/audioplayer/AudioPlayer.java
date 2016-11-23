package designpattern.command.audioplayer;

/**
 * Author: blueaken
 * Date: 3/3/16 10:09 PM
 */
public class AudioPlayer {

    public void play(){
        System.out.println("播放...");
    }

    public void rewind(){
        System.out.println("倒带...");
    }

    public void stop(){
        System.out.println("停止...");
    }

}
