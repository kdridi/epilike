package org.androidannotations.sample;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.epilike.client.commons.LoginManager;

import android.app.Activity;
import android.widget.EditText;
import android.widget.Toast;

@EActivity(R.layout.login_activity)
public class LoginActivity extends Activity {
	LoginManager loginManager = new LoginManager();

	@ViewById
	EditText loginEditText;

	@ViewById
	EditText passwordEditText;

	@Click
	void loginButton() {
		String pass = passwordEditText.getText().toString();
		String user = loginEditText.getText().toString();
		boolean login = loginManager.login(user, pass);

		Toast.makeText(this, login ? "SUCCESS" : "FAILURE", Toast.LENGTH_LONG).show();
	}
}
