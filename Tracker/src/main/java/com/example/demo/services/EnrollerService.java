package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Dependent;
import com.example.demo.entities.Enroller;
import com.example.demo.ifaces.IDependent;
import com.example.demo.ifaces.IEnroller;

@Service
public class EnrollerService {

	@Autowired
	private IEnroller repo;
	private IDependent repoDependent;
	
	public List<Enroller> findAll() {
		
		return this.repo.findAll();
		
	}
	
	public Enroller add(Enroller enroller) {
		
		return this.repo.save(enroller);
	}
	
	public  void delete(int id) {
		
		this.repo.deleteById(id);
		
			
	}
	
	public int updatestatus(int id, boolean status)
	{
		
		return this.repo.updateEnrollerStatus(id, status);
	}
	
	public int updatephonenumber(int id, Long phoneNumber)
	{
		
		return this.repo.updateEnrollerPhoneNumber(id, phoneNumber);
	}
	
	public void addDependent( Dependent dependent) {
		
//		enroller.getDependent().setDependent_id(dependent.getDependent_id());
//		enroller.getDependent().setDependent_birthdate(dependent.getDependent_birthdate());
//		enroller.getDependent().setDependent_name(dependent.getDependent_name());
		this.repoDependent.save(dependent);
	}
	
	public void removeDependent(Enroller enrollee,int dp_id) {
		this.repo.removeDependent( dp_id);
		enrollee.setDependent(null);
	}
	
}
