package com.c1x.onetoonemapping.repository;

import com.c1x.onetoonemapping.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//public interface UserRepository extends JpaRepository<User, Long>
public interface UserRepository extends JpaRepository<User, Long> {
}
