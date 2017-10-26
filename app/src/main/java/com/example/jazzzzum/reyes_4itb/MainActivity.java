package com.example.jazzzzum.reyes_4itb;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etMessage;
    Button btnSave, btnDisplay;
    TextView tvDisplay;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etMessage = (EditText) findViewById(R.id.et_message);
        btnSave = (Button) findViewById(R.id.btn_save);
        btnDisplay = (Button) findViewById(R.id.btn_display);
        tvDisplay = (TextView) findViewById(R.id.tv_display);
        preferences = getPreferences(Context.MODE_PRIVATE);
    }
    public void saveInfo(View view){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("message", etMessage.getText().toString());
        editor.commit();
        Toast.makeText(this, "Data Saved", Toast.LENGTH_SHORT).show();

    }
    public void loadInfo(View view) {
        String message = preferences.getString("message", "");
        tvDisplay.setText("The message is " + message);
    }
}
