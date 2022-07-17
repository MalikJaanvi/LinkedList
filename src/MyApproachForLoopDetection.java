public class MyApproachForLoopDetection {
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
            if (head == tail && head.next!=null){
                return true;
            }else{
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
            obj.tail.next = obj.head;
            obj.tail = obj.head;
            if(obj.detectLoop()){
                System.out.println("yes");
            }else{
                System.out.println("no");
            }


        }
}
