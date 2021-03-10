package _12_Java_Collection_Framework._bai_tap;

import java.util.*;

public class Product {
    public static List<Product> listProduct = new ArrayList<>();

    public static void menu(List<Product> listProduct) {
        Scanner scanner = new Scanner(System.in);
        boolean stop = false;
        int choose;
        boolean exit = false;
        do {
            System.out.println("=================================");
            System.out.println(
                    "1.\tadd \n" +
                    "2.\tedit \n" +
                    "3.\tdelete \n" +
                    "4.\tshow product \n" +
                    "5.\tsearch \n" +
                    "6.\tsort \n" +
                    "7.\tExit"
            );
            System.out.println("=================================");
            System.out.print("choose ? : ");
            choose = scanner.nextInt();
            switch (choose){
                case 1:
                    addProduct();
                    break;
                case 2:
                    showProduct(listProduct);
                    System.out.print("input stt : ");
                    editProduct(scanner.nextInt());
                    break;
                case 3:
                    showProduct(listProduct);
                    System.out.print("input stt : ");
                    deleteProduct(scanner.nextInt());
                    break;
                case 4:
                    showProduct(listProduct);
                    System.out.print("input any key then enter : ");
                    scanner.next();
                    break;
                case 5:
                    System.out.println("search");
                    break;
                case 6:
                    System.out.println("sort");
                    break;
                case 7:
                    stop = true;
                    break;
                default:
                    break;
            }
        }while (!stop);
    }

    private int id;
    private String name;
    private double price;

    public Product() {
    }

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public static void showProduct(List<Product> listProduct){
        if (listProduct.size() <= 0){
            System.out.println("no products");
        }else {
            int stt =1;
            for (var item :
                    listProduct) {
                System.out.println("stt " + stt++ +" : "+item.toString());
            }
        }
    }

    public static void addProduct(){
        int id;
        String name;
        double price;
        Scanner scanner = new Scanner(System.in);
        System.out.print("id product : ");
        id = scanner.nextInt();
        System.out.print("name product : ");
        scanner.skip("\\R");
        name = scanner.nextLine();
        System.out.print("price product : ");
        price = scanner.nextDouble();
        Product product = new Product(id,name,price);
        Product.listProduct.add(product);
    }

    public static void editProduct(int stt){
        Scanner scanner = new Scanner(System.in);
        stt -= 1;
        if (stt < listProduct.size()) {
            System.out.println(listProduct.get(stt));
            for (int i = 0; i < listProduct.size(); i++){
                if (i == stt){
                    System.out.print("input id : ");
                    listProduct.get(i).setId(scanner.nextInt());
                    System.out.print("input name : ");
                    scanner.skip("\\R");
                    listProduct.get(i).setName(scanner.nextLine());
                    System.out.print("input price : ");
                    listProduct.get(i).setPrice(scanner.nextDouble());
                }
            }
        }else {
            System.out.println("stt not found");
        }
    }

    public static void deleteProduct(int stt) {
        Scanner scanner = new Scanner(System.in);
        stt -= 1;
        System.out.println("are you sure delete : ");
        System.out.println(listProduct.get(stt).toString() + " ?");
        System.out.print("yes : Y/y \t no : N/n \t : ");
        String b = scanner.nextLine();
        if (b.equals("Y") || b.equals("y")){
            listProduct.remove(stt);
        }else if (b.equals("N") || b.equals("n")){

        }else {
            System.out.println("? " + b);
        }
    }

}
