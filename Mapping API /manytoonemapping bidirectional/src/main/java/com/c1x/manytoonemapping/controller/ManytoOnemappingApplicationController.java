package com.c1x.manytoonemapping.controller;

import com.c1x.manytoonemapping.entity.Cart;
import com.c1x.manytoonemapping.entity.Item;
import com.c1x.manytoonemapping.repository.CartRepository;
import com.c1x.manytoonemapping.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/manytoone")
public class ManytoOnemappingApplicationController {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ItemRepository itemRepository;

    @PostMapping("addItems")
    public Item addItem(@RequestBody Item item) {
        itemRepository.save(item);
        return item;
    }

    @PostMapping("addCart")
    public Cart addCart(@RequestBody Cart cart) {
        cartRepository.save(cart);
        return cart;
    }

    @PostMapping("addItems/cart/{id}")
    public Item addItemInCart(@PathVariable long id, @RequestBody Item item) {
        Cart getCart = cartRepository.findById(id).orElseThrow(null);
        item.setCart(getCart);
        itemRepository.save(item);
        return item;
    }

    @GetMapping("getItems/{id}")
    public Item getItems(@PathVariable long id) {
        Item item = itemRepository.findById(id).orElseThrow(null);
        return item;
    }

    @GetMapping("getCart/{id}")
    public Cart getCart(@PathVariable long id) {
        Cart cart = cartRepository.findById(id).orElseThrow(null);
        return cart;
    }

    @PutMapping("update/item/{id}")
    public Item updateItemById(@PathVariable long id, @RequestBody Item item) {
        Item getItem = itemRepository.findById(id).orElseThrow(null);

        getItem.setProductName(item.getProductName());
        getItem.setCategory(item.getCategory());
        getItem.setProductPrice(item.getProductPrice());
        getItem.setProductRating(item.getProductRating());
        getItem.setQuantity(item.getQuantity());

        Cart cart =  cartRepository.findById(item.getCart().getId()).orElseThrow(null);

        String cartName = cart.getName();

        getItem.setCart(item.getCart());

        getItem.getCart().setName(cartName);

        itemRepository.save(getItem);
        return getItem;
    }

    @PutMapping("update/cart/{id}")
    public Cart updateCartById(@PathVariable long id, @RequestBody Cart cart) {
        Cart getCart = cartRepository.findById(id).orElseThrow(null);

        getCart.setName(cart.getName());
        getCart.setItems(cart.getItems());

        cartRepository.save(getCart);
        return getCart;
    }

    @DeleteMapping("delete/cart/{id}")
    public Cart deleteCartById(@PathVariable long id) {
        Cart getCart = cartRepository.findById(id).orElseThrow(null);
        cartRepository.deleteById(id);
        return getCart;
    }

    @DeleteMapping("delete/item/{id}")
    public Item deleteItemById(@PathVariable long id) {
        Item getItem = itemRepository.findById(id).orElseThrow(null);
        getItem.setCart(null);
        itemRepository.deleteById(id);
        return getItem;
    }

}
