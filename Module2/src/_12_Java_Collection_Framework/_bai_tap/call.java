package _12_Java_Collection_Framework._bai_tap;

public class call {
    public static void main(String[] args) {

        Product product2 = new Product(2,"product 2",24.3);
        Product product1 = new Product(1,"product 1",22.3);
        Product product3 = new Product(3,"product 3",25.3);


        Product.listProduct.add(product2);
        Product.listProduct.add(product1);
        Product.listProduct.add(product3);

        Product.menu(Product.listProduct);

    }
}
