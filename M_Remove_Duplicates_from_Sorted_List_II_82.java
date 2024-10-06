import static java.util.Collections.emptyList;

public class M_Remove_Duplicates_from_Sorted_List_II_82 {

    //     Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode listNode7 = new ListNode(5);
        ListNode listNode6 = new ListNode(4, listNode7);
        ListNode listNode5 = new ListNode(4, listNode6);
        ListNode listNode4 = new ListNode(3, listNode5);
        ListNode listNode3 = new ListNode(3, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);

        ListNode listNode25 = new ListNode(3);
        ListNode listNode24 = new ListNode(2, listNode25);
        ListNode listNode23 = new ListNode(1, listNode24);
        ListNode listNode22 = new ListNode(1, listNode23);
        ListNode listNode21 = new ListNode(1, listNode22);

        ListNode listNode35 = new ListNode(3);
        ListNode listNode34 = new ListNode(3, listNode35);
        ListNode listNode33 = new ListNode(2, listNode34);
        ListNode listNode32 = new ListNode(1, listNode33);
        ListNode listNode31 = new ListNode(1, listNode32);

        ListNode listNode45 = new ListNode(1);
        ListNode listNode44 = new ListNode(1, listNode45);
        ListNode listNode43 = new ListNode(1, listNode44);
        ListNode listNode42 = new ListNode(1, listNode43);
        ListNode listNode41 = new ListNode(1, listNode42);

        ListNode listNode = new M_Remove_Duplicates_from_Sorted_List_II_82()
                .deleteDuplicates(listNode41);
        ListNode listNode21111 = new M_Remove_Duplicates_from_Sorted_List_II_82()
                .deleteDuplicates2(listNode41);

        System.out.println(listNode21111.val);
        while (listNode21111.next != null) {
            System.out.println(listNode21111.next.val);
            listNode21111 = listNode21111.next;
        }
    }


    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        if (head.next == null) {
            return head;
        }
        boolean isDublicated = false;
        ListNode prev = null;
        ListNode first = null;
        if (head.val == head.next.val) {
            head = head.next;
            isDublicated = true;
        } else {
            first = head;
            prev = head;
        }
        while (true) {
            if (head.val == head.next.val) {
                isDublicated = true;
                head.next = head.next.next;
            } else if (isDublicated) {
                isDublicated = false;
                if (prev == null) {
                    prev = head.next;
                } else {
                    prev.next = head.next;
                }
                head = prev;
                if (first == null) {
                    first = prev;
                }
            } else {
                prev = head;
                head = head.next;
                if (first == null) {
                    first = head;
                }
            }
            if (head.next == null) {
                if (isDublicated) {
                    if (prev != null) {
                        prev.next = null;
                    }
                }
                return first;
            }
        }
    }

    public ListNode deleteDuplicates2(ListNode head) {
        ListNode dm = new ListNode(0 , head);
        ListNode pre = dm;

        while(head != null){
            int va = head.val;
            if(head.next != null && head.next.val == va){
                while(head.next != null && head.val == va){
                    head = head.next;
                }
                if(head.val == va ){
                    pre.next = null;

                }
                else{
                    pre.next = head;
                }
            }
            else{
                pre= pre.next;
                head = head.next;
            }

        }
        return dm.next;
    }
}
