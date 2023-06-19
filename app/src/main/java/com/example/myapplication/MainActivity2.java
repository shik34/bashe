package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    String n, m;
    int N, M, M2;
    TextView deskTop, whichTurn;
    EditText textM, editTextM;
    int pN=1;
    final String playerNumber1="Выиграл ПЕРВЫЙ игрок",playerNumber2="Выиграл ВТОРОЙ игрок";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        editTextM = (EditText) findViewById(R.id.textEditM);
        //получение данных из MainActivity
        Bundle arguments = getIntent().getExtras();
        n = arguments.getString("N");
        N=Integer.valueOf(n);
        m = arguments.getString("M");
        M =Integer.valueOf(m);
        deskTop = (TextView) findViewById(R.id.textDeskTop);
        whichTurn = (TextView) findViewById(R.id.whichTurn);
        whichTurn.setText("ХОД ПЕРВОГО ИГРОКА");
        N = Integer.parseInt(n);
        deskTop.setText(n);
    }

    public void onClick(View view) {
        m = editTextM.getText().toString();
        M2 = Integer.parseInt(m);
        if(M2 > N || M2>M){
            whichTurn.setText("ВЫ ДОЛЖНЫ ВЗЯТЬ МЕНЬШЕ ФИШЕК");
            return;
        }
        if (M2 ==N){
            whichTurn.setText("ВЫ ПОБЕДИЛИ !!!");
            return;
        }
        N-= M2;
        deskTop.setText(N+"");
        if(pN==1) {
            pN=2;
            whichTurn.setText("ХОД ВТОРОГО ИГРОКА");
        }
        else {
            pN=1;
            whichTurn.setText("ХОД ПЕРВОГО ИГРОКА");
        }
    }
}