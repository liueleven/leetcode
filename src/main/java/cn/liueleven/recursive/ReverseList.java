package cn.liueleven.recursive;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 *
 * 题目：反转单链表。例如链表为：1->2->3->4。反转后为 4->3->2->1
 *
 * 当 n=1 return 1
 *
 * f(n) = n + f(n-1）
 * @date: 2020-06-18 00:30
 * @author: 十一
 */
public class ReverseList {

    @Test
    public void test1() {
        String r = f(Arrays.asList("1", "2", "3", "4"));
        Assert.assertEquals(r,"4321");
        r = f(Arrays.asList("1", "3", "3", "4","4","44","8"));
        Assert.assertEquals(r,"84444331");
    }
    @Test
    public void test2() {
        Node node = new Node();
        node.data = 1;

        Node node2 = new Node();
        node2.data = 2;
        node2.next = node;


        Node node3 = new Node();
        node3.data = 3;
        node3.next = node2;

        Node node4 = new Node();
        node4.data = 4;
        node4.next = node3;


//        Node r = reverse(node);
//        Node node1 = reverse(node4);
        Node node1 = f3(node4);
        node1.print(node1);

    }


    public Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        // last 是链表最后一个值
        Node last = reverse(head.next);
        // head 会保留最后两个值,head.next = last.next
        Node t1 = head.next;
        // 追加一个反转节点
        t1.next = head;
        // 将多余的置为null
        head.next = null;
        //
        return last;

    }






    public String f(List<String> list) {
        if (list.size() <= 1) {
            return list.get(0);
        }
        String s = list.get(list.size() - 1);
        List<String> newList = new ArrayList<>();
        List<String> strings = list.subList(0, list.size() - 1);

        newList.addAll(strings);

        return s + f(newList);
    }




    public Node f3(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node last = f3(head.next);
        Node t = head.next;
        t.next = head;
        head.next = null;
        return last;

    }


    class Node {
        int data;
        Node next;

        public void print(Node head) {
            while (head != null) {
                System.out.println(head.data);
                head = head.next;
            }
        }
    }



}
