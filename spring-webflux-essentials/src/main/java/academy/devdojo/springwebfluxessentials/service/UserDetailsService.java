package academy.devdojo.springwebfluxessentials.service;

import academy.devdojo.springwebfluxessentials.domain.User;
import academy.devdojo.springwebfluxessentials.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
@Slf4j
public class UserDetailsService implements ReactiveUserDetailsService {

    private final UserRepository userRepository;


    @Override
    public Mono<UserDetails> findByUsername(String username) {
        Mono<User> byUsername = userRepository.findByUsername(username);
        return byUsername
                .cast(UserDetails.class)
                .map(u -> u)
                ;
    }
}
