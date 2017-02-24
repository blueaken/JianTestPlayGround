Chap 2. 认识Java虚拟机的基本结构

2.2 学会设置Java虚拟机的参数

2.4 出入Java栈

2.5 类去哪儿了：识别方法区
在JDK1.6、1.7中方法区可以理解为永久区（Perm）。可以使用参数 -XX:PermSize和 -XX:MaxPermSize指定。默认情况下，Perm区为64M。如果系统
使用了动态代理，那么可能会在运行时生成大量的类。这时需要设置一个合理大小的永久区。

PermTest代码使用CGLIB库生成大量的动态类。

在JDK1.8中，元数据区（Meta Space）代替了永久，可以用 -XX:MaxMetaspaceSize指定。和永久区不同，默认情况下，JVM会耗尽所有可用的系统内存。
