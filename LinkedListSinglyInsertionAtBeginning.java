public class LinkedListSinglyInsertionAtBeginning {
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
    public void insertAtBeginning(int data){
        ListNode newNode = new ListNode(data);
        newNode.next = head;
        head = newNode;
    }
    public static void main(String[] args) {
        LinkedListSinglyInsertionAtBeginning list = new LinkedListSinglyInsertionAtBeginning();
        list.head = new ListNode(10);
        ListNode second = new ListNode(20);
        ListNode third = new ListNode(30);
        list.head.next = second;
        second.next = third;
        list.display();
        list.insertAtBeginning(5);
        list.display();
    }
}