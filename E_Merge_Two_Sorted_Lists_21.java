public class E_Merge_Two_Sorted_Lists_21 {

    public class ListNode {
        public int val;
        public ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +

                    ", next=" + next +
                    ", val=" + val +
                    '}';
        }
    }

    public ListNode init1() {
        return new ListNode(1, new ListNode(2, new ListNode(4)));
    }

    public ListNode init2() {
        return new ListNode(1, new ListNode(3, new ListNode(4)));
    }

    public static void main(String[] args) {
        E_Merge_Two_Sorted_Lists_21 main = new E_Merge_Two_Sorted_Lists_21();
        ListNode listNode1 = main.init1();
        ListNode listNode2 = main.init2();

        System.out.println(main.mergeTwoLists(listNode1, listNode2).toString());
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode result = new ListNode();
        ListNode buffer = result;

        while (list1 != null || list2 != null) {
            if (list1 == null) {
                buffer.val = list2.val;
                buffer.next = new ListNode();
                buffer = buffer.next;
                list2 = list2.next;
            } else if (list2 == null) {
                buffer.val = list1.val;
                buffer.next = new ListNode();
                buffer = buffer.next;
                list1 = list1.next;
            } else if (list1.val <= list2.val) {
                buffer.val = list1.val;
                buffer.next = new ListNode();
                buffer = buffer.next;
                list1 = list1.next;
            } else if (list1.val > list2.val) {
                buffer.val = list2.val;
                buffer.next = new ListNode();
                buffer = buffer.next;
                list2 = list2.next;
            }
        }

        buffer = result;
        while (true) {
            if (buffer.next.next == null) {
                buffer.next = null;
                return result;
            } else {
                buffer = buffer.next;
            }
        }
    }
}
