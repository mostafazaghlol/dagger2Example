package com.mentors.dagger2example.login;

public interface LoginRepository {

    User getUser();

    void saveUser(User user);
}