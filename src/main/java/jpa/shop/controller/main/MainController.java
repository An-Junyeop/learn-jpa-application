package jpa.shop.controller.main;

import jpa.shop.domain.Member;
import jpa.shop.repository.MemberRepository;
import jpa.shop.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    MemberService memberService;

    @GetMapping("")
    public String main(Model model) {
        Member member = memberService.findOne(9L);

        model.addAttribute("member", member);
        return "index";
    }
}
