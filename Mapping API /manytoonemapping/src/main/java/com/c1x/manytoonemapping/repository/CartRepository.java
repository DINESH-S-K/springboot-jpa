package com.c1x.manytoonemapping.repository;

import com.c1x.manytoonemapping.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Long> {
}
