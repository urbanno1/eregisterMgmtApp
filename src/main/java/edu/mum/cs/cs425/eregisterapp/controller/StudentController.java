package edu.mum.cs.cs425.eregisterapp.controller;

import edu.mum.cs.cs425.eregisterapp.model.Student;
import edu.mum.cs.cs425.eregisterapp.service.StudentService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

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

    @GetMapping(value = {"/eregister/student/edit/{studentId}", "eregister/student/edit/{studentId}"})
    public String editStudent(@PathVariable Long studentId, Model model) {
        Student student = service.getStudentById(studentId);
        if(student != null) {
            model.addAttribute("student", student);
            return "student/edit-student";
        }
        return "student/student-list";
    }

    @PostMapping(value = {"/eregister/student/update", "eregister/student/update"})
    public String updateStudent(@ModelAttribute(name="student") Student student,
                                BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
        }
         service.saveStudent(student);
        model.addAttribute("success", "Student saved successfully");
        return "redirect:/eregister/student/list";
    }

    @GetMapping(value = {"/eregister/student/search"})
    public ModelAndView searchStudent(@RequestParam String searchString, @RequestParam int pageNo) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("students", service.searchStudent(searchString, pageNo));
        modelAndView.addObject("currentPageNo", pageNo);
        modelAndView.addObject("searchString", searchString);

        modelAndView.setViewName("student/student-list");
        return modelAndView;
    }

}

