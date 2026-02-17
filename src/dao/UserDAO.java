package dao;

import Models.User;

public interface UserDAO {

        User findByUsername(String username);

}
