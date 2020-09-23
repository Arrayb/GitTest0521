package com.test;

public class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }

     public static String print(ListNode l){
         StringBuffer sb = new StringBuffer();
         while (l != null){
             sb.append(l.val);
             l = l.next;
         }
         return sb.reverse().toString();
     }
  }
