package service_implementation;

import domain.User_domain;

import shared.AbstractCRUD;

public interface UserService extends AbstractCRUD<User_domain> {
    User_domain getUserByEmail(String email);
}
