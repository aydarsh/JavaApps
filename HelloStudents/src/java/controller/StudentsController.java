/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Students;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.StudentsService;

/**
 *
 * @author aydar
 */
@Controller
public class StudentsController {
    private StudentsService studentsService;

    @Autowired(required = true)
    @Qualifier(value = "studentsService")
    public void setStudentsService(StudentsService studentsService, String value) {
        this.studentsService = studentsService;
    }
    
    @RequestMapping(value = "students", method = RequestMethod.GET)
    public String listStudents(Model model){
        model.addAttribute("student", new Students());
        model.addAttribute("ListStudents", this.studentsService.listStudents());
        return "students";
    }
    
    @RequestMapping(value = "/students/add", method = RequestMethod.POST)
    public String addStudent(@ModelAttribute("student") Students student){
        if(student.getId() == 0){
            this.studentsService.addStudent(student);
        }else{
            this.studentsService.updateStudent(student);
        }
        
        return "redirect:/students";
    }
    
    @RequestMapping("/remove/{id}")
    public String removeStudent(@PathVariable("id") int id){
        this.studentsService.removeStudent(id);
        
        return "redirect:/students";
    }
    
    @RequestMapping("edit/{id}")
    public String editStudent(@PathVariable("id") int id, Model model){
        model.addAttribute("student", this.studentsService.getStudentById(id));
        model.addAttribute("listStudents", this.studentsService.listStudents());
        
        return "students";
    }
    
    @RequestMapping("studentdata/{id}")
    public String studentData(@PathVariable("id") int id, Model model){
        model.addAttribute("student", this.studentsService.getStudentById(id));
        
        return "student";
    }
}

