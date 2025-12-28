public class LinkedListSinglyElementSearch {
    private ListNode head;
    private static class ListNode {
        private int data;
        private ListNode next;
        ListNode(int data){
            this.data = data;
            this.next = null;
        }
    }
    public boolean search(int key){
        ListNode current = head;
        while(current != null){
            if(current.data == key){
                return true;
            }
            current = current.next;
        }
        return false;
    }
    public static void main(String[] args) {
        LinkedListSinglyElementSearch list = new LinkedListSinglyElementSearch();
        list.head = new ListNode(10);
        ListNode second = new ListNode(20);
        ListNode third = new ListNode(30);
        list.head.next = second;
        second.next = third;
        System.out.println("Is element 20 present? \n" + list.search(20));
    }
}