package lintcode.divideconquer;

import java.util.Arrays;

public class CPlusPlusLibrary {
    /*
    * lower_bound( begin,end+1,num)：从数组的begin位置到end位置二分查找第一个大于或等于num的数字，找到返回该数字的地址，不存在则返回end。通过返回的地址减去起始地址begin,得到找到数字在数组中的下标。

    * upper_bound( begin,end+1,num)：从数组的begin位置到end位置二分查找第一个大于num的数字，找到返回该数字的地址，不存在则返回end。通过返回的地址减去起始地址begin,得到找到数字在数组中的下标。

    * Java implementation as below, similar but not exactly

    * */

    //Using build in Arrays.binarySearch()
    public int lower_bound(int arr[], int start, int end, int key){
        int diff = start;

        int[] temp = Arrays.copyOfRange(arr, start, end+1);

        int index = Arrays.binarySearch(temp, key);

        if (index < 0) {//key not in arr, java bs returned "-insertion point", and the insertion point is 1-indexed; need to convert it to 0 based index
            index = Math.abs(index) - 1;
        } else { //key in arr, return the index of the smallest element index equal to key
            while (index >= 0 && temp[index] == key) {
                index--;
            }
            index++;
        }
        return index + diff;
    }

    //Using build in Arrays.binarySearch()
    public static int upper_bound(int arr[], int start, int end, int key){
        int diff = start;

        int[] temp = Arrays.copyOfRange(arr, start, end+1);

        int index = Arrays.binarySearch(temp, key);

        if (index < 0) {//key not in arr, java bs returned "-insertion point", and the insertion point is 1-indexed; need to convert it to 0 based index
            index = Math.abs(index) - 1;
        } else { //key in arr, return the index of the 1st element greater than key
            while (index < temp.length && temp[index] == key) {
                index++;
            }
        }
        return index + diff;
    }

    public static void main(String[] args) {
        CPlusPlusLibrary solution = new CPlusPlusLibrary();

        int[] nums = {0,1,2,3,4,5};
        int len = nums.length;

        System.out.println("=================================================");

        System.out.println(solution.lower_bound(nums, 2, 4, 5)); //5

        System.out.println(solution.lower_bound(nums, 2, 4,4)); //4

        System.out.println(solution.lower_bound(nums, 2, 4,3)); //3

        System.out.println(solution.lower_bound(nums, 2, 4,2)); //2

        System.out.println(solution.lower_bound(nums, 2, 4,1)); //2

        System.out.println(solution.lower_bound(nums, 2, 4,9)); //5

        System.out.println(solution.lower_bound(nums, 2, 4,-9)); //2

        System.out.println("=================================================");

        System.out.println(solution.lower_bound(nums, 0, len-1, 5)); //5

        System.out.println(solution.lower_bound(nums, 0, len-1,4)); //4

        System.out.println(solution.lower_bound(nums, 0, len-1,3)); //3

        System.out.println(solution.lower_bound(nums, 0, len-1,2)); //2

        System.out.println(solution.lower_bound(nums, 0, len-1,1)); //1

        System.out.println(solution.lower_bound(nums, 0, len-1,9)); //6

        System.out.println(solution.lower_bound(nums, 0, len-1,-9)); //0


//        System.out.println("=================================================");
//
//        System.out.println(solution.upper_bound(nums, 2, 4, 5)); //5
//
//        System.out.println(solution.upper_bound(nums, 2, 4,4)); //5
//
//        System.out.println(solution.upper_bound(nums, 2, 4,3)); //4
//
//        System.out.println(solution.upper_bound(nums, 2, 4,2)); //3
//
//        System.out.println(solution.upper_bound(nums, 2, 4,1)); //2
//
//        System.out.println(solution.upper_bound(nums, 2, 4,9)); //5
//
//        System.out.println("=================================================");
//
//        System.out.println(solution.upper_bound(nums, 0, len-1, 5)); //6
//
//        System.out.println(solution.upper_bound(nums, 0, len-1,4)); //5
//
//        System.out.println(solution.upper_bound(nums, 0, len-1,3)); //4
//
//        System.out.println(solution.upper_bound(nums, 0, len-1,2)); //3
//
//        System.out.println(solution.upper_bound(nums, 0, len-1,1)); //2
//
//        System.out.println(solution.upper_bound(nums, 0, len-1,9)); //6
//
//        System.out.println(solution.upper_bound(nums, 0, len-1,-9)); //0

    }
}
