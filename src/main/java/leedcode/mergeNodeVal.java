package leedcode;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.Objects;

/**
 * @author yanshilong5@jd.com
 * @date 2021/8/2 20:54
 * @since JDK 1.8
 * desc：
 */
public class mergeNodeVal {



    public static class ListNode{
        private ListNode next;
        private int val;
        ListNode(){
        }
        ListNode(int val){
            this.val=val;
        }
    }
    public static ListNode addTwoList(ListNode p,ListNode q) {
        if (Objects.isNull(p) || Objects.isNull(q)) {
            return p == null ? p : q;
        }
        ListNode targetNode = new ListNode();
        ListNode ren = targetNode;

        while (p != null || q != null) {
            int pValue = p == null ? 0 : p.val;
            int qValue = q == null ? 0 : p.val;

            if (pValue > qValue) {
                //q在后
                targetNode.next = q;
                q = q.next;
                targetNode = targetNode.next;

            } else {
                targetNode.next = p;
                p = p.next;
                targetNode = targetNode.next;
            }
        }
        return  ren.next;
    }

    public static void main(String[] args) {

        ListNode p = new ListNode(3);
        ListNode p1=new ListNode(3);
        ListNode q=new ListNode(1);
        ListNode q1=new ListNode(2);
        p.next=p1;
        q.next=q1;
        ListNode re= addTwoNumbers(p,q);

        while (re!=null){
            System.out.println(re.val);
            re=re.next;
        }




    }

}
