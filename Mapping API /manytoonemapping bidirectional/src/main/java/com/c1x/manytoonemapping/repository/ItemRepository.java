package com.c1x.manytoonemapping.repository;

import com.c1x.manytoonemapping.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Long> {
}
