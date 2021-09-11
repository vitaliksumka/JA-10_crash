package dao;

import domain.User_domain;
import shared.AbstractCRUD;

public interface UserDAO extends AbstractCRUD<User_domain> {
    User_domain getUserByEmail(String email);
}
