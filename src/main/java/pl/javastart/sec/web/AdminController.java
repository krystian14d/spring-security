package pl.javastart.sec.web;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.javastart.sec.user.UserService;

import java.util.List;

@AllArgsConstructor
@Controller
public class AdminController {

    private final UserService userService;

    @GetMapping
    String adminPanel(Model model){
        List<String> allUserEmails = userService.findAllUserEmails();
        model.addAttribute("userEmails", allUserEmails);
        return "admin";
    }

    @GetMapping("/delete-user")
    String deleteUser(@RequestParam String email){
        userService.deleteUserByEmail(email);
        return "redirect:/admin";
    }
}
