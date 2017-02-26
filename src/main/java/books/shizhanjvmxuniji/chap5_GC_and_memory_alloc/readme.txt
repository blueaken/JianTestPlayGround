5.5.6 方法finzlize()对垃圾回收的影响

run with "-Xmx10m -Xms10m -XX:+PrintGCDetails -XX:+HeapDumpOuOutOfMemoryError -XX:+HeapDumpPath=/Users/jianshen/log/longfinalize.dump"

每次产生的LF对象都会在下一次循环中失效，因此所有产生的LF对象都应该可以回收。为什么还会出现OOM呢？

从MAT分析dump结果可以看出，系统中有大量等待执行的Finalizer类，使FinalizerThread执行队列可能一直持有对象而来不及执行，从而堆积起来，最终导致了这个OOM。

