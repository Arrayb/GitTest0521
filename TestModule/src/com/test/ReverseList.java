package com.test;

/**
 * 206. 反转链表
 * 使用第三个节点用来交换两个节点的指向
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;//默认初始值
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;//赋值
            curr.next = prev;//指向变换

            prev = curr;//指针后移
            curr = nextTemp;
        }
        return prev;
    }
}
