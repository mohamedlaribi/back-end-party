package service;

import Model.Role;
import Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import repository.IUserRepository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserSerivce implements  IUserService {

    @Autowired
    private  IUserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User saveUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.USER);
        user.setCreateTime(LocalDateTime.now());

        return userRepository.save(user);
    }
    @Override
    public Optional<User> FindByUsername(String username)
    {
        return userRepository.findByUsername(username);
    }
    @Override
    @Transactional
    public void makeAdmin(String username)
    {
        userRepository.updateUserRole(username,Role.ADMIN );
    }
}
