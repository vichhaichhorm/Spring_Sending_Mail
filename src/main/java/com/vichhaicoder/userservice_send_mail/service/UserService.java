package com.vichhaicoder.userservice_send_mail.service;

import com.vichhaicoder.userservice_send_mail.modal.entity.User;

public interface UserService {
    User saveUser(User user);
    Boolean verifyToken(String token);
}
