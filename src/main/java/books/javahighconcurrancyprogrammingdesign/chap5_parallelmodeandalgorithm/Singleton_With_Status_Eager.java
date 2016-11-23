package books.javahighconcurrancyprogrammingdesign.chap5_parallelmodeandalgorithm;

/**
 * Author: blueaken
 * Date: 5/24/16 22:59
 */
public class Singleton_With_Status_Eager {
    public static int STATUS = 1;
    private Singleton_With_Status_Eager() {
        System.out.println("Eager Singleton is creating");
    }
    private static Singleton_With_Status_Eager instance = new Singleton_With_Status_Eager();
    public static Singleton_With_Status_Eager getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        System.out.println(Singleton_With_Status_Eager.STATUS);
    }
}
