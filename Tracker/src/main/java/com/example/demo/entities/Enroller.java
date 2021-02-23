package com.example.demo.entities;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
//import javax.validation.constraints.NotNull;
import javax.servlet.annotation.MultipartConfig;

import org.springframework.stereotype.Component;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Component
@Data
@FieldDefaults(level=AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor

@Table(name="Enroller")
@Entity
public class Enroller {

	
	@Id
	int id;
	@Column(nullable = false)
	String firstName;
	@Column(nullable = false)
	String lastName;
	
	long phoneNumber;
	
	boolean status;
	@Column(nullable = false)
	Date birthDate;
	
	@ManyToOne
	@JoinColumn(name="dependent_id")
	Dependent dependent;
	
}
