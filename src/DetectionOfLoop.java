//Time Complexity = O(n) = space complexity

import java.util.HashSet;

public class DetectionOfLoop {

    Node head = null;

    public void insert(Node prevNode,int data,Node link){
        Node newNode = new Node(data);
        if (head==null){
            head = newNode;
            return;
        }
        if (prevNode == null){
            System.out.println("prevNode can't be null");
            return;
        }
        newNode.next = link;
        prevNode.next = newNode;
    }
    public int detectLoop(){
        Node Curr = head;
        HashSet<Integer> map = new HashSet<>();
        while(Curr != null){
            if (map.contains(Curr.data)){
                return 1;
            }
            map.add(Curr.data);
            Curr = Curr.next;
        }
        return 0;
    }

    public static void main(String[] args) {
        DetectionOfLoop dl = new DetectionOfLoop();

        dl.insert(null,1,null);
        dl.insert(dl.head,2,null);
        dl.insert(dl.head.next,3,null);
        dl.insert(dl.head.next.next,4,dl.head.next);

        int loopexist = dl.detectLoop();


        if (loopexist == 1){
            System.out.println("loop detected");
        }else{
            System.out.println("no loop detected");
        }
    }

}
