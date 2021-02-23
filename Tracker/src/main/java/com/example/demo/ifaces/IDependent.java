package com.example.demo.ifaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Dependent;

@Repository
public interface IDependent extends JpaRepository<Dependent, Integer> {

}
