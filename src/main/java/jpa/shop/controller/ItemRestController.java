package jpa.shop.controller;

import jpa.shop.domain.Book;
import jpa.shop.domain.Item;
import jpa.shop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ItemRestController {

    @Autowired
    ItemService itemService;

    // 아이템 등록
    @PostMapping("/item")
    public ResponseEntity<?> createItem(@RequestBody Item item) {
        System.out.println("item name : " + item.getName());
        System.out.println("item price : " + item.getPrice());
        System.out.println("item stockQuantity : " + item.getStockQuantity());
        System.out.println("item type :" + item.getClass().getName());

        itemService.saveItem(item);
        return new ResponseEntity<>(item, HttpStatus.CREATED);
    }
}
