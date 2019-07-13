package com.alaka.oceanapp.fragments;


import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.alaka.oceanapp.BLL.RegisterBLL;
import com.alaka.oceanapp.R;
import com.alaka.oceanapp.StrictMod.StrictMod;
import com.alaka.oceanapp.activities.DashboardActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment implements View.OnClickListener {
    private Button btnsignup;
    private EditText etname, etusername, etpassword, etemail;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_register, container, false);


        etusername = v.findViewById(R.id.etusername);
        etpassword = v.findViewById(R.id.etpassword);
        etname = v.findViewById(R.id.etname);
        etemail = v.findViewById(R.id.etemail);
        btnsignup = v.findViewById(R.id.btnsignup);

        btnsignup.setOnClickListener(this);

        return v;
    }


    public void onClick(View view) {

        if (!validate()) return;

        final RegisterBLL bll = new RegisterBLL(etusername.getText().toString(), etpassword.getText().toString(), etemail.getText().toString(), etname.getText().toString());
        StrictMod.StrictMode();

        if(bll.addUser()) {
            ((DashboardActivity)getActivity()).openFragment(new LoginFragment(), "Login");
        }
        else{
            Toast.makeText(getActivity(), "error, check credentials", Toast.LENGTH_SHORT).show();
        }


//        String username = etusername.getText().toString().trim();
//        String password = etpassword.getText().toString().trim();
//        String email = etemail.getText().toString().trim();
//        String name = etname.getText().toString().trim();
//
//        User user = new User(name,username,email,password);
//
//        Url.getEndPoints().signup(user).enqueue(new Callback<LoginResponse>() {
//            @Override
//            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
//                if (response.body().isSuccess()) {
//                    startActivity(new Intent(getActivity(), DashboardActivity.class));
//                } else {
//                    Toast.makeText(getActivity(), "login Failed", Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<LoginResponse> call, Throwable t) {
//
//            }
//        });
    }


    private boolean validate() {
        if (TextUtils.isEmpty(etusername.getText().toString())) {
            etusername.setError("Please enter username");
            etpassword.requestFocus();
            return false;
        } else if (TextUtils.isEmpty(etpassword.getText().toString())) {
            etpassword.setError("Please ");
            etpassword.requestFocus();
            return false;
        }
        return true;
    }
}




