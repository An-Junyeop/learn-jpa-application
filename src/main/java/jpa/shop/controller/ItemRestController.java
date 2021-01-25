package jpa.shop.controller;

import jpa.shop.domain.Item;
import jpa.shop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    // 아이템 등록
    @GetMapping("/items/{id}")
    public ResponseEntity<?> createItem(@PathVariable Long id) {
        return new ResponseEntity<>(itemService.findOne(id), HttpStatus.OK);
    }

    // 아이템 등록
    @PutMapping("/items/{id}")
    public ResponseEntity<?> updateItem(@PathVariable Long id,
                                        @RequestBody Item item) {
        System.out.println("item id : " + item.getId());
        System.out.println("item name : " + item.getName());
        System.out.println("item price : " + item.getPrice());
        System.out.println("item stockQuantity : " + item.getStockQuantity());
        System.out.println("item type :" + item.getClass().getName());

        itemService.saveItem(item);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    // 아이템 삭제
    @DeleteMapping("/items/{id}")
    public ResponseEntity<?> deleteItem(@PathVariable Long id) {
        System.out.println("Item id : " + id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
