package com.mentors.dagger2example.login;

import android.support.annotation.Nullable;

public class LoginActivityPresenter  implements LogingActivityMVP.Presenter {
    @Nullable
    private LogingActivityMVP.View view;
    private LogingActivityMVP.Model model;

    public LoginActivityPresenter(LogingActivityMVP.Model model) {
        this.model = model;
    }

    @Override
    public void setView(LogingActivityMVP.View view) {

        this.view = view;

    }

    @Override
    public void loginButtonClicked() {

        if (view != null) {
            if (view.getFirstName().trim().equals("") || view.getLastName().trim().equals("")) {
                view.showInputError();
            } else {

                model.createUser(view.getFirstName(), view.getLastName());
                view.showUserSavedMessage();

            }

        }

    }

    @Override
    public void getCurrentUser() {

        User user = model.getUser();

        if (user != null) {
            if (view != null) {
                view.setFirstName(user.getFirstName());
                view.setLastName(user.getLastName());
            }
        }

    }
}

