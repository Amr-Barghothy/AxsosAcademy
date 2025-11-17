package com.example.loginandregistration.Controllers;

import com.example.loginandregistration.Models.LoginUser;
import com.example.loginandregistration.Models.User;
import com.example.loginandregistration.Services.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index(@ModelAttribute("user") User user, @ModelAttribute("loginUser") LoginUser loginUser) {
        return "index";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("loginUser") LoginUser loginUser, BindingResult bindingResult, HttpSession session, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("user", new User());
            return "index";
        }
        User user2 = userService.findByEmail(loginUser.getLoginEmail());
        System.out.println(user2);
        if (user2 == null) {
            bindingResult.rejectValue("loginEmail", "error", "The email or password is incorrect");
            model.addAttribute("user", new User());
            return "index";
        } else {
            if (!BCrypt.checkpw(loginUser.getLoginPassword(), user2.getPassword())) {
                bindingResult.rejectValue("loginPassword", "Matches", "The email or password is incorrect");
                model.addAttribute("user", new User());
                return "index";
            }
            session.setAttribute("user_id", user2.getId());
            return "redirect:/welcome";
        }
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, HttpSession session, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("loginUser", new LoginUser());
            return "index";
        }
        if (!user.getPassword().equals(user.getConfirmPassword())) {
            bindingResult.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
            model.addAttribute("loginUser", new LoginUser());
            return "index";
        }
        try {
            String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
            user.setPassword(hashedPassword);
            userService.saveUser(user);
        } catch (DataIntegrityViolationException e) {
            bindingResult.addError(new FieldError("user", "email", "This email is already registered"));
            model.addAttribute("loginUser", new LoginUser());
            return "index";
        }
        session.setAttribute("user_id", user.getId());
        return "redirect:/welcome";
    }

    @GetMapping("/welcome")
    public String welcome(Model model, HttpSession session, RedirectAttributes redirectAttributes) {
        if(session.getAttribute("user_id") == null) {
            redirectAttributes.addFlashAttribute("error", "You must login or register first");
            return "redirect:/";
        }
        User user = userService.findById((Long)session.getAttribute("user_id"));
        model.addAttribute("user", user);
        return "welcome";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
