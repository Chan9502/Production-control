package CSD201x_02_ASM2;

import java.io.File;
import java.net.PortUnreachableException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Main {
//  khai báo các biến là hằng số dùng cho thao tác đọc và lưu file
    private static final String fileName = "Data.txt";
    private static final String console_file = "console_ouput.txt";
    private static final String console_file_01 = "console_ouput_Queue.txt";

    public static void main(String[] args) {
        OperationToProduct op = new OperationToProduct();
        MyList<Product> list = new MyList<>();
        Product newProduct = new Product();

        Scanner sc = new Scanner(System.in);
        int chose;
        do {
//          hiển thị men chính của chương trinh
            showmenu();
            chose = sc.nextInt();
            sc.nextLine();
            switch (chose){
//                Đọc dữ liệu có sẵn từ file và lưu vào danh sách móc nối và hiển thị danh sách ra màn hình
                case 1:
//                  kiểm file có null hay không?
                    if(!op.checkFileisEmpty(fileName)){
                        list.clearAll();
                        System.out.println("The List of product");
                        op.getListItemsFromFile(fileName,list);
                        op.displayAll(list);
                    }else {
                        System.out.println("List is Empty");
                    }
                    break;
//              Nhập và thêm một sản phẩm vào cuối của danh sách móc nối
                case 2:
//                  hỏi user muốn thêm bao nhiên sản phẩm mới
                    System.out.print("How many products that do you want to import? ");
                    int n = sc.nextInt(); sc.nextLine();
                    for (int i = 0; i < n; i++) {
                        System.out.println("Import " + (i+1) + " :");
                       op.addNewPro(newProduct,list);
                    }
//                    list.displayList();
                    break;
//              in danh sách sản phẩm ra màn hình
                case 3:
                    if(!list.isEmpty()){
                        op.displayAll(list);
                    }else {
                        System.out.println("List is Empty");
                    }
                    break;
//              Lưu danh sách móc nối các sản phẩm vào file - ghi dũ liệu từ list vào file
                case 4:
                    if(!list.isEmpty()){
                        op.writeListItemsToFile(fileName,list,false);
                        System.out.println("successfully, pls check of Data.txt");
                    }else {
                        System.out.println("List is Empty");
                    }
                    break;
//              Tìm kiếm thông tin của sản phẩm theo ID - done
                case 5:
                    System.out.print("Input ID: ");
                    String id = sc.next(); sc.nextLine();

                    //tạo biến ghi nhận kết quả tìm kiếm
                    boolean isFound = op.searchByBCode(list, id);

                    //hiển thị thông báo không tìm thấy thông tin sản phẩm
                    if(!isFound){
                        System.out.println(-1);
                        System.out.println("Cannot find " + id + " in list!!");
                    }
                    break;
//              Xóa sản phẩm trong danh sách theo ID
                case 6:
                    System.out.print("Input ID, you want to delete: ");
                    String deleteID = sc.next(); sc.nextLine();
                    op.deleteByBcode(list,deleteID);
//                    khai báo biến cờ ghi nhận lại kết quả để hiển thị ra thồng báo

//                        sao khi xóa, cập nhật lại file và ghi lại vào Data.txt
                        op.writeListItemsToFile(fileName,list,false);
//                        hiện thông báo thành công
                        System.out.println("Successfully, ID had deleted");

                        //hiện thông báo k xóa được
                        System.out.println("Delete is Unsuccessfully!!!");
                    break;

                //Sắp xếp các sản phẩm trong ds móc nối  theo ID- d
                case 7:
                    System.out.println("List of production after sort by ID, don't use recursion: ");
                    op.sortByID(list);
                    op.displayAll(list);
                    break;
//              Biểu diễn số lượng sản phẩm (đang ở hệ đếm cơ số 10) của phần tử đầu tiên trong Linked List
//              ra hệ đếm nhị phân bằng phương pháp đệ quy- của phần tử đầu tiên trong Linked List
                case 8:
                    if(!list.isEmpty()){
                        MyStack<String> myStack = new MyStack<>();
                        Product nproduct = list.head.getData();
                        System.out.print("The first QTY has Qty is " + nproduct.getQuantity() + " after cover by binary is: ");
                        op.convertToBinary(nproduct,myStack);
                        myStack.showStack();
                    }else {
                        System.out.println("List is Empty!!");
                    }
                    break;
//              Đọc dữ liệu từ file chứa các sản phẩm rồi lưu vào stack. Hiển thị ra màn hình các sản phẩm có trong stack.
                case 9:
                    MyStack<Product> stack = new MyStack<>();
//                  kiểm tra file có rỗng hay không?
                    if(!list.isEmpty()){
                        //đọc file
                        op.getStackItemsFromFile(fileName,stack);
                        //ghi xuống tệp txt
                        op.writeStackItemsToFile(console_file,stack,false);
                        //hiển thị ra màn hình  - theo thứ tụ ngược lại
                        stack.displayStack();
                        //xóa dữ liệu cũ trong stack
                        stack.clearStack();
                    }else {
                        System.out.println("List is Empty!!");
                    }
                    break;
//              Đọc dữ liệu từ file chứa các sản phẩm lưu vào queue. Hiển thị ra màn hình các sản phẩm có trong queue
                case 10:
//                  kiểm tra file
                    MyQueue<Product> queue = new MyQueue<>();
                    if(!list.isEmpty()){
                        op.getQueueItemsFromFile(fileName, queue);
                        op.writeQueueItemsToFile(console_file_01,queue,false);
                        queue.displayList();
                        queue.clearQueue();
                    }else {
                        System.out.println("List is Empty!!");
                    }
                    break;
//              Sắp xếp danh sắp bằng đệ quy
                case 11:
//                  kiểm tra file
                    op.sortByRecursion(list);
                    op.displayAll(list);
                    break;
            }
        }while (chose != 0 || chose > 12);
        if(chose == 0 || chose > 12){
            System.out.println("Thank You!!!");
        }
    }

//  hàm hiển thị menu chính của chương trình
    public static void showmenu(){
        System.out.println("*----------------------------MENU----------------------------*");
        System.out.println("|-------------------------Product list-----------------------|");
        System.out.println("|   1. Load data from file and display                       |");
        System.out.println("|   2. Input & add to the end                                |");
        System.out.println("|   3. Display data                                          |");
        System.out.println("|   4. Save product list to file                             |");
        System.out.println("|   5. Search by ID                                          |");
        System.out.println("|   6. Delete by ID                                          |");
        System.out.println("|   7. Sort by ID                                            |");
        System.out.println("|   8. Convert to Binary                                     |");
        System.out.println("|   9. Load to stack and display                             |");
        System.out.println("|   10.Load to queue and display                             |");
        System.out.println("|   11.Sort by ID by recursion                               |");
        System.out.println("|   0. Exit                                                  |");
        System.out.println("*------------------------------------------------------------*");
        System.out.print("  Your choice: ");
    }

}
