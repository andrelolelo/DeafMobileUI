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

public class Nivel3_2Activity extends AppCompatActivity {

    VideoView videoView;

    Button buttonAyudaNivel;

    Button buttonNotaSecreta;

    Button buttonOpcionDo;
    Button buttonOpcionRe;
    Button buttonOpcionMi;
    Button buttonOpcionFa;
    Button buttonOpcionSol;


    MediaPlayer mediaPlayerF;

    Vibrator vibrator;

    ImageView imageCanguro;
    AnimationDrawable canguroSaltando;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nivel32);
        getSupportActionBar().setTitle("Nivel 3");

        buttonAyudaNivel = (Button) findViewById(R.id.button_ayuda_instrucciones);
        buttonNotaSecreta = (Button) findViewById(R.id.button_nivel3_secreto);

        buttonOpcionDo = (Button) findViewById(R.id.button_opcion_do3);
        buttonOpcionDo.setEnabled(false);

        buttonOpcionRe = (Button) findViewById(R.id.button_opcion_re3);
        buttonOpcionRe.setEnabled(false);

        buttonOpcionMi = (Button) findViewById(R.id.button_opcion_mi3);
        buttonOpcionMi.setEnabled(false);

        buttonOpcionFa = (Button) findViewById(R.id.button_opcion_fa3);
        buttonOpcionFa.setEnabled(false);

        buttonOpcionSol = (Button) findViewById(R.id.button_opcion_sol3);
        buttonOpcionSol.setEnabled(false);

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
                buttonOpcionSol.setEnabled(true);

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
                openSiguienteActivity();


            }
        });

        buttonOpcionSol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialogIncorrecto();

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
        Animación canguro saltando
         */
        imageCanguro = (ImageView) findViewById(R.id.img_canguro);
        imageCanguro.setImageResource(R.drawable.canguro_saltando);
        canguroSaltando = (AnimationDrawable) imageCanguro.getDrawable();
        canguroSaltando.start();
    }

    /*
    Abrir siguiente pantalla
     */
    public void openSiguienteActivity(){
        Intent intent = new Intent(this, Nivel3_3Activity.class);
        startActivity(intent);
    }

    /*
    Instrucciones del nivel
     */
    public void openInstrucciones(){
        final Dialog dialog = new Dialog(Nivel3_2Activity.this);
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
        final Dialog dialog = new Dialog(Nivel3_2Activity.this);
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