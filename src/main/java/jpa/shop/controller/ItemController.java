package jpa.shop.controller;

import jpa.shop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ItemController {

    @Autowired
    ItemService itemService;

    @GetMapping("/item")
    public String itemPage(Model model) {
        model.addAttribute("items", itemService.findItems());
        return "views/items";
    }
}
