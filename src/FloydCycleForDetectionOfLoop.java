//Time Complexity = O(n)
//Space Complexity = O(1)

public class FloydCycleForDetectionOfLoop {

    Node head = null;
    Node tail = null;
    public void insert(int data){
        Node newNode = new Node(data);
        if (head==null){
            head = newNode;
            tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public void detectLoop(){
        Node slowPointer = head; Node fastPointer = head;
        boolean flag = false;

        while (slowPointer != null && fastPointer !=null && fastPointer.next != null){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
            if (slowPointer == fastPointer){
                flag = true;
                break;
            }
        }
        if (flag){
            System.out.println("Loop Detected.");
        }else{
            System.out.println("No Loop Detected. ");
        }
    }

    public static void main(String[] args) {
        FloydCycleForDetectionOfLoop obj = new FloydCycleForDetectionOfLoop();
        obj.insert(1);
        obj.insert(2);
        obj.insert(3);
        obj.insert(4);

        // test for loop
        obj.head.next.next.next.next = obj.head;

        obj.detectLoop();
    }
}
