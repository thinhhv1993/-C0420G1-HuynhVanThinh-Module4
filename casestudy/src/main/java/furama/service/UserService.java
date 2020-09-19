package furama.service;

import furama.model.User;

public interface UserService  {
    User findByUsername(String username);
    void save(User user);
}
