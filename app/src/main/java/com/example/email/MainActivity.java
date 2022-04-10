package com.example.email;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
private Button btn_Go;
private EditText address;
private EditText text;
private EditText message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_Go= findViewById(R.id.btn_go);
        address= findViewById(R.id.email);
        text=findViewById(R.id.tittle);
        message=findViewById(R.id.message);
        btn_Go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto",address.getText().toString(), null));
                intent.putExtra(Intent.EXTRA_EMAIL, address.getText().toString());
                intent.putExtra(Intent.EXTRA_SUBJECT, text.getText().toString());
                intent.putExtra(Intent.EXTRA_TEXT, message.getText().toString());
                startActivity(Intent.createChooser(intent, "send"));
            }
        });
    }
}