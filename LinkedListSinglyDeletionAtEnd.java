public class LinkedListSinglyDeletionAtEnd {
    private ListNode head;
    private static class ListNode {
        private int data;
        private ListNode next;
        ListNode(int data){
            this.data = data;
            this.next = null;
        }
    }
    public void display(){
        ListNode current = head;
        while(current != null){
            System.err.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
    public ListNode deleteAtEnd(){
        if(head == null || head.next == null){
            return head;
        }
        ListNode current = head;
        while(current.next.next != null){
            current = current.next;
        }
        ListNode deletedNode = current.next;
        current.next = null;
        return deletedNode;
    }

    public static void main(String[] args) {
        LinkedListSinglyDeletionAtEnd list = new LinkedListSinglyDeletionAtEnd();
        list.head = new ListNode(10);
        ListNode second = new ListNode(20);
        ListNode third = new ListNode(30);
        list.head.next = second;
        second.next = third;
        list.display();
        System.out.println("Deleted node: " + list.deleteAtEnd().data);
        list.display();
    }
}