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

public class NivelXActivity extends AppCompatActivity {

    VideoView videoView;

    Button buttonAyudaNivel;

    Button buttonNotaSecreta;

    Button buttonOpcionDo;
    Button buttonOpcionRe;
    Button buttonOpcionMi;
    Button buttonOpcionFa;

    MediaPlayer mediaPlayerF;

    Vibrator vibrator;

    ImageView imageConejo;
    AnimationDrawable conejoSaltando;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nivel_xactivity);
        getSupportActionBar().setTitle("Nivel 2");

        buttonAyudaNivel = (Button) findViewById(R.id.button_ayuda_instrucciones_x);
        buttonNotaSecreta = (Button) findViewById(R.id.button_nivel_secreto_x);

        buttonOpcionDo = (Button) findViewById(R.id.button_opcion_do);
        buttonOpcionDo.setEnabled(false);

        buttonOpcionRe = (Button) findViewById(R.id.button_opcion_re);
        buttonOpcionRe.setEnabled(false);

        buttonOpcionMi = (Button) findViewById(R.id.button_opcion_mi);
        buttonOpcionMi.setEnabled(false);

        buttonOpcionFa = (Button) findViewById(R.id.button_opcion_fa);
        buttonOpcionFa.setEnabled(false);

        mediaPlayerF = MediaPlayer.create(this, R.raw.fa);

        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);

        /*
        Nota secreta
         */
        buttonNotaSecreta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(400);
                mediaPlayerF.start();
                buttonOpcionDo.setEnabled(true);
                buttonOpcionRe.setEnabled(true);
                buttonOpcionMi.setEnabled(true);
                buttonOpcionFa.setEnabled(true);
            }
        });

        /*
        Botones notas musicales
         */
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
                openDialogIncorrecto();
            }
        });

        buttonOpcionFa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNivelFActivity();
            }
        });

        /*
        Botón ayuda
         */
        buttonAyudaNivel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openInstrucciones();
            }
        });

        /*
        Animación conejo saltando
         */
        imageConejo = (ImageView) findViewById(R.id.img_conejo);
        imageConejo.setImageResource(R.drawable.conejo_saltando);
        conejoSaltando = (AnimationDrawable) imageConejo.getDrawable();
        conejoSaltando.start();
    }

    /*
    Abrir siguiente pantalla
     */
    public void openNivelFActivity(){
        Intent intent = new Intent(this, NivelFActivity.class);
        startActivity(intent);
    }

    /*
    Instrucciones del nivel
     */
    public void openInstrucciones(){
        final Dialog dialog = new Dialog(NivelXActivity.this);
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

    /*
    Mensaje de nota incorrecta
     */
    public void openDialogIncorrecto(){
        final Dialog dialog = new Dialog(NivelXActivity.this);
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