package com.quickblox.q_municate.ui.activities.authorization;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;



import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.quickblox.auth.model.QBProvider;
import com.quickblox.auth.session.QBSessionManager;
import com.quickblox.q_municate.App;
import com.quickblox.q_municate.R;
import com.quickblox.q_municate.ui.activities.main.MTIhome;
import com.quickblox.q_municate.ui.activities.main.MainActivity;
import com.quickblox.q_municate.utils.helpers.ServiceManager;
import com.quickblox.q_municate_core.models.AppSession;
import com.quickblox.q_municate_core.service.QBServiceConsts;
import com.quickblox.q_municate_core.utils.helpers.CoreSharedHelper;

import java.util.Timer;
import java.util.TimerTask;

import rx.Subscriber;



import com.quickblox.auth.session.QBSessionManager;
import com.quickblox.q_municate.R;
import com.quickblox.q_municate.ui.activities.forgotpassword.ForgotPasswordActivity;
import com.quickblox.q_municate.ui.activities.main.MTIhome;
import com.quickblox.q_municate.ui.activities.main.MainActivity;
import com.quickblox.q_municate.utils.KeyboardUtils;
import com.quickblox.q_municate.utils.ValidationUtils;
import com.quickblox.q_municate_core.models.AppSession;
import com.quickblox.q_municate_core.models.LoginType;
import com.quickblox.q_municate_db.managers.DataManager;
import com.quickblox.q_municate_user_service.model.QMUser;

import butterknife.Bind;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;

public class LoginActivity extends BaseAuthActivity {

    @Bind(R.id.remember_me_switch)
    SwitchCompat rememberMeSwitch;

    public static void start(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected int getContentResId() {
        return R.layout.activity_login;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initFields(savedInstanceState);
        setUpActionBarWithUpButton();

        Button registerbutton = (Button) findViewById(R.id.signup);
        registerbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(i);
            }
        });

    }

    @OnClick(R.id.login_email_button)
    void loginQB(View view) {
        if (checkNetworkAvailableWithError()) {
            login();
        }
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                startLandingScreen();
                break;
            default:
                super.onOptionsItemSelected(item);
        }
        return true;
    }

    //@Override
    //public void onBackPressed() {
    //    startLandingScreen();
   // }


    @OnCheckedChanged(R.id.remember_me_switch)
    void rememberMeCheckedChanged(boolean checked) {
        appSharedHelper.saveSavedRememberMe(checked);
    }

    @OnClick(R.id.forgot_password_textview)
    void forgotPassword(View view) {
        ForgotPasswordActivity.start(this);
    }

    private void initFields(Bundle bundle) {
        title = getString(R.string.auth_login_title);
        rememberMeSwitch.setChecked(true);
    }

    private void login() {
        KeyboardUtils.hideKeyboard(this);

        loginType = LoginType.EMAIL;

        String userEmail = emailEditText.getText().toString();
        String userPassword = passwordEditText.getText().toString();

        if (new ValidationUtils(this).isLoginDataValid(emailTextInputLayout, passwordTextInputLayout,
                userEmail, userPassword)) {

            showProgress();
            boolean ownerUser =   QBSessionManager.getInstance().getSessionParameters() != null && userEmail.equals(QBSessionManager.getInstance().getSessionParameters().getUserEmail());
            if (!ownerUser) {
                DataManager.getInstance().clearAllTables();
            }

            login(userEmail, userPassword);
        }
    }
}