package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText n,m;
    TextView textErr;
    String N,M;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        n=(EditText)findViewById(R.id.textN);
        m=(EditText)findViewById(R.id.textM);
        textErr=(TextView)findViewById(R.id.textErr);
    }

    public void onClick(View view) {
        String N1=n.getHint().toString();
        String M1=m.getHint().toString();
        String N2=n.getText().toString();
        String M2=m.getText().toString();
        if(N2.equals("")) N=N1;
            else N=N2;
        if(M2.equals("")) M=M1;
            else M=M2;
        if(Integer.valueOf(M)>Integer.valueOf(N)) {
            textErr.setText("Второе число должно быть не больше первого");
            return;
        }
        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("N", N);
        intent.putExtra("M", M);
        startActivity(intent);
    }
}