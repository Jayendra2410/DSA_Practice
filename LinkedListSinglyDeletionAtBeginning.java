public class LinkedListSinglyDeletionAtBeginning {
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
    public ListNode deleteAtBeginning(){
        if(head == null){
            return null;
        }
        ListNode deletedNode = head;
        head = head.next;
        deletedNode.next = null;
        return deletedNode;
    }

    public static void main(String[] args) {
        LinkedListSinglyDeletionAtBeginning list = new LinkedListSinglyDeletionAtBeginning();
        list.head = new ListNode(10);
        ListNode second = new ListNode(20);
        ListNode third = new ListNode(30);
        list.head.next = second;
        second.next = third;
        list.display();
        System.out.println("Deleted node: " + list.deleteAtBeginning().data);
        list.display();
    }
}
