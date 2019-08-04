package edu.mum.cs.cs425.eregisterapp.controller;

import edu.mum.cs.cs425.eregisterapp.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.validation.Valid;

@Controller
public class StudentController {

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
            return "student/add-student";
    }
}

