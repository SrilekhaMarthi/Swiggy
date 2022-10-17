package com.swiggy.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.swiggy.app.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item,Long>{

}
