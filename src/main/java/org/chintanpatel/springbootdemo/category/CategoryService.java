package org.chintanpatel.springbootdemo.category;

import java.util.List;

public interface CategoryService {

    void addCategory(Category category);

    List<Category>getAllCategoryList();

    Category getCategoryById(Long categoryId);

    void deleteCategoryById(Long categoryId);

    List<Category>searchByCategoryName(String categoryName);
}
