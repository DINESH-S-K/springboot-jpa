package com.c1x.onetomanymapping;

import com.c1x.onetomanymapping.entity.Cart;
import com.c1x.onetomanymapping.entity.Item;
import com.c1x.onetomanymapping.repository.CartRepository;
import com.c1x.onetomanymapping.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class OnetomanymappingApplication implements CommandLineRunner {

    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ItemRepository itemRepository;

    public static void main(String[] args) {
        SpringApplication.run(OnetomanymappingApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Cart cart = new Cart();

        Item item = new Item();
        item.setProductName("carrot");
        item.setQuantity(100);
        item.setProductRating(4.1);
        item.setProductPrice(50);
        item.setCategory("grocery");
        item.setCart(cart);


        Item item1 = new Item();
        item1.setProductName("notebook");
        item1.setQuantity(1);
        item1.setProductRating(3.9);
        item1.setProductPrice(25);
        item1.setCategory("stationary");
        item1.setCart(cart);

        cart.setItem(Arrays.asList(item, item1));

        cartRepository.save(cart);


    }
}
