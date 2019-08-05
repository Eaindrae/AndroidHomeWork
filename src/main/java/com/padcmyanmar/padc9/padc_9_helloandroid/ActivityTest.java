package com.padcmyanmar.padc9.padc_9_helloandroid;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.ParcelUuid;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import java.util.Random;

public class ActivityTest extends AppCompatActivity {

private static final String IE_TEXT_TO_DISPLAY = "IE_TEXT_TO_DISPLAY";



    public static Intent newIntent(Context  context,String  TextToDisplay) {
        Intent intent= new Intent(context,ActivityTest.class);
        intent.putExtra(IE_TEXT_TO_DISPLAY, TextToDisplay);
        return intent;
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        final TextView tvGreeting = findViewById(R.id.tv_greeting);
        tvGreeting.setText("Good Afternoon");

        final ImageView ivGreeting = findViewById(R.id.imageView);
        ivGreeting.setImageResource(R.drawable.image);

        final Button btnChineseGreetings = findViewById(R.id.btn_chinese_greeting);
        btnChineseGreetings.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                ivGreeting.setImageResource(R.drawable.greetings_06);
               // btnChineseGreetings.setOnClickListener(R.drawable.greetings_06);
            }
        });

        final int[] greetingImages = {R.drawable.greetings_03,R.drawable.greetings_04,R.drawable.greetings_05};
        Button btnRandomGreetings = findViewById(R.id.btn_mytest);
        btnRandomGreetings.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Random randomSeed = new Random();
                int randomIndex = randomSeed.nextInt(greetingImages.length);
                ivGreeting.setImageResource(greetingImages[randomIndex]);
            }
        });

        ImageButton btnSayHi = findViewById(R.id.btn_say_hi);
        final EditText etSayHi = findViewById(R.id.et_my_greetings);
        btnSayHi.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                final Snackbar sb = Snackbar.make(view, "Say Hi :"+etSayHi.getText(), Snackbar.LENGTH_INDEFINITE);
                sb.setAction("Dismiss", new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        sb.dismiss();
                    }
                });
                sb.show();
            }
        });

        final CheckBox cbBanana = findViewById(R.id.cb_banana);
        final CheckBox cbApple = findViewById(R.id.cb_apple);
        final CheckBox cbOrange = findViewById(R.id.cb_orange);
        TextView btnCheckFruit = findViewById(R.id.btn_check_fruits);
        btnCheckFruit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pickedFruits = cbBanana.isChecked() ? getString(R.string.fruit_banana) : "";
                pickedFruits += cbApple.isChecked()? ", "+"Apple" : "";
                pickedFruits += cbOrange.isChecked() ? ", "+"Orange ": "";
                AlertDialog alertDialog= new AlertDialog.Builder(ActivityTest.this).create();
                alertDialog.setTitle("Picked Fruits");
                alertDialog.setMessage(getString(R.string.format_msg_picked_fruits));
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int which){
                        dialog.dismiss();
                    }
                });
                alertDialog.show();
            }
        });

        RadioButton rbGentLeman = findViewById(R.id.rdOne);
        RadioButton rbWonmen = findViewById(R.id.rdTwo);
        rbGentLeman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ActivityTest.this, "Male is selected", Toast.LENGTH_LONG).show();
            }
        });
        rbWonmen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ActivityTest.this, "Female is selected", Toast.LENGTH_LONG).show();
            }
        });

        String textToDisplay = getIntent().getStringExtra(IE_TEXT_TO_DISPLAY);

        TextView tvTextToDisplay = findViewById(R.id.tv_text_to_display);
        tvTextToDisplay.setext(textToDisplay);

    }





}
