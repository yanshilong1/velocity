package leedcode;

import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.lang3.math.NumberUtils.max;

/**
 * @author yanshilong5@jd.com
 * @date 2021/8/16 21:49
 * @since JDK 1.8
 * desc：有序区间合并
 */
public class intervalMerge {

    public static void main(String[] args) {
        List<Interval> list = new ArrayList<>();
        Interval l1 = new Interval(1, 3);
        Interval l2 = new Interval(2, 6);
        Interval l3 = new Interval(8, 10);
        Interval l4 = new Interval(15, 18);
        list.add(l1);
        list.add(l2);
        list.add(l3);
        list.add(l4);
        merger(list);
    }


    static void merger(List<Interval> list) {
        List<Interval> targetList = new ArrayList<>(list.size());
        if (list.size() < 1) {
            return;
        }

        Interval temp = list.get(0);
        for (int i = 1; i < list.size(); ++i) {
            if (temp.end >= list.get(i).start) {
                temp = new Interval(temp.start, max(temp.end, list.get(i).end));
            } else {
                targetList.add(temp);
                temp = list.get(i);
            }

        }
        targetList.add(temp);

        targetList.forEach(t -> {
            System.out.println("[" + t.start + "  " + t.end + "]");
        });


    }


    static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

    }
}
