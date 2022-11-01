package com.dooh.onetoonemapping.repository;

import com.dooh.onetoonemapping.entity.UserProfile1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//public interface UserProfileRepository extends JpaRepository<UserProfile, Long>
public interface UserProfileRepository extends JpaRepository<UserProfile1, Long>{
}
