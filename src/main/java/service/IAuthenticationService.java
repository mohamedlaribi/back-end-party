package service;

import Model.User;

public interface IAuthenticationService {
    User signInAndReturnJWT(User signInRequest);
}
