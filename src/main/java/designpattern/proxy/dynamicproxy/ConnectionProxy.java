package designpattern.proxy.dynamicproxy;

import designpattern.proxy.Connection;
import designpattern.proxy.DataSource;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by jianshen on 11/24/16.
 */
/*
下面是我们针对connection写的动态代理，InvocationHandler接口只有一个invoke方法需要实现，这个方法是用来在生成的代理类用回调使用的，
关于动态代理的原理一会做详细的分析，这里我们先只关注用法。很显然，动态代理是将每个方法的具体执行过程交给了我们在invoke方法里处理。而
具体的使用方法，我们只需要创造一个ConnectionProxy的实例，并且将调用getConnectionProxy方法的返回结果作为数据库连接池返回的连接就
可以了。

上述便是我们针对connection做动态代理的方式，但是我们从中得不到任何好处，除了能少写点代码以外，因为这个动态代理还是只能代理Connection
这一个接口，如果我们写出这种动态代理的方式的话，说明我们应该使用静态代理处理这个问题，因为它代表我们其实只希望代理一个类就好。从重构的
角度来说，其实更简单点，那就是在你发现你使用静态代理的时候，需要写一大堆重复代码的时候，就请改用动态代理试试吧。
 */
public class ConnectionProxy implements InvocationHandler {

    private Connection connection;

    public ConnectionProxy(Connection connection) {
        super();
        this.connection = connection;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //这里判断是Connection接口的close方法的话
        if (Connection.class.isAssignableFrom(proxy.getClass()) && method.getName().equals("close")) {
            //我们不执行真正的close方法
            //method.invoke(connection, args);
            //将连接归还连接池
            DataSource.getInstance().recoveryConnection(connection);
            return null;
        }else {
            return method.invoke(connection, args);
        }
    }

    public Connection getConnectionProxy(){
        return (Connection) Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{Connection.class}, this);
    }

}