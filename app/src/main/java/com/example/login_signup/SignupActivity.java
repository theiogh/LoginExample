package com.example.login_signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class SignupActivity extends AppCompatActivity {

    EditText et_Name,et_Password,et_Email;
    Button btn_Login,btn_Sign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        et_Name = findViewById(R.id.et_Name);
        et_Password = findViewById(R.id.et_Password);
        et_Email = findViewById(R.id.et_Email);

        // Sign up 버튼 클릭 시 회원가입 등록 수행.
        btn_Sign = findViewById(R.id.btn_Sign);
        btn_Sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // EditText에 현재 입력되어있는 값을 가져온다.
                String userID = et_Email.getText().toString();
                String userPassword = et_Password.getText().toString();
                String userName = et_Name.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            Log.e("userID",response);
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            if (success){
                                Toast.makeText(SignupActivity.this, "회원 등록에 성공했습니다.", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(SignupActivity.this , LoginActivity.class);
                                startActivity(intent);
                            }else {
                                Toast.makeText(SignupActivity.this, "회원 등록에 실패했습니다.", Toast.LENGTH_SHORT).show();
                                return;

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                // Volley를 이용해서 서버로 요청을 함.
                SignupRequest signupRequest = new SignupRequest(userID,userPassword,userName,responseListener);
                RequestQueue queue = Volley.newRequestQueue(SignupActivity.this);
                queue.add(signupRequest);

            }
        });

        // Login 버튼 클릭 시 로그인창으로 이동
        btn_Login = findViewById(R.id.btn_Login);
        btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignupActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });

    }
}