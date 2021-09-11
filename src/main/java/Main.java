import domain.User_domain;
import service_implementation.UserService;
import service_implementation.impl.UserServiceImpl;

import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        userService.create(new User_domain("test@test2","test","test","test","gfd"));




    }
}
