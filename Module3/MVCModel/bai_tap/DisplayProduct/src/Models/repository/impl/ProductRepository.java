package Models.repository.impl;

import Models.bean.Product;
import Models.repository.IProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ProductRepository implements IProductRepository {

    static List<Product> listProduct = new ArrayList<>();

    static {
        listProduct.add(new Product(UUID.randomUUID().toString(), "product 1", 123.1, "/Images/noAvatar.jpg"));
        listProduct.add(new Product(UUID.randomUUID().toString(), "product 2", 199.9, "/Images/noAvatar.jpg"));
        listProduct.add(new Product(UUID.randomUUID().toString(), "product 3", 101.2, "/Images/noAvatar.jpg"));
        listProduct.add(new Product(UUID.randomUUID().toString(), "product 4", 157.3, "/Images/noAvatar.jpg"));
    }

    @Override
    public List<Product> listProduct() {
        return this.listProduct;
    }

    @Override
    public String editProduct(String idProduct, String nameProduct, Double priceProduct, String imgProduct) {
        for (Product item : listProduct) {
            if (item.getIdProduct().equals(idProduct)){
                item.setNameProduct(nameProduct);
                item.setPriceProduct(priceProduct);
                item.setImgProduct(imgProduct);
                return "edit complete";
            }
        }
        return "edit not complete";
    }

    @Override
    public String addProduct(Product product) {
        String msg = null;
        if (listProduct.add(product)){
            return msg = "add complete";
        }
        return msg = "add not complete";
    }

    @Override
    public String deleteProduct(int index) {
        try {
            listProduct.remove(index);
            return "remove complete";
        }catch (Exception e){
            return "remove not complete! error : " + e;
        }
    }


}
