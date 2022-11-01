package com.c1x.onetomanymapping.repository;

import com.c1x.onetomanymapping.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Long> {
}
