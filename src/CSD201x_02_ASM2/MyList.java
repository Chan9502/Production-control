package CSD201x_02_ASM2;

import java.util.Comparator;

public class MyList<T extends Comparable<T>>{

    Node<T> head; //phần tử đầu
    Node<T>tail; //phần tủ cuối

//  tạo hàm khỏi tạo không có tham số
    public MyList(){}
//  hàm tính độ dài của danh sách

//    tạo hàm khởi tạo có tham số
    public MyList(Node head, Node tail){
        this.head = this.tail = null;
    }

//  hàm kiểm tra Node có trỗng hay không?
//  nếu True -- Node trỗng
    public boolean isEmpty(){
        return this.head == null;
    }

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

//  hàm ghi vào đầu danh sách
    public void insertToHead(T data){
//      Allocate the Node & Put in the data
        Node<T> new_node = new Node<>(data);
//      Make next of new Node as head
        new_node.next = head;
//      Move the head to point to new Node
        head = new_node;
    }

    public void displayList() {
        System.out.println("+---------------+---------------+---------------+------------+");
        System.out.printf("|%-15s|%-15s|%-15s|%-12s|%n", "ID", "TITLE", "QTY", "PRICE");
        System.out.println("+---------------+---------------+---------------+------------+");
        Node<T> current = this.head;
        while (current != null){
            System.out.printf(current.getData().toString());
            current = current.getNext();
        }
        System.out.println("+---------------+---------------+---------------+------------+");

        System.out.println();
    }

//  hàm hiển thị số lượng của phần tử đầu tiên cover bằng Binary
    public void showAfterConverByBinary(){
        for (var node = head; node != null; node = node.getNext()){
            System.out.print(node.getData());
        }
        System.out.println();
    }

//  hàm sắp xếp danh sách theo ID trực tiếp không dùng đệ quy
    public void sortList(){
        Node<T> cur = head;
        Node<T> prev;

        //chạy vòng lặp
        while (cur != null){
            prev = cur.getNext();
            while (prev != null){
                if(cur.getData().compareTo(prev.getData()) > 0){
                    T temp = cur.getData();
                    cur.setData(prev.getData());
                    prev.setData(temp);
                }
                //thực hiện với phần tử tiếp theo
                prev = prev.getNext();
            }
            //di chuyển đến node tiếp theo
            cur = cur.getNext();
        }
    }

//  hàm xóa danh sách
    public void clearAll() {
        head = tail = null;

    }

//  hàm sắp xếp danh sách bằng phương pháp đệ quy -
    public Node getMiddle(Node<T> head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node<T> slow = head;
        Node<T> fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    public Node sortedMerge(Node<T> left, Node<T> right) {
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }

        if (left.data.compareTo(right.data) > 0) {
            left.next = sortedMerge(left.next, right);
            return left;
        } else {
            right.next = sortedMerge(left, right.next);
            return right;
        }
//        return right;
    }
    public Node mergeSort(Node<T> head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node<T> middle = getMiddle(head);
        Node<T> middleNext = middle.next;
        middle.next = null;
        Node<T> left = mergeSort(head);
        Node<T> right = mergeSort(middleNext);
        return sortedMerge(left, right);
    }
//  ------------------------------------setter và getter-----------------------------
    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    public Node<T> getTail() {
        return tail;
    }

    public void setTail(Node<T> tail) {
        this.tail = tail;
    }

//  ---------------------------------------------------------------------------------
}
