package org.chintanpatel.springbootdemo.category;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service( "categoryService")
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void addCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public List<Category> getAllCategoryList() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Long categoryId) {
        return categoryRepository.findById(categoryId).orElse(null);
    }

    @Override
    public void deleteCategoryById(Long categoryId) {
        categoryRepository.deleteById(categoryId);
    }

    @Override
    public List<Category> searchByCategoryName(String categoryName) {
        return categoryRepository.findByCategoryNameContainingIgnoreCase(categoryName);
    }
}
