package com.example.demo.ifaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Enroller;

@Repository
public interface IEnroller  extends JpaRepository<Enroller,Integer >{
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("UPDATE Enroller e SET e.status = :newStatus  WHERE e.id = :id")
	  int updateEnrollerStatus(@Param("id") int id, @Param("newStatus") boolean newStatus);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("UPDATE Enroller e SET e.phoneNumber = :newphoneNumber  WHERE e.id = :id")
	  int updateEnrollerPhoneNumber(@Param("id") int id, @Param("newphoneNumber") Long newphoneNumber);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("UPDATE Enroller e SET e.dependent = null  WHERE e.dependent = :dp_id")
	  void removeDependent( @Param("dp_id") int dp_id);
	
}
