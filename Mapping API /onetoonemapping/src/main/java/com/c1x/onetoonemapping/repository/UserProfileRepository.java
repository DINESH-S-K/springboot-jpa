package com.c1x.onetoonemapping.repository;

import com.c1x.onetoonemapping.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//public interface UserProfileRepository extends JpaRepository<UserProfile, Long>
public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
}
