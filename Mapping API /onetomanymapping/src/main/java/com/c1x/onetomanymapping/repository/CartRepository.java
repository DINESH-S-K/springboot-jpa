package com.c1x.onetomanymapping.repository;

import com.c1x.onetomanymapping.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Long> {
}
