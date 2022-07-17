class Node{
    int data;
    Node next;

    Node(int data){
        this.data = data;
        this.next = null;
    }
}

public class LengthOfLinkedList {

    Node head = null;

    public void insert(Node prevNode,int data){
        Node newNode = new Node(data);
        if (head==null){
            head = newNode;
            return;
        }
        if (prevNode == null){
            System.out.println("prevNode can't be null");
            return;
        }
        newNode.next = prevNode.next;
        prevNode.next = newNode;
    }

    // Iterative Approach
    public void displayAndCount(){
        int count =0;
        Node Curr = head;
        while (Curr!=null){
            System.out.println(Curr.data);
            Curr = Curr.next;
            count++;
        }
        System.out.println("Number of elements in linked list: "+ count);
    }

    // Recursive Approach
    public int getCount(Node head , int count){
        if (head == null){
            return count ;
        }
        int finalCount = getCount(head.next,count+1);
        return finalCount;
    }

    public static void main(String[] args) {
        LengthOfLinkedList ll = new LengthOfLinkedList();
        ll.insert(null,1);
        ll.insert(ll.head,2);
        ll.insert(ll.head.next,3);
        ll.displayAndCount();
        int count = ll.getCount(ll.head,0);
        System.out.println(count);
    }
}
