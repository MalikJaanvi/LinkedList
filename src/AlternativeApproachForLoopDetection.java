public class AlternativeApproachForLoopDetection {

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

    public boolean detectLoop(){
        Node temp = head;
        if (head==null){
            return false;
        }
        else{
            while( head != null ){
                if (head.data == -1){
                    return true;
                }else{
                head.data = -1;
                head = head.next;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        AlternativeApproachForLoopDetection obj = new AlternativeApproachForLoopDetection();
        obj.insert(1);
        obj.insert(2);
        obj.insert(3);
        obj.insert(4);

        // test for loop
        obj.head.next.next.next.next = obj.head;
        if(obj.detectLoop()){
            System.out.println("yes");
        }else{
            System.out.println("no");
        }


    }
}
