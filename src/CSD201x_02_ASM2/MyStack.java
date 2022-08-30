package CSD201x_02_ASM2;

import java.util.EmptyStackException;

public class MyStack<T extends Comparable<T>> {
    /**
     * @param size biến đếm sl phần tử trong stack
     * @param
     */
    private MyList<T> data;
    private int size;
    Node<T> head;

    //  hàm khởi tạo
    public MyStack() {
        //giá trị ban đầu của Stack rỗng
        size = 0;
        data = new MyList<>();
    }

    //hiển thị sau khi cover sang nhị phân
    public void showStack() {
        data.showAfterConverByBinary();
    }
    //hàm pop() Stack
    public T pop(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        T result = head.getData();
        head = head.getNext();
        size--;

//        System.out.println(result);
        return result;
    }

    //hàm hiển thị list trong stack - theo thứ tụ Last in - First out
    public void displayStack(){
        System.out.println("+---------------+---------------+---------------+------------+");
        System.out.printf("|%-15s|%-15s|%-15s|%-12s|%n", "ID", "TITLE", "QTY", "PRICE");
        System.out.println("+---------------+---------------+---------------+------------+");
        while (!isEmpty()){
            System.out.print(pop());
        }
        System.out.println("+---------------+---------------+---------------+------------+");
        System.out.println();
    }

    //hàm đẩy phần tử vào stack
    public void insertToHead(T data){
//      Allocate the Node & Put in the data
        Node<T> new_node = new Node<>(data);
//      Make next of new Node as head
        new_node.next = head;
//      Move the head to point to new Node
        head = new_node;
        size++;
    }
    public void push(T x){
        data.insertToHead(x);
        size++;
}

//  hàm clear Stack - sau khi display
    public void clearStack() {
        data.head = null;
    }
    public boolean isEmpty(){
        return head == null;
    }

}
