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

public class Nivel4Activity extends AppCompatActivity {

    VideoView videoView;

    Button buttonAyudaNivel4;

    Button buttonNotaSecreta;

    Button buttonOpcionDo;
    Button buttonOpcionRe;
    Button buttonOpcionMi;


    MediaPlayer mediaPlayerE;

    Vibrator vibrator;

    ImageView imageSapo;
    AnimationDrawable sapoSaltando;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nivel4);
        getSupportActionBar().setTitle("Nivel 1");

        buttonAyudaNivel4 = (Button) findViewById(R.id.button_ayuda_instrucciones4);
        buttonNotaSecreta = (Button) findViewById(R.id.button_nivel4_secreto);

        buttonOpcionDo = (Button) findViewById(R.id.button_opcion_do);
        buttonOpcionDo.setEnabled(false);

        buttonOpcionRe = (Button) findViewById(R.id.button_opcion_re);
        buttonOpcionRe.setEnabled(false);

        buttonOpcionMi = (Button) findViewById(R.id.button_opcion_mi);
        buttonOpcionMi.setEnabled(false);

        mediaPlayerE = MediaPlayer.create(this, R.raw.mi);

        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);

        /*
        Nota secreta
         */
        buttonNotaSecreta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(300);
                mediaPlayerE.start();
                buttonOpcionDo.setEnabled(true);
                buttonOpcionRe.setEnabled(true);
                buttonOpcionMi.setEnabled(true);


            }
        });

        buttonOpcionDo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialogIncorrecto();

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
                openNivel5Activity();
            }
        });

        buttonAyudaNivel4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openInstrucciones();
            }
        });

        imageSapo = (ImageView) findViewById(R.id.img_sapo);
        imageSapo.setImageResource(R.drawable.sapo_saltando);
        sapoSaltando = (AnimationDrawable) imageSapo.getDrawable();
        sapoSaltando.start();
    }

    public void openNivel5Activity(){
        Intent intent = new Intent(this, NivelQuintoActivity.class);
        startActivity(intent);
    }

    public void openInstrucciones(){
        final Dialog dialog = new Dialog(Nivel4Activity.this);
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
        final Dialog dialog = new Dialog(Nivel4Activity.this);
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