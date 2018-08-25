package com.mentors.dagger2example.root;

import com.mentors.dagger2example.login.LoginActivity;
import com.mentors.dagger2example.login.LoginModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class ,LoginModule.class})
public interface ApplicationComponent {
    void inject(LoginActivity target);
}
