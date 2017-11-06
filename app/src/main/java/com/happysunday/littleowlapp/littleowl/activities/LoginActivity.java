package com.happysunday.littleowlapp.littleowl.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.happysunday.littleowlapp.littleowl.R;
import com.happysunday.littleowlapp.littleowl.models.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    private int cekvalid(User u)
    {
        if(u.getNamalengkap()!=null)
        {
            return 1;
        }

        else
            return 0;
    }

    public void getDetailUser(String username, String password){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest endpoint = new StringRequest(Request.Method.GET, "http://little-owl-app.000webhostapp.com/index.php/user/usernamepass?username="+username+"&password="+password,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray result = new JSONArray(response);
                            JSONObject user = result.getJSONObject(0);
                            User datauser = new User();

                            datauser.setUsername(user.getString("USERNAME"));
                            datauser.setEmail(user.getString("EMAIL"));
                            datauser.setNamalengkap(user.getString("NAMALENGKAP"));
//                            datauser.setTgllahir(new Date(user.getString("TGLLAHIR")));
                            datauser.setFotoProfile(user.getString("FOTOPROFILE"));
                            datauser.setPassword(user.getString("password"));

                            if(cekvalid(datauser)==1)
                            {
                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                startActivity(intent);
                            }

                            else
                            {
                                //pop up login fail
                            }


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_LONG).show();
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return super.getParams();
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return super.getHeaders();
            }
        };
        requestQueue.add(endpoint);
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText username = (EditText)findViewById(R.id.username);
        final EditText password = (EditText)findViewById(R.id.password);
        Button btnLogin = (Button)findViewById(R.id.buttonLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDetailUser(username.getText().toString(),password.getText().toString());
                finish();
            }
        });


    }
}
