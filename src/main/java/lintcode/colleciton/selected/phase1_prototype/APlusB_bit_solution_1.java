package lintcode.colleciton.selected.phase1_prototype;

public class APlusB_bit_solution_1 {
    /**
     * @param a: An integer
     * @param b: An integer
     * @return: The sum of a and b
     */
    // 主要挑战下用异或运算来完成
    // 异或运算有一个别名叫做：不进位加法
    // 那么a ^ b就是a和b相加之后，该进位的地方不进位的结果
    // 然后下面考虑哪些地方要进位，自然是a和b里都是1的地方
    // a & b就是a和b里都是1的那些位置，a & b << 1 就是进位
    // 之后的结果。所以：a + b = (a ^ b) + (a & b << 1)
    // 令a' = a ^ b, b' = (a & b) << 1
    // 可以知道，这个过程是在模拟加法的运算过程，进位不可能
    // 一直持续，所以b最终会变为0。因此重复做上述操作就可以
    // 求得a + b的值。
    public static int aplusb(int a, int b) {
        // write your code here
        if (b == 0) {
            return a;
        }
        while (b != 0) {
            int _a = a ^ b;
            int _b = (a & b) << 1;
            a = _a;
            b = _b;
        }
        return a;
    }

    public static void main(String[] args){
        int a = 233;
        int b = 322;
        System.out.println(aplusb(a, b));
    }
}
