package com.springboot.spring.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.spring.maintainance.CourseMain;
import com.springboot.spring.Model.courseM;

@RestController
@RequestMapping("course")
public class Course {
    @Autowired
	private CourseMain courseM;
	
	
	@PostMapping(value="/saveCourse",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Course> saveCourse(@RequestBody Course course){
			courseM.save(course);
		
		return new ResponseEntity<Course>(course,HttpStatus.OK);
	}
	
	
	@GetMapping(value="/myCourse",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Course>> getCourses(){
		
		List<Course> courses= courseM.getCourses();
		
		return new ResponseEntity<List<Course>>(courses,HttpStatus.OK);
		
	}
    
}
