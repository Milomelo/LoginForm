package site.metacoding.login.web;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;
import site.metacoding.login.service.UserService;
import site.metacoding.login.util.UtilValid;
import site.metacoding.login.web.dto.JoinReqDto;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;

    @GetMapping("/joinForm")
    public String joinForm() {
        return "joinForm";
    }

    @GetMapping("/loginForm")
    public String loginForm() {
        return "loginForm";
    }

    @PostMapping("/join")
    public String join(@Valid JoinReqDto joinReqDto, BindingResult bindingResult) {

        UtilValid.요청에러처리(bindingResult);
        userService.회원가입(joinReqDto.toEntity());
        return "redirect:/joinForm";
    }

    @GetMapping("/popup/jusoPopup")
    public String jusoPopup() {
        return "/jusoPopup";
    }

    @GetMapping("/")
    public String jusoApi() {
        return "/sample";
    }

    @PostMapping("/popup/jusoPopup")
    public String postMethodName(String inputYn, String roadFullAddr, Model model) {
        System.out.println(inputYn);
        System.out.println(roadFullAddr);
        System.out.println(model.addAttribute("roadFullAddr", roadFullAddr));
        System.out.println(model.addAttribute("inputYn", inputYn));
        return "/jusoPopup";
    }

}