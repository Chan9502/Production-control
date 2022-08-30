package CSD201x_02_ASM2;

public class Product implements Comparable<Product> {
//  khai báo thuộc tính cho lớp Product
    private String bcode; //Product's bar code
    private String title; //Product's title
    private Integer quantity; //Product's quantity
    private double price; //Product's price

//  hàm khởi tạo không có tham số
    public Product(){}

//  hàm khởi tạo làm việc với ID
    public Product(String bcode){
        this.bcode = bcode;
    }
//  hàm khởi tạo có tham số
    public Product(String bcode, String title, Integer quantity, double price) {
        this.bcode = bcode;
        this.title = title;
        this.quantity = quantity;
        this.price = price;
    }
//  hàm hiển thị thông tin
    @Override
    public String toString() {
        return String.format("|%-15s|%-15s|%-15s|%-12.1f|%n", bcode, title,quantity, price);
    }

    //hàm so sánh theo ID - sử dụng comparaTo(Obj)
    @Override
    public int compareTo(Product o) {
        return this.bcode.compareTo(o.bcode);
    }

    //hàm chuyển đổi số lượng sang hệ nhịn phân, sử dụng nhị phân
    public int coverQTYToBinary(int x, MyStack<String> binary){
        //dẩy vào Stack số dư chia hết cho 2 - gọi hàm push trong stack
        binary.push(String.valueOf(x % 2));
        //điều kiện dừng
        if(x == 1) {
            return x;
        }else {
            //nếu x!= 1 thực hiện chia tiếp cho 2 bằng đệ quy
            return coverQTYToBinary(x/2, binary);
        }
    }

    //  --------------------------Setter và getter-----------------------------------------
    public String getBcode() {
        return bcode;
    }

    public void setBcode(String bcode) {
        this.bcode = bcode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
//  -------------------------------------------------------------------------
}
