package site.metacoding.login.config.auth;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.login.domain.User;
import site.metacoding.login.domain.UserRepository;

@RequiredArgsConstructor
@Service
public class LoginService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOp = userRepository.findByUsername(username);
        if (userOp.isPresent()) {
            return new LoginUser(userOp.get());
        }

        return null;
    }

}
