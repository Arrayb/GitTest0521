package com.test;

public class addTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;//dummyHead记录两节点之和
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            //指针后移操作
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
    public static void main(String [] args){
        ListNode l1 =new ListNode(6);
        ListNode l2 =new ListNode(5);
        l1.next = new ListNode(4);
        l2.next = new ListNode(2);
        System.out.println(ListNode.print(addTwoNumbers(l1,l2)));
    }
}
