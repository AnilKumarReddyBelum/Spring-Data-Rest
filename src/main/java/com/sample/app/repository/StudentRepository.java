package com.sample.app.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sample.app.model.Student;

@Repository
@Transactional
public interface StudentRepository extends JpaRepository<Student, Integer> {

	@Modifying
	@Query("update Student s set s.address = :address where s.id in :listOfKeys")
	public int updateByUsingIds(@Param("listOfKeys") Set<Integer> listOfKeys, @Param("address") String address);

}
