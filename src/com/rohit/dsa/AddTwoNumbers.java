package com.rohit.dsa;

public class AddTwoNumbers {
    public static void main(String[] args) {

        // 2->4->3
        // 5->6->4

        ListNode num1Val1 = new ListNode(9);
        ListNode num1Val2 = new ListNode(9);
        ListNode num1Val3 = new ListNode(9);
        ListNode num1Val4 = new ListNode(9);
        ListNode num1Val5 = new ListNode(9);
        ListNode num1Val6 = new ListNode(9);
        ListNode num1Val7 = new ListNode(9);

        num1Val1.next = num1Val2;
        num1Val2.next = num1Val3;
        num1Val3.next = num1Val4;
        num1Val4.next = num1Val5;
        num1Val5.next = num1Val6;
        num1Val6.next = num1Val7;

        ListNode num2Val1 = new ListNode(9);
        ListNode num2Val2 = new ListNode(9);
        ListNode num2Val3 = new ListNode(9);

        num2Val1.next = num2Val2;
        num2Val2.next = num2Val3;


        ListNode addition = addNumbers(num1Val1, num2Val1);

        System.out.println("Addition -> " + addition);
    }

    public static ListNode addNumbers(ListNode l1, ListNode l2) {

        ListNode res = null;
        int carry = 0;

        while (l1 != null || l2 != null) {

            int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;

            // calculate carry
            carry = sum/10;
            // calculate val
            int val = sum%10;

            if (res == null) {
                res = new ListNode(val);
            }
            else {
                ListNode tmp = res;
                while(tmp.next != null) { // Reach last node
                    tmp = tmp.next;
                }
                tmp.next = new ListNode(val);
            }

            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        if (carry > 0) { // Handle carry case
            ListNode tmp = res;
            while(tmp.next != null) { // Reach last node
                tmp = tmp.next;
            }
            tmp.next = new ListNode(carry);
        }
        return res;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}