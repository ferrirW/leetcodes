public class AddTwoNum2 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode res = result;

        boolean isGreater10 = false;
        int val = 0;
        while (l1 != null && l2 != null) {
            int ind = 0;
            if (isGreater10) {
                isGreater10 = false;
                ind = 1;
            }

            val = (l1.val + l2.val + ind) % 10;
            System.out.println(l1.val + ", " + l2.val + " = " + val);

            if (val == 0) {
                isGreater10 = true;
            }


            res.val = val;
            res.next = new ListNode();
            res = res.next;

            l1 = l1.next;
            l2 = l2.next;
        }


        if (l1 != null) {
            if (isGreater10) {
                l1.val = (l1.val + 1) % 10;
            }
            res.next = l1;

        } else if (l2 != null){
            if (isGreater10) {
                l2.val = (l2.val + 1) % 10;
            }
            res.next = l2;

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

    public static void main(String[] args) {

        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        ListNode r1 = new ListNode(5);
        ListNode r2 = new ListNode(6);
        ListNode r3 = new ListNode(4);

        l1.next = l2;
        l2.next = l3;

        r1.next = r2;
        r2.next = r3;

        System.out.println();

        ListNode ln = addTwoNumbers(l1, r1);

        while (ln.next != null) {
            System.out.println(ln.val);
            ln = ln.next;
        }



    }
}
