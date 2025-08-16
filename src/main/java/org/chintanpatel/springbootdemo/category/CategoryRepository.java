package org.chintanpatel.springbootdemo.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository( "categoryRepository")
public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category>findByCategoryNameContainingIgnoreCase(String categoryName);
}