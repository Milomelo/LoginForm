package site.metacoding.login.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;
import site.metacoding.login.domain.User;
import site.metacoding.login.service.UserService;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;

    @GetMapping("/joinForm")
    public String joinForm() {
        return "joinForm";
    }

    @PostMapping("/join")
    public String join(User user) {
        userService.회원가입(user);
        return "redirect:/joinForm";
    }

    @GetMapping("/s/a")
    public String a() {
        return "joinForm";
    }
}
