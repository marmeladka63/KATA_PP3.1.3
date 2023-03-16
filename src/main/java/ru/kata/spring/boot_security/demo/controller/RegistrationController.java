package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RegistrationService;
import ru.kata.spring.boot_security.demo.service.RoleService;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    private final RegistrationService registrationService;
    private final RoleService roleService;

    @Autowired
    public RegistrationController(RegistrationService registrationService, RoleService roleService) {
        this.registrationService = registrationService;
        this.roleService = roleService;
    }


    @GetMapping()
    public String regPage(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("roles", roleService.getAllRole());
        return "registration";
    }

    @PostMapping()
    public String formReg(@ModelAttribute("user") User user) {
        registrationService.register(user);
        return "redirect:/login";
    }


}

