package com.example.testing.home;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.testing.R;

public class MainActivity extends AppCompatActivity implements MyView {

    private Context context;// UI change ekk kraddi eka apply wenna one moketada kyala yawanna one
    private Activity activity; //  api me inna activity eka
    private MainPresenter mainPresenter;
    private TextView textView;
    private Button button;
    private EditText editText1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        context = this;
//        activity = this;
        textView = findViewById(R.id.textView1);
        button = findViewById(R.id.startButton);
        editText1 =findViewById(R.id.editText1);

        mainPresenter = new MainPresenter(this, textView);// auto casting to

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainPresenter.startSpalsh();
            }
        });

        findViewById(R.id.buttonNextIntent).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent secondIntent=new Intent(MainActivity.this,SecondActivity.class);
                secondIntent.putExtra("editText1", editText1.getText().toString());
                startActivity(secondIntent);
            }
        });

    }

    @Override
    public void showToast(final String toast) {
       runOnUiThread(new Runnable() {
           @Override
           public void run() {
               textView.setText(toast);
           }
       });
    }
}
