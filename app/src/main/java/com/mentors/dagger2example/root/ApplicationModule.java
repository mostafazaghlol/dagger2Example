package com.mentors.dagger2example.root;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {
    private Application application;
    public ApplicationModule(Application mApplication){
        this.application = mApplication;
    }
    @Provides
    @Singleton
    public Context provideContext(){
        return application;
    }
}
