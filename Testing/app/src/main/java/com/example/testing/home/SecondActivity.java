package com.example.testing.home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.testing.R;

public class SecondActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textView=findViewById(R.id.textValue);

        Bundle extra=getIntent().getExtras();
        if (extra!=null){
            textView.setText(extra.getString("editText1"));
        }
    }
}
