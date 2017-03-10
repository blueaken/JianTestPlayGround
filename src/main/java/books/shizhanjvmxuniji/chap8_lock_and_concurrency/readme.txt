ThreadUnSafe
- ArrayList is thread unsafe an Exception will be thrown
- Vector can fix
- Add synchronized on Class level will also fix

Atomic
写了两个线程分别测试CAS和synchronized的表现，理论上CAS操作应该比传统sychronized性能要好。实际测试结果是相反的，也许是Java 1.7之后对
synchronized的性能优化导致的？

注：Java 1.8对这方面进行了进一步的优化，提供了LongAddr类，它用类似ConcurrentHashMap减少锁粒度的方法，为每个线程分配一个数组中的一个
单元。计算最终结果时，统计所有数组元素的和。参考P：278代码。

