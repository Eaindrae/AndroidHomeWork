package com.padcmyanmar.padc9.padc_9_helloandroid;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityHomework extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework);

        final TextView tvName = findViewById(R.id.tv_name);
        tvName.setText("Name");

        final EditText editName = findViewById(R.id.et_name);

        final TextView tvEmail = findViewById(R.id.tv_email);
        tvEmail.setText("Email");

        final EditText editEmail = findViewById(R.id.et_email);

        final TextView tvPhoneNo = findViewById(R.id.tv_phone_number);
        tvPhoneNo.setText("Phone Number");

        final EditText editPhoneNo = findViewById(R.id.et_phone_number);

        final TextView tvAddress = findViewById(R.id.tv_address);
        tvAddress.setText("Address");

        final EditText editAddress = findViewById(R.id.et_address);

        final TextView tvGender = findViewById(R.id.rgName);
        tvGender.setText("Gender");

        final RadioButton rdOne = findViewById(R.id.rdOne);
        rdOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ActivityHomework.this, "Male is Selected", Toast.LENGTH_SHORT).show();
            }
        });

        final RadioButton rdTwo = findViewById(R.id.rdTwo);
        rdTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ActivityHomework.this, "Male is Selected", Toast.LENGTH_SHORT).show();
            }
        });

        final CheckBox cbReading = findViewById(R.id.cb_reading);
        final CheckBox cbSwimming = findViewById(R.id.cb_swimming);
        final CheckBox cbWalking = findViewById(R.id.cb_walking);
        final CheckBox cbTravel = findViewById(R.id.cb_travelling);
        final Button btn_ok = findViewById(R.id.btn_ok);
        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pickData = editName.getText().toString();
                pickData += ", "+editEmail.getText().toString();
                pickData += ", "+editPhoneNo.getText().toString();
                pickData += ", "+editAddress.getText().toString();
                pickData += rdOne.isChecked() ? getString(R.string.lbl_rb_male) : " ";
                pickData += rdTwo.isChecked() ? getString(R.string.lbl_rb_female) : " ";
                pickData += cbReading.isChecked() ? getString(R.string.lbl_cb_reading) : " ";
                pickData += cbSwimming.isChecked() ? getString(R.string.lbl_cb_swimming) : " ";
                pickData += cbWalking.isChecked() ? getString(R.string.lbl_cb_walking) : " ";
                pickData += cbTravel.isChecked() ? getString(R.string.lbl_cb_travelling) : " ";

                final AlertDialog alertDialog = new AlertDialog.Builder(ActivityHomework.this).create();
                alertDialog.setTitle("Enter Data");
                alertDialog.setMessage("Enter Data :" + pickData);

                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        alertDialog.dismiss();
                    }
                });
                alertDialog.show();
            }
        });

    }
}
