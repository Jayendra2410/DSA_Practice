public class LinkedListSinglyInsertionAtEnd {
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
    public void insertAtEnd(int data){
        ListNode newNode = new ListNode(data);
        if(head == null){
            head = newNode;
            return;
        }
        ListNode current = head;
        while(current.next != null){
            current = current.next;
        }
        current.next = newNode;
    }

    public static void main(String[] args) {
        LinkedListSinglyInsertionAtEnd list = new LinkedListSinglyInsertionAtEnd();
        list.head = new ListNode(10);
        ListNode second = new ListNode(20);
        ListNode third = new ListNode(30);
        list.head.next = second;
        second.next = third;
        list.display();
        list.insertAtEnd(40);
        list.insertAtEnd(60);
        list.display();
    }
}
