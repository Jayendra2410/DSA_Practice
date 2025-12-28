public class LinkedListSinglyDeletionAtSpecificPosition {
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
    public void deleteAtPosition(int position){
        if(head == null){
            return;
        }
        if(position == 0){
            head = head.next;
            return;
        }
        ListNode current = head;
        for(int i = 0; current != null && i < position - 1; i++){
            current = current.next;
        }
        if(current == null || current.next == null){
            return;
        }
        current.next = current.next.next;
    }

    public static void main(String[] args) {
        LinkedListSinglyDeletionAtSpecificPosition list = new LinkedListSinglyDeletionAtSpecificPosition();
        list.head = new ListNode(10);
        ListNode second = new ListNode(20);
        ListNode third = new ListNode(30);
        list.head.next = second;
        second.next = third;
        list.display();
        list.deleteAtPosition(1);
        list.display();
    }
}
