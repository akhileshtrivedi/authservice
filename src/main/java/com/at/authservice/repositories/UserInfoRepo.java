package com.at.authservice.repositories;

import com.at.authservice.models.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserInfoRepo extends JpaRepository<UserInfo, Integer> {
  Optional<UserInfo> findByName(String username);
}
