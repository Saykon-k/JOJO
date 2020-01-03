package com.example.jojo;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button dio ,jojo,START;
    private MediaPlayer dioD,JoJo;
    private TextView JoJoUP,dioUP,fin,fin2;
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
  Kek();
    }
    public void Kek(){
        START=(Button)findViewById(R.id.Start);
        jojo=(Button)findViewById(R.id.JOJO);
        dio=(Button)findViewById(R.id.DIO);
        dioD=MediaPlayer.create(this,R.raw.hh);
        JoJo=MediaPlayer.create(this,R.raw.gg);
        JoJoUP=(TextView)findViewById(R.id.textView2);
        dioUP=(TextView)findViewById(R.id.textView);
        fin2=(TextView)findViewById(R.id.textView4);
        fin=(TextView)findViewById(R.id.textView3);
        final int[] jo = {0};
        final int[] di={0};
        final int[] dad={0};
        jojo.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        JoJoUP.setText("gd");
                    }
                }
        );
        START.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        new CountDownTimer(6000,1000){
                            @Override
                            public void onTick(long millisUntilFinished) {
                                fin.setText(""+1/1000);
                                    jojo.setOnClickListener(
                                            new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    v.setClickable(true);
                                                    jo[0]++;
                                                    SOUND(JoJo);
                                                    JoJoUP.setText(String.valueOf(jo[0]));
                                                }
                                            }
                                    );
                                    dio.setOnClickListener(
                                            new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    v.setClickable(true);
                                                    di[0]++;
                                                    SOUND(dioD);
                                                    dioUP.setText(String.valueOf(di[0]));
                                                }
                                            }
                                    );
                            }
                            @Override
                            public void onFinish() {
                                dioUP.setText("0");
                                JoJoUP.setText("0");
                                fin.setText("ВРЕМЯ ВЫШЛО!");
                                if(di[0]<jo[0]){
                                    fin2.setText("Yare Yare Dase");
                                }else{
                                    fin2.setText("WRYYY");
                                }
                                di[0]=0;
                                jo[0]=0;
                                jojo.setOnClickListener(
                                        new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        v.setClickable(false);
                                    }
                                });
                                dio.setOnClickListener(
                                        new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        v.setClickable(false);
                                    }
                                });
                            }
                        }.start();
                    }
                }

        );
    }
    public void SOUND(MediaPlayer rar){
        rar.start();
    }
}
