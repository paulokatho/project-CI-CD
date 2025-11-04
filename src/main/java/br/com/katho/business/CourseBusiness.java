package br.com.katho.business;

import java.util.ArrayList;
import java.util.List;

import br.com.katho.service.CourseService;

// CourseBusiness = SUT - System (Method) Under Test
public class CourseBusiness {

	// Is a Dependency
	private CourseService service;
	
	public CourseBusiness(CourseService service) {
		this.service = service;
	}
	
	public List<String> retrieveCoursesRelatedToSpring(String student) {
		
		var filteredCourses = new ArrayList<String>();
		if("Foo Bar".equals(student)) return filteredCourses;
		var allCourses = service.retrieveCourses(student);
		
		for (String course : allCourses) {
			if (course.contains("Spring"))
				filteredCourses.add(course);
		}
		
		return filteredCourses;
	}
}
