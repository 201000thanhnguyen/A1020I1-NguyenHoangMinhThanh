package Models.service.impl;

import Models.bean.Product;
import Models.repository.IProductRepository;
import Models.repository.impl.ProductRepository;
import Models.service.IProductService;

import java.util.List;

public class ProductService implements IProductService {

    private IProductRepository productRepository = new ProductRepository();

    @Override
    public List<Product> listProduct() {
        return this.productRepository.listProduct();
    }

    @Override
    public String editProduct(String idProduct, String nameProduct, Double priceProduct, String imgProduct) {
        String msg = this.productRepository.editProduct(idProduct, nameProduct, priceProduct, imgProduct);
        return msg;
    }

    @Override
    public String addProduct(Product product) {
        String msg = this.productRepository.addProduct(product);
        return msg;
    }

    @Override
    public String deleteProduct(int index) {
        String msg = this.productRepository.deleteProduct(index);
        return msg;
    }
}
