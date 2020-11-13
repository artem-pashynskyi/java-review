package oop.abstraction.service;

import enums.Gender;
import oop.abstraction.implementation.UserServiceImplementation;
import oop.encapsulation.Role;
import oop.encapsulation.User;

public class UserService implements UserServiceImplementation {

    @Override
    public String userByRoleId(int id) {
        User user = new User("Mike", "Smith", new Role(id, "Admin"), Gender.MALE);
        return user.getFirstName() + " " + user.getLastName();
    }

    @Override
    public User userByFirstName(String firstName) {
        User user = new User(firstName, "Ally", new Role(5, "Employee"), Gender.MALE);
        return user;
    }
}
