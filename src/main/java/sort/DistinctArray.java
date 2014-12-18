package sort;

import java.util.Arrays;

/**
 * @author jianshen
 */
public class DistinctArray {
    //analysis: 用前后两个指针扫一遍即可
    public static int removeDuplicates(int[] A) {
        if (A.length < 2) return A.length;

        int i=0, j=1;
        while (j<A.length){
            if (A[i] == A[j]){
                j++;//相同则继续找
            }else{
                A[++i] = A[j++];
                //可以理解为下面三步合一：
//                i++;//i移到将要被覆盖的位置
//                A[i] = A[j];//copy
//                j++;//j移动到下一个位置
            }
        }
        return i+1;
    }

    //这个是我最初的解法：比较后一个指针的前后两个数
    public static int removeDuplicates_ddd(int[] A) {
        if (A.length < 2) return A.length;

        int i=0, j=0;
        while (j<A.length){
            if (A[j] == A[j+1]){
                j++;//相同则继续找
            }else{
                A[++i] = A[j++];
                //可以理解为下面三步合一：
//                i++;//i移到将要被覆盖的位置
//                A[i] = A[j];//copy
//                j++;//j移动到下一个位置
            }
        }
        return i+1;
    }

    //这个解法其实和上面一样，只是把while循环换成if循环而已
//    public static int removeDuplicates(int A[]) {
//        int n = A.length;
//             if(n ==0) return 0;
//             int index = 0;
//             for(int i =0;i<n; i++)
//                 {
//                    if(A[index] == A[i])
//                       {
//                         continue;
//                       }
//                    index++;
//                    A[index] = A[i];
//                  }
//             return index+1;
//         }

    public static void main(String[] args){
        int[] arr = {1,2,2,2,3,4,4,5};
        int newLength = removeDuplicates(arr);
        System.out.println("no duplicate array:");
        for (int i=0; i<newLength; i++){
            System.out.print(arr[i]);
        }
    }
}

