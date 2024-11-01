package com.vichhaicoder.userservice_send_mail.repository;

import com.vichhaicoder.userservice_send_mail.modal.entity.Confirmation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConformationRepository extends JpaRepository<Confirmation,Long> {
    Confirmation findByToken(String token);


}
