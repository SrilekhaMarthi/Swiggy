package com.swiggy.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.swiggy.app.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

}
