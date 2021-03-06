package pl.javastart.sec.web;

import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.javastart.sec.message.WelcomeMessageService;

@Controller
public class HomeController {

    private WelcomeMessageService welcomeMessageService;

    public HomeController(WelcomeMessageService welcomeMessageService) {
        this.welcomeMessageService = welcomeMessageService;
    }

    @GetMapping("/")
    String home() {
        return "index";
    }
}
