package com.vichhaicoder.userservice_send_mail.service.serviceimp;

import com.vichhaicoder.userservice_send_mail.modal.entity.Confirmation;
import com.vichhaicoder.userservice_send_mail.modal.entity.User;
import com.vichhaicoder.userservice_send_mail.modal.exception.EmailAlreadyExistsException;
import com.vichhaicoder.userservice_send_mail.repository.ConformationRepository;
import com.vichhaicoder.userservice_send_mail.repository.UserRepository;
import com.vichhaicoder.userservice_send_mail.service.EmailService;
import com.vichhaicoder.userservice_send_mail.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {
    private final UserRepository userRepository;
    private final ConformationRepository conformationRepository;
    private final EmailService emailService;
    @Override
    public User saveUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())){
            throw new EmailAlreadyExistsException("Email already exits .");
        }
        user.setEnable(false);
        userRepository.save(user);

        Confirmation confirmation = new Confirmation(user);
        conformationRepository.save(confirmation);

        // TODO Send mail to user with token
        emailService.sendSimpleMailMessage( user.getName(), user.getEmail(), confirmation.getToken());

        return user;
    }

    @Override
    public Boolean verifyToken(String token) {
        Confirmation confirmation = conformationRepository.findByToken(token);
        User user = userRepository.findByEmailIgnoreCase(confirmation.getUser().getEmail());
        user.setEnable(true);
        userRepository.save(user);
        // confirmationRepository.delete(confirmation);
        return Boolean.TRUE;
    }
}
