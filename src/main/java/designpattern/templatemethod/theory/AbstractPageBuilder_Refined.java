package designpattern.templatemethod.theory;

/**
 * Created by jianshen on 12/2/16.
 */
public abstract class AbstractPageBuilder_Refined implements PageBuilder{

    private static final String DEFAULT_DOCTYPE = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">";

    private static final String DEFAULT_XMLNS = "http://www.w3.org/1999/xhtml";

    private StringBuffer stringBuffer = new StringBuffer();

    public String buildHtml() {
        stringBuffer.append(DEFAULT_DOCTYPE);
        stringBuffer.append("<html xmlns=\"" + DEFAULT_XMLNS + "\">");
        stringBuffer.append("<head>");
        appendTitle(stringBuffer);
        appendMeta(stringBuffer);
        appendLink(stringBuffer);
        appendScript(stringBuffer);
        stringBuffer.append("</head>");
        appendBody(stringBuffer);
        stringBuffer.append("</html>");
        return stringBuffer.toString();
    }

    protected void appendMeta(StringBuffer stringBuffer){}

    protected void appendLink(StringBuffer stringBuffer){}

    protected void appendScript(StringBuffer stringBuffer){}

    protected abstract void appendTitle(StringBuffer stringBuffer);

    protected abstract void appendBody(StringBuffer stringBuffer);

}
