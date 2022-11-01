package com.dooh.onetoonemapping.repository;

import com.dooh.onetoonemapping.entity.User1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//public interface UserRepository extends JpaRepository<User, Long>
public interface UserRepository extends JpaRepository<User1, Long> {
}
