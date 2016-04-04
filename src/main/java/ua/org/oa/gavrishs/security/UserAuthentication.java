package ua.org.oa.gavrishs.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ua.org.oa.gavrishs.model.User;
import ua.org.oa.gavrishs.services.UserService;

import java.util.Arrays;

/**
 * Created by Anna on 03.04.2016.
 */
public class UserAuthentication implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

        User user = userService.getByLogin(login);
        if (user == null) {
            throw new UsernameNotFoundException("user not found");
        }
        GrantedAuthority authority = new SimpleGrantedAuthority( user.getRole().toString());
        UserDetails userDetails = (UserDetails) new org.springframework.security.core.userdetails.User(login,
                user.getPassword(), Arrays.asList(authority));
        return userDetails;
    }
}
