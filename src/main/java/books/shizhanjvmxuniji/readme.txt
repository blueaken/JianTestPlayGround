跟踪调试参数：
＝＝GC相关＝＝
-XX:+PrintGC
-XX:+PrintGCDetails
-XX:+PrintHeapAtGC
-Xloggc:log/gctest.log (没有调试出来)
- try -Xloggc:/Users/jianshen/log/gctest.log

＝＝类加载／卸载跟踪＝＝
-XX:+TraceClassLoading
-XX:+TraceClassUnloading

＝＝JVM Dump when Heap OOM ==
-XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/Users/jianshen/log/oom.dump
