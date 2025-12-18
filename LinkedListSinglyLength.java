public class LinkedListSinglyLength {
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
    public int length(){
        int count = 0;
        ListNode current = head;
        while(current != null){
            count++;
            current = current.next;
        }
        return count;
    }
    public static void main(String[] args) {
        LinkedListSinglyLength list = new LinkedListSinglyLength();
        list.head = new ListNode(10);
        ListNode second = new ListNode(20);
        ListNode third = new ListNode(30);
        list.head.next = second;
        second.next = third;
        list.display();
        System.out.println("Length of the linked list: " + list.length());
    }
}
