package jpa.shop.controller.main;

import jpa.shop.domain.Member;
import jpa.shop.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    MemberRepository memberRepository;

    @GetMapping("")
    public String main(Model model) {
        List<Member> list = memberRepository.findAll();
        model.addAttribute("members", list);
        return "index";
    }
}
