class Node{
    Node next;
    Node pre;
    int data;
    Node(int data){
        this.data=data;
    }
}


public class find_middle {
    Node mid;
    Node head;
    int size=0;
    public void insert(int data){

        Node node = new Node(data);
        if(size==0){
            head=node;
            mid = node;
            size++;
            return;
        }
        head.next = node;
        node.pre = head;
        head=head.next;
        if(size%2==1){
            mid=mid.next;
        }
        size++;

    }
    public void pop(){
        if(size!=0){
            if(size==1){
                head=mid=null;
            }else{
                head=head.pre;
                head.next=null;
                if(size%2==0)
                    mid=mid.pre;
            }
            size--;
        }
    }
    public int findMiddle(){
        if(size==0){
            System.out.println("Stack is Empty");
            return -1;
        }
        return mid.data;
    }
    public static void main(String[] args) {
        find_middle fm = new find_middle();
        fm.insert(67);
        fm.insert(89);
        fm.insert(100);
        fm.insert(69);
        fm.insert(23);
        fm.pop();
        fm.pop();



        System.out.println("Middle Element "  + fm.findMiddle());
    }
}
