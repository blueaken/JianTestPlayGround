package designpattern.templatemethod.theory;

/**
 * Created by jianshen on 12/2/16.
 */
public class MyPageBuilder_Refined extends AbstractPageBuilder_Refined{

    protected void appendMeta(StringBuffer stringBuffer) {
        stringBuffer.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />");
    }

    protected void appendTitle(StringBuffer stringBuffer) {
        stringBuffer.append("<title>你好</title>");
    }

    protected void appendBody(StringBuffer stringBuffer) {
        stringBuffer.append("<body>你好，世界！</body>");
    }

    public static void main(String[] args) {
        PageBuilder pageBuilder = new MyPageBuilder_Refined();
        System.out.println(pageBuilder.buildHtml());
    }

}