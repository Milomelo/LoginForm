package site.metacoding.login.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.login.domain.User;
import site.metacoding.login.domain.UserRepository;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public void 회원가입(User user) {
        userRepository.save(user);

    }
}
