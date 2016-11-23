package sort;

/**
 * Created by jshe18 on 8/2/15.
 */
public class BinarySearch_WhileLoop {
    public static void main(String[] args){
        int[] nums = {-3,1,2,3,4,5,7};

        System.out.println("location of the target is: " + search(nums,2));
    }

    public static int search(int[] data, int target){
        if (data == null || data.length==0){
            return -1;
        }

        int left=0;
        int right=data.length-1;
        int mid;
        while (left<=right){
            mid = (left+right)/2;
            if (data[mid] == target){
                return mid;
            }else if (data[mid] < target){
                left = mid+1;
            }else {
                right = mid-1;
            }
        }

        return -1;
    }
}
