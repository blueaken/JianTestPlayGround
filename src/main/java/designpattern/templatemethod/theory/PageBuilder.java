package designpattern.templatemethod.theory;

/**
 * Created by jianshen on 12/2/16.
 */
public interface PageBuilder {
    /*
     * 这个接口很简单，就是直接制造一个Html页面的内容，假设我们不使用模板方法模式，直接让各个子类去直接实现这个接口，那么肯定实现的方式
     * 千奇百怪，而且步骤也乱七八糟的，这样实在不利于维护和扩展。所以我们可以使用模板方法模式，将这个过程给制定好，然后把具体的内容填充交
     * 给子类就好，这样这些子类生成的HTML页面就会非常一致。
     */
    String buildHtml ();

}
