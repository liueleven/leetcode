package cn.liueleven.date201902.p2;



import java.util.Arrays;

/**
 * @description: 两个list中下标相同的两数相加，将结果输出到新的list
 *                  主要考察链表操作
 * @date: 2019-02-16 11:40
 * @author: 十一
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        // 构造输入
        int [] nums1 = {1,2,3};
        int [] nums2 = {9,2,2};
        ListNode l1 = new ListNode(0);
        ListNode tmp1 = l1;
        for (int i=0; i<nums1.length; i++) {
            tmp1.next = new ListNode(nums1[i]);
            tmp1 = tmp1.next;
        }
        ListNode l2 = new ListNode(0);
        ListNode tmp2 = l2;
        for (int i=0; i<nums2.length; i++) {
            tmp2.next = new ListNode(nums2[i]);
            tmp2 = tmp2.next;
        }

        System.out.println("nums1 输入：" + Arrays.toString(nums1));
        System.out.println("nums2 输入：" + Arrays.toString(nums2));
        ListNode listNode = addTwoNumbers(l1.next, l2.next);

        //打印输出
        String result = "";
        while (listNode != null) {
            result += listNode.val;
            listNode = listNode.next;
        }
        System.out.println("输出：" + result);

    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    // 保存每次相加的结果链表
    ListNode dummyHead = new ListNode(0);

    ListNode tmp = dummyHead;
    // 进位
    int carry = 0;
    while (l1 != null || l2 != null) {
        // 如果为null，就是0
        int x = (l2 != null) ? l2.val : 0;
        int y = (l1 != null) ? l1.val : 0;
        int sum = carry + x + y;
        // 是否进1
        carry = sum / 10;
        tmp.next = new ListNode(sum % 10);
        tmp = tmp.next;

        // 获取下一位
        if(l1 != null) {
            l1 = l1.next;
        }
        if(l2 != null) {
            l2 = l2.next;
        }

    }
    // 如果有进位，就加上
    if(carry > 0) {
        tmp.next = new ListNode(carry);
        System.out.print(carry);
    }
    return  dummyHead.next;
}

}
