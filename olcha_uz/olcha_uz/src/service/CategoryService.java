package service;

import controller.dto.CategoryCreateRequest;
import model.Category;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CategoryService implements BaseService<CategoryCreateRequest, Category>{

    @Override
    public Category add(String currentUser, CategoryCreateRequest categoryCreateRequest) {
        String now = String.valueOf(System.currentTimeMillis());
        Category category = new Category();
        category.setName(categoryCreateRequest.getName());
        category.setParentId(categoryCreateRequest.getParentId());
        category.setCreatedBy(currentUser);
        category.setModifiedBy(currentUser);
        category.setCreatedDate(now);
        category.setModifiedDate(now);
        category.setActive(true);
        categoryList.add(category);

        return category;
    }

    @Override
    public Category getById(UUID id) {
        for (Category category : categoryList) {
            if (category.getId().equals(id)) {
                return category;
            }
        }

        return null;
    }

    @Override
    public void deleteById(String currentUser, UUID id) {
        for (Category category : categoryList) {
            if (category.getId().equals(id)) {
                category.setActive(false);
                category.setModifiedBy(currentUser);
                category.setModifiedDate(String.valueOf(System.currentTimeMillis()));

                List<Category> childCategories = getChildCategories(id);
                for (Category child: childCategories) {
                    deleteById(currentUser, child.getId());
                }
                return;
            }
        }
    }

    @Override
    public List<Category> getList() {
        List<Category> categories = new ArrayList<>();
        for (Category category : categoryList) {
            if (category.isActive()) {
                categories.add(category);
            }
        }

        return categories;
    }

    private List<Category> getChildCategories(UUID categoryId) {
        List<Category> categories = new ArrayList<>();

        for (Category category: categoryList) {
            if (category.getParentId() != null &&
                    category.getParentId().equals(categoryId)) {
                categories.add(category);
            }
        }
        return categories;
    }
    public List<Category> getParentCategories() {
        List<Category> categories = new ArrayList<>();

        for (Category category : categoryList) {
            if (category.getParentId() == null) {
                categories.add(category);
            }
        }
        return categories;
    }
}
