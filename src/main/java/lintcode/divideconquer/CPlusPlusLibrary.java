package lintcode.divideconquer;

public class CPlusPlusLibrary {
    /*
    * lower_bound( begin,end+1,num)：从数组的begin位置到end位置二分查找第一个大于或等于num的数字，找到返回该数字的地址，不存在则返回end。通过返回的地址减去起始地址begin,得到找到数字在数组中的下标。

    * upper_bound( begin,end+1,num)：从数组的begin位置到end位置二分查找第一个大于num的数字，找到返回该数字的地址，不存在则返回end。通过返回的地址减去起始地址begin,得到找到数字在数组中的下标。

    * Java implementation as below, similar but not exactly

    * */

    //二分查找数组中等于key的位置，找到返回该数字的最小地址，不存在则give the upper bound of key
    public int lower_bound(int arr[],int key){
        int low = 0;
        int high = arr.length-1;
        while(low < high){
            int mid = low + (high - low)/2;
            if(arr[mid] >= key){
                high = mid;
            } else{
                low = mid+1;
            }
        }

        //不存在则give the upper bound of key
        if (arr[low] < key) {
            low++;
        }

        return low;
    }

    //二分查找数组中等于key的位置，找到返回该数字的最大地址，不存在则give the lower bound of key
    public static int upper_bound(int arr[],int key){
        int low = 0;
        int high = arr.length-1;
        while(low < high){
            int mid = low + (high - low+1)/2;
            if(arr[mid] <= key){
                low = mid;
            } else{
                high = mid-1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 3, 3, 3, 5, 5, 5, 7, 7, 7, 10};
        CPlusPlusLibrary solution = new CPlusPlusLibrary();
        //lower bound test
        System.out.println("================ lower bound test ==========================");

        System.out.println(solution.lower_bound(nums, 1));//expect 0

        System.out.println(solution.lower_bound(nums, 2));//expect 2 - not exists return ub

        System.out.println(solution.lower_bound(nums, 3));//expect 3

        System.out.println(solution.lower_bound(nums, 5));//expect 6

        System.out.println(solution.lower_bound(nums, 7));//expect 9

        System.out.println(solution.lower_bound(nums, 9));//expect 12 - not exists return ub

        System.out.println(solution.lower_bound(nums, 100));//expect 13 - not exists return ub

        System.out.println("================ upper bound test ==========================");

        //upper bound test
        System.out.println(solution.upper_bound(nums, 1));//expect 2

        System.out.println(solution.upper_bound(nums, 2));//expect 2 - not exists return lb

        System.out.println(solution.upper_bound(nums, 3));//expect 5

        System.out.println(solution.upper_bound(nums, 5));//expect 8

        System.out.println(solution.upper_bound(nums, 7));//expect 11

        System.out.println(solution.upper_bound(nums, 9));//expect 11 - not exists return lb

        System.out.println(solution.upper_bound(nums, 100));//expect 12 - not exists return lb
    }
}
