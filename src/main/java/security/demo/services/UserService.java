package security.demo.services;

import security.demo.entities.Role;
import security.demo.entities.User;
import security.demo.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframeworksecurity.core.GrantedAuthority;
import org.springframeworksecurity.core.authority.SimpleGrantedAuthority;
import org.springframeworksecurity.core.userdetails.UserDetails;
import org.springframeworksecurity.core.userdetails.UserDetailsService;
import org.springframeworksecurity.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import security.demo.entities.Role;
import security.demo.entities.User;
import security.demo.repositories.UserRepository;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;


    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(String.format("User '%s' not found", username)));

        return new org.springframeworksecurity.core.userdetails.User(user.getUsername(),user.getPassword(),mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role->new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }
}
