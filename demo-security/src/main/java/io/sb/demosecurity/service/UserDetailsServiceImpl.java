package io.sb.demosecurity.service;

import io.sb.demosecurity.entity.User;
import io.sb.demosecurity.model.UserPrincipal;
import io.sb.demosecurity.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserPrincipal loadUserByUsername(String id) throws UsernameNotFoundException {
        User user = userRepo
                .findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("User name " + id + " does not exist"));
        return UserPrincipal.create(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }
}
