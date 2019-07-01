package com.rob.quiz.service.user;

import com.rob.quiz.model.MongoUser;
import com.rob.quiz.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Collections.singletonList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        MongoUser user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("MongoUser not found");
        }
        List<SimpleGrantedAuthority> authorities = singletonList(new SimpleGrantedAuthority("user"));
        return new User(user.getUsername(), user.getPassword(), authorities);
    }

}
