package com.canela.prototipolsm;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class AprendeLasNotasActivity2 extends AppCompatActivity {

    Button buttonDo;
    Button buttonRe;
    Button buttonMi;
    Button buttonFa;

    Button buttonAyuda;
    Button buttonContinuar;
    Vibrator vibrator;
    VideoView videoView;

    MediaPlayer mediaPlayerC;
    MediaPlayer mediaPlayerD;
    MediaPlayer mediaPlayerE;
    MediaPlayer mediaPlayerF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aprende_las_notas2);
        getSupportActionBar().setTitle("Nivel 2");

        buttonDo = (Button) findViewById(R.id.button_nota_do);
        buttonRe = (Button) findViewById(R.id.button_nota_re);
        buttonMi = (Button) findViewById(R.id.button_nota_mi);
        buttonFa = (Button) findViewById(R.id.button_nota_fa);

        buttonAyuda = (Button) findViewById(R.id.button_ayuda_nivel_ejercicios);
        buttonContinuar = (Button) findViewById(R.id.button_continuar_aprende_notas);

        mediaPlayerC = MediaPlayer.create(this, R.raw.dosound);
        mediaPlayerD = MediaPlayer.create(this, R.raw.re);
        mediaPlayerE = MediaPlayer.create(this, R.raw.mi);
        mediaPlayerF = MediaPlayer.create(this, R.raw.fa);

        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);

        buttonDo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(100);
                mediaPlayerC.start();
            }
        });

        buttonRe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(200);
                mediaPlayerD.start();

            }
        });

        buttonMi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(300);
                mediaPlayerE.start();

            }
        });

        buttonFa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(400);
                mediaPlayerF.start();

            }
        });


        buttonAyuda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAprendeNotasAyuda();
            }
        });

        buttonContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNivelA();
            }
        });
    }

    public void openAprendeNotasAyuda(){
        final Dialog dialog = new Dialog(AprendeLasNotasActivity2.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_video);
        dialog.show();

        //Video
        videoView=(VideoView)dialog.findViewById(R.id.video_bienvenida);
        //videoView = findViewById(R.id.video_bienvenida);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);

        //Uri
        String videoPath="android.resource://" + getPackageName() + "/" + R.raw.estas_son_notas_musicales_toca_los_botones1;
        Uri uri = Uri.parse(videoPath);

        //Set media controller
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri);

        //Start video
        videoView.start();
    }

    public void openNivelA(){
        Intent intent = new Intent(this, NivelAActivity.class);
        startActivity(intent);

    }
}