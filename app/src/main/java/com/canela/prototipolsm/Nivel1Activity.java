package com.canela.prototipolsm;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

public class Nivel1Activity extends AppCompatActivity {

    VideoView videoView;

    Button buttonAyudaNivel1;

    Button buttonNotaSecreta;

    Button buttonOpcionDo;
    Button buttonOpcionRe;
    Button buttonOpcionMi;

    MediaPlayer mediaPlayerC;

    Vibrator vibrator;

    ImageView imageSapo;
    AnimationDrawable sapoSaltando;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nivel1);
        getSupportActionBar().setTitle("Nivel 1");

        buttonAyudaNivel1 = (Button) findViewById(R.id.button_ayuda_instrucciones);
        buttonNotaSecreta = (Button) findViewById(R.id.button_nivel1_secreto);

        buttonOpcionDo = (Button) findViewById(R.id.button_opcion_do);
        buttonOpcionDo.setEnabled(false);

        buttonOpcionRe = (Button) findViewById(R.id.button_opcion_re);
        buttonOpcionRe.setEnabled(false);

        buttonOpcionMi = (Button) findViewById(R.id.button_opcion_mi);
        buttonOpcionMi.setEnabled(false);

        mediaPlayerC = MediaPlayer.create(this, R.raw.dosound);

        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);

        /*
        Nota secreta
         */
        buttonNotaSecreta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(100);
                mediaPlayerC.start();
                buttonOpcionDo.setEnabled(true);
                buttonOpcionRe.setEnabled(true);
                buttonOpcionMi.setEnabled(true);

            }
        });

        buttonOpcionDo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNivel2Activity();
            }
        });

        buttonOpcionRe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialogIncorrecto();
            }
        });

        buttonOpcionMi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialogIncorrecto();
            }
        });

        buttonAyudaNivel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openInstrucciones();
            }
        });



        final Dialog dialog = new Dialog(Nivel1Activity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_video);
        dialog.show();

        //Video
        videoView=(VideoView)dialog.findViewById(R.id.video_bienvenida);
        //videoView = findViewById(R.id.video_bienvenida);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);

        //Uri
        String videoPath="android.resource://" + getPackageName() + "/" + R.raw.toca_el_boton_gris_y_siente_la_vibracion1;
        Uri uri = Uri.parse(videoPath);

        //Set media controller
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri);

        //Start video
        videoView.start();

        imageSapo = (ImageView) findViewById(R.id.img_sapo);
        imageSapo.setImageResource(R.drawable.sapo_saltando);
        sapoSaltando = (AnimationDrawable) imageSapo.getDrawable();
        sapoSaltando.start();



    }

    public void openNivel2Activity(){
        Intent intent = new Intent(this, Nivel2Activity.class);
        startActivity(intent);
    }

    public void openInstrucciones(){
        final Dialog dialog = new Dialog(Nivel1Activity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_video);
        dialog.show();

        //Video
        videoView=(VideoView)dialog.findViewById(R.id.video_bienvenida);
        //videoView = findViewById(R.id.video_bienvenida);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);

        //Uri
        String videoPath="android.resource://" + getPackageName() + "/" + R.raw.toca_el_boton_gris_y_siente_la_vibracion1;
        Uri uri = Uri.parse(videoPath);

        //Set media controller
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri);

        //Start video
        videoView.start();
    }



    public void openDialogIncorrecto(){
        final Dialog dialog = new Dialog(Nivel1Activity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_design_incorrecto);
        dialog.setCancelable(false);
        dialog.show();

        Button buttonDialog = dialog.findViewById(R.id.btn_dialog_continuar);

        buttonDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });
    }


}