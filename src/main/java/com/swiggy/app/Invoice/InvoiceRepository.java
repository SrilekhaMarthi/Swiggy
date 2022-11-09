package com.swiggy.app.Invoice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
//	@Query("select i.cartSubTotal from Invoice i where i.id=:id")
//	double findCartSubTotalById(@Param("id") Long id);
//	
//	@Query("select i.gst from Invoice i where i.id=:id")
//	double findGstById(@Param("id") Long id);
//	
//	@Query("select i.deliveryCharges from Invoice i where i.id=:id")
//	double findDeliveryChargesById(@Param("id") Long id);
//	
//	@Query("select i.link from Invoice i where i.id=:id")
//	String findLinkById(@Param("id") Long id);

}
