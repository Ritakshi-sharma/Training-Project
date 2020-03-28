package com.example.nanny_project.NANI;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import in.aabhasjindal.otptextview.OTPListener;
import in.aabhasjindal.otptextview.OtpTextView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nanny_project.R;

public class Verification extends AppCompatActivity  {
TextView textView;
OtpTextView otpTextView;
Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);



        textView=findViewById(R.id.phone_no);

        String text = "A Verification code has been sent to the phone number +91 9779102183 " +
                "Please enter the code below.";

        SpannableString ss = new SpannableString(text);

        ForegroundColorSpan fcsOrange=new ForegroundColorSpan(Color.RED);
        ForegroundColorSpan fcs2Orange=new ForegroundColorSpan(Color.RED);

        ss.setSpan(fcs2Orange,54,57, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(fcsOrange,58,68, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(ss);


        otpTextView = findViewById(R.id.otp_view);
        otpTextView.setOtpListener(new OTPListener() {
            @Override
            public void onInteractionListener() {

            }

            @Override
            public void onOTPComplete(String otp) {
                String otpback="1234";
                if(otpback.equals(otp)){
                    Toast.makeText(Verification.this, "otp match", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(Verification.this, "otp mismatch", Toast.LENGTH_SHORT).show();
                }

            }
        });

button=findViewById(R.id.verify);
button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(Verification.this);
        ViewGroup viewGroup = findViewById(android.R.id.content);
        View dialogView = LayoutInflater.from(v.getContext()).inflate(R.layout.activity_dialog_box, viewGroup, false);
        Button buttonnext = dialogView.findViewById(R.id.buttonOk);
        buttonnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Verification.this, "Clicked!", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(Verification.this, NaniHomePage.class);
                startActivity(intent);
            }
        });

        builder.setView(dialogView);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
    });

    }

}
