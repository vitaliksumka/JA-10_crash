package service_implementation.impl;

import domain.User_domain;
import shared.AbstractCRUD;

import java.util.List;

public class UserServiceImpl implements AbstractCRUD<User_domain> {
    @Override
    public User_domain create(User_domain user_domain) {
        return null;
    }

    @Override
    public User_domain read(Integer id) {
        return null;
    }

    @Override
    public User_domain update(User_domain user_domain) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<User_domain> readAll() {
        return null;
    }
}
