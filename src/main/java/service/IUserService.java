package service;

import Model.User;

import java.util.Optional;

public interface IUserService {
    User saveUser(User user);

    Optional<User> FindByUsername(String username);

    void makeAdmin(String username);
}
