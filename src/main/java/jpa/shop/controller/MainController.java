package jpa.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class MainController {

    @GetMapping("/")
    public void main (HttpServletResponse response) throws IOException {
        response.sendRedirect("/member");
    }
}
