package service;

import controller.dto.ProductCreateRequest;
import model.Product;

import java.util.List;
import java.util.UUID;

public class ProductService implements BaseService<ProductCreateRequest, Product> {

    private CategoryService categoryService;

    public ProductService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public Product add(String currentUser, ProductCreateRequest productCreateRequest) {
        if (!categoryExists(productCreateRequest.getCategoryId())) {
            return null;
        }

        String now = String.valueOf(System.currentTimeMillis());
        Product product = new Product();
        product.setName(productCreateRequest.getName());
        product.setPrice(productCreateRequest.getPrice());
        product.setCategoryId(productCreateRequest.getCategoryId());
        product.setCreatedDate(now);
        product.setModifiedDate(now);
        product.setActive(true);
        product.setCreatedBy(currentUser);
        product.setModifiedBy(currentUser);
        productList.add(product);

        return product;
    }

    @Override
    public Product getById(UUID id) {
        return null;
    }

    @Override
    public void deleteById(String currentUser, UUID id) {

    }

    @Override
    public List<Product> getList() {
        return productList;
    }

    private boolean categoryExists(UUID categoryId){
        return categoryService.getById(categoryId) != null;
    }
}
