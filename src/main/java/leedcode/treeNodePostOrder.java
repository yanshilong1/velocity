package leedcode;

import lombok.val;

import java.util.Objects;
import java.util.Stack;

/**
 * @author yanshilong5@jd.com
 * @date 2021/8/16 21:20
 * @since JDK 1.8
 * desc：
 */
public class treeNodePostOrder {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode l = new TreeNode(2);
        TreeNode r = new TreeNode(4);
        TreeNode ll = new TreeNode(5);
        TreeNode lr = new TreeNode(3);
        root.left = l;
        root.right = r;
        l.left = ll;
        l.right = lr;
        postOrder(root);

    }


    public static  void postOrder(TreeNode root) {
        if (Objects.isNull(root)) {
            return;
        }
        Stack<TreeNode> stack1=new Stack<>();
        Stack<TreeNode> stack2=new Stack<>();

        stack1.push(root);
        while (!stack1.isEmpty()){
            TreeNode node = stack1.pop();
            stack2.push(node);

            if(node.left!=null){
                stack1.push(node.left);
            }
            if(node.right!=null){
                stack1.push(node.right);
            }
        }

        while (!stack2.isEmpty()){
            System.out.println(stack2.pop().val);
        }


    }

    static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;
        public TreeNode(int val){
            this.val= val;
        }
    }
}

