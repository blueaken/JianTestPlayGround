package sort;

/**
 * @author jianshen
 */
public class DistinctArray2 {
    //analysis: 用前后两个指针扫加counter
    public static int removeDuplicates(int[] A) {
        if (A.length < 2) return A.length;

        int i=0, j=1, counter=0;
        while (j<A.length){
            if (A[i] == A[j]){
                if (counter<1) {
                    A[++i] = A[j++];
                    counter++;
                    continue;
                }
                j++;//相同则继续找
            }else{
                counter = 0;
                A[++i] = A[j++];
                //可以理解为下面三步合一：
//                i++;//i移到将要被覆盖的位置
//                A[i] = A[j];//copy
//                j++;//j移动到下一个位置
            }
        }
        return i+1;
    }

    public static void main(String[] args){
        int[] arr = {1,1,1,1,1,2,2,2,2,3};
        int newLength = removeDuplicates(arr);
        System.out.println("no duplicate array 2:");
        for (int i=0; i<newLength; i++){
            System.out.print(arr[i]);
        }
    }
}

