package interviewprep.morganstanley.iterator;

/**
 * @author jianshen
 */
public class ObjectTest implements IObjectTest {
    @Override
    public boolean test(Object o){
        return (o instanceof Integer);
    }
}
