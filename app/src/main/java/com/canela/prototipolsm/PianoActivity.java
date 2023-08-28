package com.canela.prototipolsm;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class PianoActivity extends AppCompatActivity {

    Button buttonDo;
    Button buttonRe;
    Button buttonMi;
    Button buttonFa;
    Button buttonSol;
    Button buttonLa;
    Button buttonSi;
    Button buttonAyuda;
    TextView textViewNota;
    TextView textViewSimbolo;
    Vibrator vibrator;
    VideoView videoView;
    MediaPlayer mediaPlayerC;
    MediaPlayer mediaPlayerD;
    MediaPlayer mediaPlayerE;
    MediaPlayer mediaPlayerF;
    MediaPlayer mediaPlayerG;
    MediaPlayer mediaPlayerA;
    MediaPlayer mediaPlayerB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piano);
        getSupportActionBar().setTitle("Piano");

        buttonDo = (Button) findViewById(R.id.button_do);
        buttonRe = (Button) findViewById(R.id.button_re);
        buttonMi = (Button) findViewById(R.id.button_mi);
        buttonFa = (Button) findViewById(R.id.button_fa);
        buttonSol = (Button) findViewById(R.id.button_sol);
        buttonLa = (Button) findViewById(R.id.button_la);
        buttonSi = (Button) findViewById(R.id.button_si);
        buttonAyuda = (Button) findViewById(R.id.button_ayuda);

        mediaPlayerC = MediaPlayer.create(this, R.raw.dosound);
        mediaPlayerD = MediaPlayer.create(this, R.raw.re);
        mediaPlayerE = MediaPlayer.create(this, R.raw.mi);
        mediaPlayerF = MediaPlayer.create(this, R.raw.fa);
        mediaPlayerG = MediaPlayer.create(this, R.raw.sol);
        mediaPlayerA = MediaPlayer.create(this, R.raw.la);
        mediaPlayerB = MediaPlayer.create(this, R.raw.si);

        textViewNota = (TextView) findViewById(R.id.textview_nota);
        textViewSimbolo = (TextView) findViewById(R.id.textview_simbolo);

        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);

        buttonDo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(100);
                textViewNota.setTextColor(Color.rgb(178, 18, 100));
                textViewSimbolo.setTextColor(Color.rgb(178, 18, 100));
                textViewNota.setText("DO");
                mediaPlayerC.start();
            }
        });

        buttonRe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(200);
                textViewNota.setTextColor(Color.rgb(216, 27, 43));
                textViewSimbolo.setTextColor(Color.rgb(216, 27, 43));
                textViewNota.setText("RE");
                mediaPlayerD.start();
            }
        });

        buttonMi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(300);
                textViewNota.setTextColor(Color.rgb(255, 87, 34));
                textViewSimbolo.setTextColor(Color.rgb(255, 87, 34));
                textViewNota.setText("MI");
                mediaPlayerE.start();
            }
        });

        buttonFa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(400);
                textViewNota.setTextColor(Color.rgb(255, 193, 7));
                textViewSimbolo.setTextColor(Color.rgb(255, 193, 7));
                textViewNota.setText("FA");
                mediaPlayerF.start();
            }
        });

        buttonSol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(500);
                textViewNota.setTextColor(Color.rgb(76, 175, 80));
                textViewSimbolo.setTextColor(Color.rgb(76, 175, 80));
                textViewNota.setText("SOL");
                mediaPlayerG.start();
            }
        });

        buttonLa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(600);
                textViewNota.setTextColor(Color.rgb(33, 150, 243));
                textViewSimbolo.setTextColor(Color.rgb(33, 150, 243));
                textViewNota.setText("LA");
                mediaPlayerA.start();
            }
        });

        buttonSi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(700);
                textViewNota.setTextColor(Color.rgb(9, 66, 147));
                textViewSimbolo.setTextColor(Color.rgb(9, 66, 147));
                textViewNota.setText("SI");
                mediaPlayerB.start();
            }
        });

        buttonAyuda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPianoAyuda();
            }
        });


    }

    public void openPianoAyuda(){
        final Dialog dialog = new Dialog(PianoActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_video);
        dialog.show();

        //Video
        videoView=(VideoView)dialog.findViewById(R.id.video_bienvenida);
        //videoView = findViewById(R.id.video_bienvenida);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);

        //Uri
        String videoPath="android.resource://" + getPackageName() + "/" + R.raw.piano_ayuda;
        Uri uri = Uri.parse(videoPath);

        //Set media controller
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri);

        //Start video
        videoView.start();
    }
}