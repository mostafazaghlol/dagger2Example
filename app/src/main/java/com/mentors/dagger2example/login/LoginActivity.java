package com.mentors.dagger2example.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mentors.dagger2example.R;
import com.mentors.dagger2example.root.App;

import javax.inject.Inject;

public class LoginActivity extends AppCompatActivity implements LogingActivityMVP.View{
    @Inject
    LogingActivityMVP.Presenter presenter;

    private EditText firstName;
    private EditText lastName;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((App)getApplication()).getComponent().inject(this);
        firstName = (EditText) findViewById(R.id.loginActivity_firstName_editText);
        lastName = (EditText) findViewById(R.id.loginActivity_lastName_editText);
        login = (Button) findViewById(R.id.loginActivity_login_button);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.loginButtonClicked();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.setView(this);
        presenter.getCurrentUser();
    }


    @Override
    public String getFirstName() {
        return firstName.getText().toString();
    }

    @Override
    public String getLastName() {
        return lastName.getText().toString();
    }

    @Override
    public void showInputError() {
        Toast.makeText(this, "First Name or last name cannot be empty", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName.setText(firstName);
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName.setText(lastName);
    }

    @Override
    public void showUserSavedMessage() {
        Toast.makeText(this, "User saved successfully", Toast.LENGTH_SHORT).show();

    }
}