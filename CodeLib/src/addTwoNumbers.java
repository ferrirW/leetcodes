import java.util.List;

public class addTwoNumbers {
    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
//    [2,4,3]
//    [5,6,4]
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean flag = false;
        int tmp = 0;
        ListNode result = l1;
        while (l1.next != null && l2.next != null) {
            tmp = l1.val + l2.val;
            if (flag) {
                tmp += 1;
                flag = false;
            }
            if (tmp >= 10) {
                tmp %= 10;
                flag = true;
            }

            l1.val = tmp;
            l2 = l2.next;
            l1 = l1.next;
        }
        tmp = l1.val + l2.val;
        if (flag) {
            tmp += 1;
            flag = false;
        }
        if (tmp >= 10) {
            tmp %= 10;
            flag = true;
        }
        l1.val = tmp;
        if (l2.next == null && l1.next == null) {
            if (flag) {
                ListNode lastNode = new ListNode(1);
                l1.next = lastNode;
                flag = false;
            }
        } else if (l2.next != null){
            l2 = l2.next;
            if (flag) {
                l2.val += 1;
                flag = false;
            }
            l1.next = l2;
        } else {
            l1 = l1.next;
            if (flag) {
                l1.val += 1;
                flag = false;
            }
        }
        while (l1 != null) {
            if (flag) {
                l1.val += 1;
                flag = false;
            }
            if (l1.val >= 10) {
                l1.val %= 10;
                flag = true;
            }
            if (l1.next != null) {
                l1 = l1.next;
            } else {
                break;
            }
        }
        if (flag) {
            ListNode lastNode = new ListNode(1);
            l1.next = lastNode;
        }

        return result;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode pointer1 = l1, pointer2 = l2, cur = dummyHead;
        int flag = 0;
        while (pointer1 != null || pointer2 != null) {
            int x = (pointer1 != null) ? pointer1.val : 0;
            int y = (pointer2 != null) ? pointer2.val : 0;
            int tmp = x + y + flag;
            flag = tmp / 10;
            cur.next = new ListNode(tmp % 10);
            cur = cur.next;
            if (pointer1 != null)
                pointer1 = pointer1.next;
            if (pointer2 != null)
                pointer2 = pointer2.next;
        }
        if (flag > 0) {
            cur.next = new ListNode(flag);
        }
        return dummyHead.next;
    }
}
