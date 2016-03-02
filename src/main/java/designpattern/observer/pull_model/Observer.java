package designpattern.observer.pull_model;

/**
 * Author: blueaken
 * Date: 3/1/16 10:05 PM
 */
public interface Observer {
    /**
     * 更新接口
     * @param subject  传入主题对象，方面获取相应的主题对象的状态
     */
    public void update(Subject subject);
}
