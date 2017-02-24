package books.shizhanjvmxuniji.chap2_jibenjiegou;

import books.shizhanjvmxuniji.chap2_jibenjiegou.model.CglibBean;

import java.util.HashMap;

/**
 * Created by jianshen on 2/22/17.
 */
//Note: need set VM options: -XX:+PrintGCDetails -XX:PermSize=5M -XX:MaxPermSize=5M first
// But not works as expected when CglibBean bean = new CglibBean(new HashMap()), only new objects generated, so the
// young GC triggered frequently and works very well.
// 参考这段理解minor GC和full GC的日志。ref － http://blog.csdn.net/yxc135/article/details/12137663

// Need to find a way to let new Class generated, to fill up Perm quickly.

// Fig

public class PermTest {
    public static void main(String[] args) {

        int i = 0;
        HashMap propertyMap = new HashMap();
        try {
            for (i = 0; i < 100000; i++) {
                propertyMap.put("books.shizhanjvmxuniji.chap2_jibenjiegou"+i, Class.forName("java.lang.String"));
            }

            //map转换成实体类
            CglibBean bean = new CglibBean(propertyMap);

        } catch (Exception e) {
            System.out.println("total create count: " + i);
        }
    }

}
