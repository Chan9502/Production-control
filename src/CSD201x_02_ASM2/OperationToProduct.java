package CSD201x_02_ASM2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class OperationToProduct {
    Scanner sc = new Scanner(System.in);

    //  hàm nhập sản phẩm mới
    public void addNewPro(Product newPro, MyList<Product> list) {
        /** @param newPro đối tượng mới cần thêm
         * @param list danh sách sản phẩm
         */
        System.out.print("Nhap Barcode: ");
        String bcode = sc.next().toUpperCase();
        sc.nextLine();
        System.out.print("Nhap Title: ");
        String title = sc.nextLine();
        System.out.print("Nhap Quantity: ");
        int quantity = sc.nextInt();
        sc.nextLine();
        System.out.print("Nhap Price: ");
        double price = sc.nextDouble();
        sc.nextLine();

        newPro = new Product(bcode, title, quantity, price);
        addLast(newPro, list);
        System.out.println("Add succeed");
    }

    //  hàm kiểm tra file có trõng hay không
    public boolean checkFileisEmpty(String fileName) {
        //  tiến hàng đọc file cần kiểm tra
        try {
            //      thiết lặp phương thức đọc để get data
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            //      tạo 1 chuỗi nhận giá trị đọc được trên các dòng - do phương thức ghi mỗi giá trị trên 1 dòng
            String line = br.readLine();
            //      trả về null nếu line trỗng == tức file k có data
            return line == null;
        } catch (Exception e) {
            e.printStackTrace();
            //        System.out.println("File is Empty!!!"); do đã có thông báo ở main bên k cần thiết
        }
        return false;
    }

    //  Reading all products from the file and insert them to the list at tail. -> done
//  hàm đọc
    public void getListItemsFromFile(String fileName, MyList<Product> list) {
        /**
         * @param fileName đọc từ file
         * @param list danh sách sản phẩm
         */
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
//          tạo dữ liệu ban đầu là null - biến flag
            String line = "";
//          thực hiện đọc trên từng dòng - đến khi nào line == null thì break câu lệnh
            while (true) {
                line = br.readLine(); //đọc từng dòng trong file

//                điều kiện dừng vòng lặp
                if (line == null) {
                    break;
                } else {
                    String txt[] = line.split("\\s+"); //ngăn cách mõi dòng trong file cho dễ nhìn - sau đó trả về mảng TXT[]
//                    String [] newArr = new String[txt.length];

//              tạo thứ thự hàng hóa cho sản phẩm
                    String bcode = txt[0]; //phần tử thứ nhất là mã SP
                    String title = txt[1]; //phần tử thứ 2 là tiêu đề của sản phẩm
                    int quantity = Integer.parseInt(txt[2]); //phần tử thứ 3 là số lượng
                    double price = Double.parseDouble(txt[3]); //phần tử thứ 4 là đơn giá

//              tiến hành thêm vào danh sách sản phẩm
                    Product newPro = new Product(bcode, title, quantity, price);
//                System.out.println(newPro);

//              tạo điều kiện để thêm vào đâu/cuối của list
                    list.insertToTail(newPro);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Write file is unsuccessful!!!");
        }
    }

    //  Reading all products from the file and insert them to the stack.
//  hàm đọc và lưu vào Stack - case 7
    public void getStackItemsFromFile(String fileName, MyStack<Product> stack) {
        /**
         * @param fileName file đọc
         * @param stack làm việc với stack
         */
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
//          tạo dữ liệu ban đầu là null - biến flag
            String line = "";
//          thực hiện đọc trên từng dòng - đến khi nào line == null thì break câu lệnh
            while (true) {
                line = br.readLine(); //đọc từng dòng trong file

//                điều kiện dừng vòng lặp
                if (line == null) {
                    break;
                } else {
                    String txt[] = line.split("\\s+"); //ngăn cách mõi dòng trong file cho dễ nhìn - sau đó trả về mảng TXT[]
//                    String [] newArr = new String[txt.length];

//              tạo thứ thự hàng hóa cho sản phẩm
                    String bcode = txt[0]; //phần tử thứ nhất là mã SP
                    String title = txt[1]; //phần tử thứ 2 là tiêu đề của sản phẩm
                    int quantity = Integer.parseInt((txt[2])); //phần tử thứ 3 là số lượng
                    double price = Double.parseDouble(txt[3]); //phần tử thứ 4 là đơn giá

//              tiến hành thêm vào danh sách sản phẩm
                    Product newPro = new Product(bcode, title, quantity, price);
//                System.out.println(newPro);

//              tạo điều kiện để thêm vào đâu/cuối của stack
                    stack.insertToHead(newPro);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Write file is unsuccessful!!!");
        }
    }

    //  Reading all products from the file and insert them to the queue.
//  hàm đoc và luu vào Queue
    public void getQueueItemsFromFile(String fileName, MyQueue<Product> queue) {
        /**
         * @param fileName file đọc
         * @param queue làm việc với queue
         */
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
//          tạo dữ liệu ban đầu là null - biến flag
            String line = "";
//          thực hiện đọc trên từng dòng - đến khi nào line == null thì break câu lệnh
            while (true) {
                line = br.readLine(); //đọc từng dòng trong file

//                điều kiện dừng vòng lặp
                if (line == null) {
                    break;
                } else {
                    String txt[] = line.split("\\s+"); //ngăn cách mõi dòng trong file cho dễ nhìn - sau đó trả về mảng TXT[]
//                    String [] newArr = new String[txt.length];

//              tạo thứ thự hàng hóa cho sản phẩm
                    String bcode = txt[0]; //phần tử thứ nhất là mã SP
                    String title = txt[1]; //phần tử thứ 2 là tiêu đề của sản phẩm
                    int quantity = Integer.parseInt(txt[2]); //phần tử thứ 3 là số lượng
                    double price = Double.parseDouble(txt[3]); //phần tử thứ 4 là đơn giá

//              tiến hành thêm vào danh sách sản phẩm
                    Product newPro = new Product(bcode, title, quantity, price);
//                System.out.println(newPro);

//              tạo điều kiện để thêm vào đâu/cuối của list
                    queue.insertToTail(newPro);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Write file is unsuccessful!!!");
        }


    }

    //  Adding a product to the list, info of the product input from keyboard. --> done
    public void addLast(Product newPro, MyList<Product> list) {
        /**
         * @param newPro sản phẩm cần thêm cuối
         * @param list danh sách sản phẩm
         */
        list.insertToTail(newPro);
    }

    //  Printing all prodcuts of the list to console screen
    public void displayAll(MyList<Product> list) {
        list.displayList();
    }

    //  Writing all products from the list to the file --> done
    public void writeListItemsToFile(String fileName, MyList<Product> list, boolean append) {
        /**
         * @param fileName file đọc
         * @param list danh sách sản phẩm
         * @param append xác nhận có ghi đè file hay không, true - không ghi đè/ false - ghi đè file
         */
        try {
            FileWriter fw = new FileWriter(fileName, append);
            BufferedWriter bw = new BufferedWriter(fw);
            Node<Product> current = list.head;
            while (current != null) {
//                bw.newLine();
                bw.write(current.getData().getBcode() + " " + current.getData().getTitle() + " "
                        + current.getData().getQuantity() + " " + current.getData().getPrice());
                bw.newLine();
                current = current.getNext();
            }
            bw.flush();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeStackItemsToFile(String fileName, MyStack<Product> stack, boolean append) {
        try {
            FileWriter fw = new FileWriter(fileName, append);
            BufferedWriter bw = new BufferedWriter(fw);
            Node<Product> current = stack.head;
            while (current != null) {
//                bw.newLine();
                bw.write(current.getData().getBcode() + " " + current.getData().getTitle() + " "
                        + current.getData().getQuantity() + " " + current.getData().getPrice());
                bw.newLine();
                current = current.getNext();
            }
            bw.flush();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeQueueItemsToFile(String fileName, MyQueue<Product> queue, boolean append) {
        try {
            FileWriter fw = new FileWriter(fileName, append);
            BufferedWriter bw = new BufferedWriter(fw);
            Node<Product> current = queue.head;
            while (current != null) {
//                bw.newLine();
                bw.write(current.getData().getBcode() + " " + current.getData().getTitle() + " "
                        + current.getData().getQuantity() + " " + current.getData().getPrice());
                bw.newLine();
                current = current.getNext();
            }
            bw.flush();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//  Searching product by ID input from keyboard --> done
    public boolean searchByBCode(MyList<Product> list, String id) {
        /**
         * @param list danh sách sản phẩm - nơi cần tìm sản phẩm theo id
         * @param id sản phẩm cần tìm được nhập từ bàn phím
         */
        Node<Product> current = list.head;
        boolean isFound = false;
        if (current == null) return false;
        while (current != null) {
            if (current.getData().getBcode().equalsIgnoreCase(id)) {
                System.out.println("ID found: ");
                System.out.println("+---------------+---------------+---------------+------------+");
                System.out.printf("|%-15s|%-15s|%-15s|%-12s|%n", "ID", "TITLE", "QTY", "PRICE");
                System.out.println("+---------------+---------------+---------------+------------+");
                System.out.print(current.getData().toString());
                System.out.println("+---------------+---------------+---------------+------------+");
                isFound = true;
            }
            current = current.next;
        }
        if (!isFound) return false;
        return true;
    }

    //hàm search ID
    public Node<Product> searchNodeByKey(MyList<Product> list, String key){
        Node<Product> cur = list.head;
        while (cur!= null){
            if(cur.getData().getBcode().equalsIgnoreCase(key)){
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }


//  Deleting first product that has the ID input from keyboard from the list. --> done
    public void deleteByBcode(MyList<Product> list,String key) {
        /** xóa 1 node theo key
         * @param list danh sách thao tác
         * @param key cần xóa khỏi danh sách
         */
        Node<Product> curNode = list.head;
        if(curNode == null) return;

        //xóa node đầu
        if(curNode.getData().getBcode().equalsIgnoreCase(key)){
            list.head = curNode.getNext();
            System.out.println("first");
            return;
        }while (curNode.next != null){

            //xóa node cuối
            if(curNode.getNext() == list.tail && curNode.getNext().getData().getBcode().equalsIgnoreCase(key)){
                curNode.setNext(null);
                list.tail = curNode;
                System.out.println("last");
                break;

                //xóa node giữa
            }else if(curNode.getNext().getNext() != null && curNode.getNext().getData().getBcode().equalsIgnoreCase(key)){
                curNode.setNext(curNode.getNext().getNext());
//                curNode.setNext(null);
                System.out.println("middle");
                break;

            }
            //di chuyển đến node tiếp theo
            curNode = curNode.getNext();
        }
    }

//  hàm sắp xếp danh sách theo ID
    public void sortByID(MyList<Product> list) {
        list.sortList();
    }

//  Convert a decimal to a integer number. Example: input i = 18 -> Output = 10010, hàng này thực hiện trong stack
//  vì sẽ ghi kết quả ngược lại - sử dụng nguyên tắc LastIn - FirstOut
    public void convertToBinary(Product product, MyStack<String> binary) {
        product.coverQTYToBinary(product.getQuantity(), binary);
    }

    //  hàm sort bằng đệ quy
    public void sortByRecursion(MyList<Product> list){
        list.mergeSort(list.head);
    }
}

