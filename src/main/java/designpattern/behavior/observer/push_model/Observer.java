package designpattern.behavior.observer.push_model;

/**
 * Author: blueaken
 * Date: 3/1/16 10:00 PM
 */
public interface Observer {
    /**
     * 更新接口
     * @param state    更新的状态
     */
    public void update(String state);
}
