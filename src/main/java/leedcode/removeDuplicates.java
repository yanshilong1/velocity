package leedcode;

/**
 * @author yanshilong5@jd.com
 * @date 2021/8/2 15:15
 * @since JDK 1.8
 * desc：
 */
public class removeDuplicates {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 5, 6, 6, 6, 7, 7, 8, 9};
        int j = remove(arr);
        for (int i = 0; i < j; i++) {
            System.out.println(arr[i]);
        }

    }

    /**
     * Description: int 类型方法，返回新的数组长度
     *
     * @return a
     * @pram a
     * @author: yanshilong5@jd.com
     * @creation: 2021/8/2 15:52
     */

    static int remove(int[] arr) {
        int j = 1;//新的数组指针，从1开始
        int count = 1;//老的数组指针，从1开始
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {//涉及重复
                count++;
            } else {//不重复的情况
                count = 1;
            }
            //不重复的key，赋值给j
            if (count < 2) {
                arr[j] = arr[i];
                j++;
            }
        }
        //返回新数组长度
        return j;

    }

    //高可用、高扩展、高并发、高性能


    int partition(int arr[], int left, int right)  //找基准数 划分
    {
        int i = left + 1;
        int j = right;
        int temp = arr[left];
        while (i <= j) {
            while (arr[i] < temp) {
                i++;
            }
            while (arr[j] > temp) {
                j--;
            }
            if (i < j) {
                swap(arr[i++], arr[j--]);
            }
            else i++;
        }
        swap(arr[j], arr[left]);
        return j;
    }

    void quick_sort(int arr[], int left, int right) {
        if (left > right)
            return;
        int j = partition(arr, left, right);
        quick_sort(arr, left, j - 1);
        quick_sort(arr, j + 1, right);
    }


    public void swap(int a,int b){

    }
}
