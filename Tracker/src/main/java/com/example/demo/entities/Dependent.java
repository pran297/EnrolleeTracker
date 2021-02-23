package com.example.demo.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level=AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor

@Table(name="Dependents")
@Entity
public class Dependent {

	
	
	@Id
	int dependent_id;
	String dependent_name;

	Date dependent_birthdate;
}
