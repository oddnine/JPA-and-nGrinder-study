package com.start.traffic.controller.sign;

import com.start.traffic.domain.Member;
import com.start.traffic.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/signin")
public class SignInController {
    private final MemberService memberService;

    @GetMapping
    public String signInForm(@ModelAttribute("signForm") SignForm form) {
        return "sign/signin";
    }

    @PostMapping
    public String signIn(@ModelAttribute("signForm") SignForm form, BindingResult bindingResult) {
        Member member = Member.builder()
                .email(form.getEmail())
                .password(form.getPassword())
                .build();

        if (!memberService.signIn(member)) {
            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다.");
            return "sign/signin";
        }

        return "redirect:/board";
    }
}
