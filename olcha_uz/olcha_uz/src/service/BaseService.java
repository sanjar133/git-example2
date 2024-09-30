package service;

import model.Category;
import model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public interface BaseService<T, R>{
    R add(String currentUser, T t);
    R getById(UUID id);
    void deleteById(String currentUser, UUID id);
    List<R> getList();

    List<Category> categoryList = new ArrayList<>();
    List<Product> productList = new ArrayList<>();
}
