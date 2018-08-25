package com.mentors.dagger2example.login;

public interface LogingRepository {
    User getUser();

    void saveUser(User user);
}
