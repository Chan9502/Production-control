package CSD201x_02_ASM2;

public class MyQueue<T extends Comparable<T>>{
    Node<T> head;
    private Node<T> tail;
    private MyList<T> data;

    //hàm khởi tạo
    public MyQueue(){}

//  hàm ghi vào cuối danh sách
    public void insertToTail(T data){
        Node<T> new_node = new Node<>(data);
// If the Linked List is empty, then make the new node as head
        if(head == null){
            head = tail=new_node;
            return;
        }
// This new node is going to be the last node, so make next of it as null
        tail.next=new_node;
        tail= new_node;
    }

    public void insertToHead(T data){
//      Allocate the Node & Put in the data
        Node<T> new_node = new Node<>(data);
//      Make next of new Node as head
        new_node.next = head;
//      Move the head to point to new Node
        head = new_node;
    }

//  hàm clear Stack - sau khi display
    public void clearQueue() {
        this.head = null;
    }

//  hàm display
    public void displayList() {
        System.out.println("+---------------+---------------+---------------+------------+");
        System.out.printf("|%-15s|%-15s|%-15s|%-12s|%n", "ID", "TITLE", "QTY", "PRICE");
        System.out.println("+---------------+---------------+---------------+------------+");
        for(var node = head; node != null; node = node.getNext()){
            System.out.print(node.getData());
        }
        System.out.println("+---------------+---------------+---------------+------------+");
        System.out.println();
    }
}
