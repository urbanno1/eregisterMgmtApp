package edu.mum.cs.cs425.eregisterapp.controller;

import edu.mum.cs.cs425.eregisterapp.model.Student;
import edu.mum.cs.cs425.eregisterapp.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class StudentController {


    private StudentService service;
    public  StudentController(StudentService service) {
        this.service = service;
    }


    @GetMapping(value = {"/eregister/student/new"})
    public String displayNewStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "student/add-student";
    }

    @PostMapping(value = {"/eregister/student/new"})
    public String addNewStudent(@Valid @ModelAttribute("student") Student student,
                                        BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "student/add-student";
        } else
            student = service.saveStudent(student);
            return "redirect:/eregister/student/list";
    }

    @GetMapping(value = {"/eregister/student/list", "/eregister/student"})
    public ModelAndView displayListOfStudent(@RequestParam(defaultValue = "0") int pageNo) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("students", service.getAllStudentsPaged(pageNo));
        modelAndView.addObject("currentPageNo", pageNo);
        modelAndView.setViewName("student/student-list");
        return modelAndView;
    }
}

