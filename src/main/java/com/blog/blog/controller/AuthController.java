package com.blog.blog.controller;

import com.blog.blog.dto.RegistrationDto;
import com.blog.blog.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    //Handler method to handle signup request
    @GetMapping("/register")
    public String showSignupForm(Model model) {
        model.addAttribute("registrationDto", new RegistrationDto());
        return "signup";
    }

    @PostMapping("/register/save")
    public String processRegistration(@Valid @ModelAttribute RegistrationDto registrationDto, BindingResult result, Model model) {
        if(userService.findByEmail(registrationDto.getEmail()) != null){
            result.rejectValue("email", "error.email", "Email already exists");
        }
        if(result.hasErrors()){
            model.addAttribute("registrationDto", registrationDto);
            return "register";
        }

        userService.saveUser(registrationDto);
        return "redirect:/register?success";
    }
}
