package Models.service;

import Models.bean.Product;

import java.util.List;

public interface IProductService {
    List<Product> listProduct();

    String editProduct(String idProduct, String nameProduct, Double priceProduct, String imgProduct);

    String addProduct(Product product);

    String deleteProduct(int index);
}
