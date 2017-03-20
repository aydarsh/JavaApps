package app.main.controller;

import app.main.model.Students;
import app.main.service.StudentsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class StudentsController {
    private static final Logger logger = LoggerFactory.getLogger(StudentsController.class);
    
    @Autowired
    private StudentsService studentsService;

//    @Autowired(required = true)
    @Qualifier(value = "studentsService")
    public void setStudentsService(StudentsService studentsService, String value) {
        this.studentsService = studentsService;
    }
    
    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public String listStudents(Model model){
//        model.addAttribute("student", new Students());
        model.addAttribute("listStudents", this.studentsService.listStudents());
        return "index";
    }
    
    @RequestMapping(value = "/students", method = RequestMethod.POST)
    public String addStudent(@ModelAttribute("student") Students student){
	logger.info("student.name: "+student.getName()+" birthday: "+student.getBirthday());
	this.studentsService.addStudent(student);
	return "redirect:/students";
    }
    
    @RequestMapping(value = "/students/new", method = RequestMethod.GET)
    public String newStudent(Model model){
	model.addAttribute("student", new Students());
	return "new";
    }
    
    
    //	model.addAttribute("name", student.getName());
//	model.addAttribute("birthday", student.getBirthday());
//	model.addAttribute("groupNo", student.getGroupNo());
 
    
    @RequestMapping(value = "/students/{id}", method = RequestMethod.DELETE)
    public String removeStudent(@PathVariable("id") int id){
        this.studentsService.removeStudent(id);
        return "redirect:/students";
    }
    
    @RequestMapping(value = "/students/{id}/edit", method = RequestMethod.GET)
    public String editStudent(@PathVariable("id") int id, Model model){
        model.addAttribute("student", this.studentsService.getStudentById(id));
//        model.addAttribute("listStudents", this.studentsService.listStudents());
        return "edit";
    }
    
    @RequestMapping(value = "/students/{id}", method = RequestMethod.PUT)
    public String updateStudent(@ModelAttribute("student") Students student, Model model){
	this.studentsService.updateStudent(student);
	return "redirect:/students";
    }
    
    @RequestMapping(value = "/students/{id}", method = RequestMethod.GET)
    public String studentData(@PathVariable("id") int id, Model model){
        model.addAttribute("student", this.studentsService.getStudentById(id));
        return "show";
    }
}