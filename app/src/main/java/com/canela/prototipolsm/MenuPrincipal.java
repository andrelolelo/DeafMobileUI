package com.canela.prototipolsm;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

public class MenuPrincipal extends AppCompatActivity {

    VideoView videoView;
    Button buttonPiano;
    Button buttonAprendeNotas;
    Button buttonInfo;
    TextView textViewColaboradores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
        getSupportActionBar().setTitle("Bienvenido");

        buttonPiano = (Button) findViewById(R.id.button_piano);
        buttonAprendeNotas = (Button) findViewById(R.id.button_aprende_notas);
        buttonInfo = (Button) findViewById(R.id.button_info);

        textViewColaboradores = (TextView) findViewById(R.id.textViewColaboradores);

         /*
        Evento para el botón Piano
         */
        buttonPiano.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPianoActivity();

            }
        });

        /*
        Evento para el botón Aprende las notas
         */
        buttonAprendeNotas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAprendeActivity();

            }
        });

        /*
        Evento para el botón Info
         */

        buttonInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openInfoActivity();

            }
        });

        /*
        Evento para el hipervínculo Colaboradores
         */
        textViewColaboradores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(),"Hello dudes",Toast.LENGTH_SHORT).show();
                final Dialog dialog = new Dialog(MenuPrincipal.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_design_colaboradores);
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
        });


        final Dialog dialog = new Dialog(MenuPrincipal.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_video_bienvenida);
        dialog.show();

        //Video
        videoView=(VideoView)dialog.findViewById(R.id.video_bienvenida);
        //videoView = findViewById(R.id.video_bienvenida);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);

        //Uri
        String videoPath="android.resource://" + getPackageName() + "/" + R.raw.bienvenida_aplicacion1;
        Uri uri = Uri.parse(videoPath);

        //Set media controller
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri);

        //Start video
        videoView.start();
    }

    public void openPianoActivity(){
        Intent intent = new Intent(this, PianoActivity.class);
        startActivity(intent);
    }

    public void openAprendeActivity(){
        Intent intent = new Intent(this, AprendeLasNotasActivity.class);
        startActivity(intent);
    }

    public void openInfoActivity(){
        Intent intent = new Intent(this, InfoMusical.class);
        startActivity(intent);
    }
}