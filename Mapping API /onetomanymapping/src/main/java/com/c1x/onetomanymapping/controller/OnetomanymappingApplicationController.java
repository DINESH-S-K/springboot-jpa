package com.c1x.onetomanymapping.controller;

import com.c1x.onetomanymapping.entity.Cart;
import com.c1x.onetomanymapping.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/onetomany")
public class OnetomanymappingApplicationController {
    @Autowired
    private CartRepository cartRepository;

    @PostMapping("addCart")
    public Cart addCart(@RequestBody Cart cart) {
        cartRepository.save(cart);
        return cart;
    }

    @GetMapping("getCart")
    public Cart getCart(@RequestParam long id) {
        Cart cart = cartRepository.findById(id).orElseThrow(null);
        return cart;
    }

    @PutMapping("update/cart/{id}")
    public Cart updateCartById(@PathVariable long id, @RequestBody Cart cart) {
        Cart getCart = cartRepository.findById(id).orElseThrow(null);
        getCart.setName(cart.getName());
        getCart.setItem(cart.getItem());
//        List<Item> item = getCart.getItem();
//        item.forEach(itemInfo -> {
//        if (itemInfo.getId() == id) {
//            itemInfo
//            userInfo.setLocation(user.getLocation());
//        }
//    });
        cartRepository.save(getCart);
        return getCart;
    }

    @DeleteMapping("delete/cart/{id}")
    public Cart deleteCartById(@PathVariable long id) {
        Cart getCart = cartRepository.findById(id).orElseThrow(null);
        cartRepository.deleteById(id);
        return getCart;
    }

}
