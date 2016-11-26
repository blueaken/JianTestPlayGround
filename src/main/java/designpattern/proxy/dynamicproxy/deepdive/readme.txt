动态代理有一个强制性要求，就是被代理的类必须实现了某一个接口，或者本身就是接口，就像我们的Connection。

道理其实很简单，这是因为动态代理生成的代理类是继承Proxy类的，并且会实现被你传入newProxyInstance方法的所有接口，所以我们可以将生成的
代理强转为任意一个代理的接口或者Proxy去使用，但是Proxy里面几乎全是静态方法，没有实例方法，所以转换成Proxy意义不大，几乎没什么用。假设
我们的类没有实现任何接口，那么就意味着你只能将生成的代理类转换成Proxy，那么就算生成了，其实也没什么用，而且就算你传入了接口，可以强转，
你也用不了这个没有实现你传入接口的这个类的方法。

你可能会说，假设有个接口A，那我将接口A传给newProxyInstance方法，并代理一个没实现接口A的类B，但类B与接口A有一样的方法可以吗？

答案是可以的，并且JDK的动态代理只认你传入的接口，只要你传入，你就可以强转成这个接口，这个一会解释，但是你无法在invoke方法里调用
method.invoke方法，也就是说，你只能全部替换A接口的方法，而不能使用类B中原有与接口A方法描述相同的方法，这是因为invoke中传入的Method的
class信息是接口A，而类B因为没实现接口A，所以无法执行传入的Method，会抛出非法参数异常。


================================

上面我们运行就会发现接口的方法全部都只能输出一个很2的字符串了。如果是要继续使用TestClass的方法也不是不行，只要你确认你传入的类包括了所有
你传入的接口的方法，只是没实现这些接口而已，那么你可以在invoke中这样使用。

public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        Method sourceMethod = source.getClass().getDeclaredMethod(method.getName(), method.getParameterTypes());
        sourceMethod.setAccessible(true);
        Object result = sourceMethod.invoke(source, args);
        System.out.println("after");
        return result;
}

这就与你实现接口的表现行为一致了，但是我们本来就只需要一句method.invoke就可以了，就因为没实现接口就要多写两行，所以这种突破JDK动态代理
必须实现接口的行为就有点画蛇添足了。因为你本来就实现了该接口的方法，只是差了那一句implements而已。

上面写这个例子只是为了解释LZ当初的疑惑，因为LZ曾一度认为不实现接口就不能使用动态代理，现在想想那时候LZ有点2，呵呵。
