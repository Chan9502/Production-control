package CSD201x_02_ASM2;
/*
Nơi lưu trữ dữ liệu của mỗi Node
Biến Next trỏ đến Node tiếp theo
 */
public class Node<T>  {
    T data;
    Node<T> next;

//  hàm khởi tạo node mới cho mõi sản phẩm
    public Node(T data){
        this.data = data;
        this.next = null; //gán cho giá trị ban đầu bằng 0
    }
//  hàm khởi tạo k có tham số
    public Node(){}

//  ----------------------start setter and getter----------------------
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

//  ----------------------end setter and getter----------------------
}
