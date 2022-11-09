package com.swiggy.app.Payment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,Long>{
	
//	@Query("select p.mode from Payment p where p.id=:id")
//	String findModeById(@Param("id") Long id);
//	
//	@Query("select p.status from Payment p where p.id=:id")
//	String findStatusById(@Param("id") Long id);
//	
//	@Query("select p.transactionId from Payment p where p.id=:id")
//	String findTransactionIdById(@Param("id") Long id);
}
