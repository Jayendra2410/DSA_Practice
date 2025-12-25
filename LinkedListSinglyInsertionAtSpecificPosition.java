public class LinkedListSinglyInsertionAtSpecificPosition {
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
    public void insertAtSpecificPosition(int data, int position){
        ListNode newNode = new ListNode(data);
        if(position == 0){
            newNode.next = head;
            head = newNode;
            return;
        }
        ListNode current = head;
        for(int i=0; i<position-1; i++){
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
    }

    public static void main(String[] args) {
        LinkedListSinglyInsertionAtSpecificPosition list = new LinkedListSinglyInsertionAtSpecificPosition();
        list.head = new ListNode(10);
        ListNode second = new ListNode(20);
        ListNode third = new ListNode(30);
        list.head.next = second;
        second.next = third;
        list.display();
        list.insertAtSpecificPosition(40, 2);
        list.insertAtSpecificPosition(5, 0);
        list.display();
    }
}