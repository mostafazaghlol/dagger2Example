package com.mentors.dagger2example.login;

import dagger.Module;
import dagger.Provides;

@Module
public class LoginModule {
    @Provides
    public LogingActivityMVP.Presenter provideLoginActivityPresenter(LogingActivityMVP.Model model){
        return new LoginActivityPresenter(model);
    }

    @Provides
    public LogingActivityMVP.Model provideLoginActivityModel(LogingRepository repository){
        return new LoginModel(repository);
    }

    @Provides
    public LogingRepository provideLoginRepository(){
        return new MemoryRepository();
    }
}