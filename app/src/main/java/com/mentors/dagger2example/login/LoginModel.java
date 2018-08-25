package com.mentors.dagger2example.login;

public class LoginModel implements LogingActivityMVP.Model {


    private LogingRepository repository;

    public LoginModel(LogingRepository repository) {
        this.repository = repository;
    }

    @Override
    public void createUser(String name, String lastName) {
        repository.saveUser(new User(name, lastName));
    }

    @Override
    public User getUser() {
        return repository.getUser();
    }
}