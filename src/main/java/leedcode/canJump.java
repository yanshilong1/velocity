package leedcode;

import static org.apache.commons.lang3.math.NumberUtils.max;

/**
 * @author yanshilong5@jd.com
 * @date 2021/8/16 15:39
 * @since JDK 1.8
 * desc：leedCode55
 */
public class canJump {

    static boolean canJump(int[] arr) {
        int N = arr.length;
        int maxRatch = 0;
        for (int i = 0; i < N; ++i) {
            //超过最大可以跳跃的距离了
            if (i > maxRatch) {
                return false;
            }
            maxRatch = max(maxRatch, i + arr[i]);
            if (maxRatch > N - 1) {
                return true;
            }

        }
        return false;
    }

    public static void main(String[] args) {

        int[] arr = {2, 3, 1, 1, 4};
        System.out.println(canJump(arr));
    }
}
