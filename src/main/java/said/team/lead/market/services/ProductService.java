package said.team.lead.market.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import said.team.lead.market.models.Product;
import said.team.lead.market.repositories.ProductsRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductsRepository productsRepository;

    @Autowired
    public ProductService(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    public List<Product> findAll() {
        return productsRepository.findAll();
    }

    public Product findOne(int id) {
        Optional<Product> foundProduct =  productsRepository.findById(id);
        return foundProduct.orElse(null);
    }

    public void save(Product product) {
        productsRepository.save(product);
    }

    public void update(int id, Product updatedProduct) {
        updatedProduct.setId(id);
        productsRepository.save(updatedProduct);
    }

    public void delete(int id) {
        productsRepository.deleteById(id);
    }
}
