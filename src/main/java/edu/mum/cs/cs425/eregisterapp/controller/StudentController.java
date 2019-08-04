package edu.mum.cs.cs425.eregisterapp.controller;

import com.sun.org.apache.bcel.internal.generic.DCONST;
import edu.mum.cs.cs425.eregisterapp.model.Student;
import edu.mum.cs.cs425.eregisterapp.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class StudentController {

    private StudentService service;
    StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping(value = {"/eregister/student"})
    public String displayNewStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "student/add-student";
    }

    public String addNewStudent(@Valid @ModelAttribute("student") Student student,
                                        BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "student/add-student";
        } else
            student = service.saveStudent(student);
            return "redirect: student/student-list";
    }

    public ModelAndView displayListOfStudent() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("students", service.getListOfStudent());
        modelAndView.setViewName("student/student-list");
        return modelAndView;
    }
}

