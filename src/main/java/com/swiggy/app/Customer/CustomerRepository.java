package com.swiggy.app.Customer;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long>{
	
//	@Query("select c.address from Customer c where c.id=:id")
//	String findAddressById(@Param("id") Long id);
//	
//	@Query("select c.mail from Customer c where c.id=:id")
//	String findMailById(@Param("id") Long id);
//	
//	@Query("select c.phone from Customer c where c.id=:id")
//	String findPhoneById(@Param("id") Long id);
//	
//	@Query("select c.name from Customer c WHERE c.id=:id")
//	String findNameById(@Param("id") Long id);
}
