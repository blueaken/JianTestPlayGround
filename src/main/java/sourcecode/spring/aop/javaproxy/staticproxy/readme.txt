ebay onsite 笔试，用JAVA实现一简单的PROXY.

先不用InvocationHandler等方法，用简单对象来实现。

问： 不使用proxy，只用简单的对象该如何写呢？
答：先从原理上说，你是想另外有一个类控制说话这个行为，而人不负责这个，就需要把人这个对象交给另外一个对象来控制啊，静态代理已经是很简单的
实现了这个功能吧，你为什么不想用代理？

调用say方法的地方是指你main方法里面，原来的写法是
List<Child> children= new ArrayList<Child>();
children.add(new Boy());
children.add(new Girl());
for(child c : children){
    c.say();
}

换成以下这种写法
List<Child> children= new ArrayList<Child>();
children.add(new ProxyChild(new Boy()));
children.add(new ProxyChild(new Girl()));//把Boy和Girl的对象，交给ProxyChild对象代理
for(Child c : children){
    c.say();
}

REF: http://zhidao.baidu.com/question/554612469.html
