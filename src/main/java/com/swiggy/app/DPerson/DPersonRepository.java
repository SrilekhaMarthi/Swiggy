package com.swiggy.app.DPerson;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DPersonRepository extends JpaRepository<DPerson,Long>{
	
//	@Query("select d.name from DPerson d where d.id=:id")
//	String findNameById(@Param("id") Long id);
//	
//	@Query("select d.phoneNumber from DPerson d where d.id=:id")
//	String findPhoneNumberById(@Param("id") Long id);
//	
//	@Query("select d.estDelTime from DPerson d where d.id=:id")
//	String findDelTimeById(@Param("id") Long id);
	
}
