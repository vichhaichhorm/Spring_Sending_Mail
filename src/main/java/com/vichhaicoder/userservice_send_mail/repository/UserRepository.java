package com.vichhaicoder.userservice_send_mail.repository;

import com.vichhaicoder.userservice_send_mail.modal.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmailIgnoreCase(String email);
    Boolean existsByEmail(String email);
}
