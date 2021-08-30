package leedcode;

import org.springframework.util.CollectionUtils;

/**
 * @author yanshilong5@jd.com
 * @date 2021/8/16 14:53
 * @since JDK 1.8
 * desc：
 */
public class findMin {

      static int findMinValue(int[] nums){
          if(nums.length==0){
              return -1;
          }
          int high=nums.length-1;
          int low=0;
          while (low<high){
              int pivot=low+(high-low)/2;
              if(nums[pivot]<nums[low]){
                  high=pivot;
              }else {
                  low=pivot+1;
              }
          }
          return nums[low];
      }



    public static void main(String[] args) {
          int[] num={5,6,7,8,9,1,3,4};
        System.out.println(findMinValue(num));
    }

}
