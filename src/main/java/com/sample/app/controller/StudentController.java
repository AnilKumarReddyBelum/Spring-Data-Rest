package com.sample.app.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sample.app.model.Student;
import com.sample.app.repository.StudentRepository;

@RestController
public class StudentController {

	@Autowired
	StudentRepository repo;

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	Student create(Student student) {
		return repo.save(student);
	}

	@RequestMapping(value = "/getAllStudents", method = RequestMethod.GET)
	List<Student> getAllStudents() {
		return repo.findAll();
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	Student update(@RequestBody Student student) {
		return repo.save(student);
	}

	@RequestMapping(value = "/bulkUpdate", method = RequestMethod.PUT)
	Integer bulkUpdate(@RequestBody List<Student> list) {
		List<Student> updatedList = repo.save(list);
		int size = (updatedList != null) ? updatedList.size() : 0;
		return size;
	}

	@RequestMapping(value = "/updateByUsingIds/{ids}/{address}", method = RequestMethod.GET)
	Integer updateByUsingIds(@PathVariable("ids") String ids, @PathVariable("address") String address) {
		Set<Integer> set = new HashSet<Integer>();
		StringTokenizer stringTokenizer = new StringTokenizer(ids, ",");
		while (stringTokenizer.hasMoreTokens()) {
			set.add(Integer.parseInt(stringTokenizer.nextToken()));
		}
		return repo.updateByUsingIds(set, address);
	}
	
	
	@RequestMapping(value = "/bulkUpdate", method = RequestMethod.POST)
	Integer bulkUpdate(@RequestBody BulkUpdateInput bulkUpdateInput) {
		return repo.updateByUsingIds(bulkUpdateInput.getSet(), bulkUpdateInput.getAddress());
	}

}
