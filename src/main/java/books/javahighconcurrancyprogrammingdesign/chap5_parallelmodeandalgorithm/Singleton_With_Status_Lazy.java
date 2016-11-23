package books.javahighconcurrancyprogrammingdesign.chap5_parallelmodeandalgorithm;

/**
 * Author: blueaken
 * Date: 5/24/16 23:04
 */
public class Singleton_With_Status_Lazy {
    //fix the requirement of instance is only created when getInstance is called
    public static int STATUS = 1;
    private Singleton_With_Status_Lazy() {
        System.out.println("Lazy Singleton is creating");
    }
    private static Singleton_With_Status_Lazy instance = null;
    public static synchronized Singleton_With_Status_Lazy getInstance() {
        if (instance == null) {
            instance = new Singleton_With_Status_Lazy();
        }
        return instance;
    }

    public static void main(String[] args) {
        System.out.println(Singleton_With_Status_Lazy.STATUS);
    }
}
