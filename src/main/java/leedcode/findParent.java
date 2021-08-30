package leedcode;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


/**
 * @author yanshilong5@jd.com
 * @date 2021/8/2 21:28
 * @since JDK 1.8
 * desc：
 */
public class findParent {
    @Data
    static class Node {
        int val;
        Node parent;

        public Node() {
        }
        public Node(int value){
            this.val=value;
        }
    }

    static List<Node> findParentNodeList(List<Node> nodeList,int val){
        List<Node> targetNodeList=new ArrayList<>();
        nodeList.forEach(node -> {
            if(node.val==val || isChildren(node, val)){
                targetNodeList.add(node);
            }
        });
        return targetNodeList;
    }

    static boolean isChildren(Node node,int val){
         if(node.val==val){
             return true;
         }
         if(node.parent!=null){
             node=node.parent;
             return isChildren(node,val);
         }
         return false;
    }


    public static void main(String[] args) {
        Node node=new Node(0);
        Node node1=new Node(1);
        Node node2=new Node(2);
        Node node3=new Node(3);
        Node node4=new Node(4);
        node4.parent=node3;
        node3.parent=node2;
        node2.parent=node1;
        node1.parent=node;
        List nodeList= Arrays.asList(node,node1,node2,node3,node4);
        List<Node> n=findParentNodeList(nodeList,node2.val);
        n.forEach(nodes->{
            System.out.println(nodes.val);
        });





    }

}
