package com.start.traffic.controller.sign;

import com.start.traffic.domain.Member;
import com.start.traffic.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/signup")
public class SignUpController {
    private final MemberService memberService;

    @GetMapping()
    public String addForm() {
        return "sign/signup";
    }

    @PostMapping
    public String save(@ModelAttribute("member") SignForm form) {
        Member member = Member.builder()
                .email(form.getEmail())
                .password(form.getPassword())
                .name(form.getName())
                .build();

        memberService.join(member);

        return "redirect:/";
    }
}
