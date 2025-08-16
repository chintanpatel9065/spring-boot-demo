package org.chintanpatel.springbootdemo.category;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public String listCategory(Model model) {
        List<Category> categoryList = categoryService.getAllCategoryList();
        model.addAttribute("categoryList", categoryList);
        return "categoty/category-list";
    }

    @GetMapping("/categories/showCategory")
    public String showCategoryForm(Model model) {
        Category category = new Category();
        model.addAttribute("category", category);
        return "categoty/category-form";
    }

    @PostMapping("/categories/insertOrUdpateCategory")
    public String insertOrUpdateCategory(@Valid @ModelAttribute("category") Category category, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "categoty/category-form";
        }
        categoryService.addCategory(category);
        return "redirect:/categories";
    }

    @GetMapping("/categories/manageCategory/{categoryId}")
    public String manageCategory(@PathVariable Long categoryId, Model model) {
        if (categoryId != null) {
            Category category = categoryService.getCategoryById(categoryId);
            model.addAttribute("category", category);
        }
        return "categoty/category-form";
    }

    @GetMapping("/categories/deleteCategory/{categoryId}")
    public String deleteCategory(@PathVariable Long categoryId) {
        if (categoryId != null) {
            categoryService.deleteCategoryById(categoryId);
        }
        return "redirect:/categories";
    }

    @GetMapping("/categories/search/categoryName")
    public String searchCategory(@RequestParam("categoryName") String categoryName, Model model) {
        List<Category> categoryList = categoryService.searchByCategoryName(categoryName);
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("categoryName", categoryName);
        model.addAttribute("searchType", "categoryName");
        return "categoty/category-list";
    }
}
