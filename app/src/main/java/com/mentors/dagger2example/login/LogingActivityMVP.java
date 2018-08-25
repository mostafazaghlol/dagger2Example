package com.mentors.dagger2example.login;

public interface LogingActivityMVP {
    interface Presenter{
        void setView(LogingActivityMVP.View view);

        void loginButtonClicked();

        void getCurrentUser();
    }
    interface View{
        String getFirstName();
        String getLastName();

        void showInputError();

        void setFirstName(String firstName);

        void setLastName(String lastName);

        void showUserSavedMessage();
    }
    interface Model{

        void createUser(String name, String lastName);

        User getUser();

    }


}

