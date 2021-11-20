package security;

import Model.User;
import Util.SecurityUtils;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import service.IUserService;

import java.util.Set;

@Data
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private IUserService userService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user= userService.FindByUsername(username).
                orElseThrow(()->new UsernameNotFoundException(username));

        Set<GrantedAuthority>authorities= Set.of(SecurityUtils.convertToAuthority((user.getRole().name())));

        return UserPrincipal.builder()
                .user(user).id(user.getId())
                .username(username)
                .password(user.getPassword())
                .authorities(authorities)
                .build();
    }
}
