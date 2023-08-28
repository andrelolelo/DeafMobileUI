package com.canela.prototipolsm;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

public class Nivel3_9Activity extends AppCompatActivity {

    ImageView imageCanguro;
    AnimationDrawable canguroSaltando;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nivel39);
        getSupportActionBar().setTitle("Nivel 3");

        /*
        Animación canguro saltando
         */
        imageCanguro = (ImageView) findViewById(R.id.img_canguro);
        imageCanguro.setImageResource(R.drawable.canguro_saltando);
        canguroSaltando = (AnimationDrawable) imageCanguro.getDrawable();
        canguroSaltando.start();

        Dialog dialog = new Dialog(Nivel3_9Activity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_design_ganaste);
        dialog.setCancelable(false);
        dialog.show();

        Button buttonDialog = dialog.findViewById(R.id.btn_dialog_continuar);

        buttonDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSiguienteNivelActivity();
            }
        });
    }

    public void openSiguienteNivelActivity(){
        Intent intent = new Intent(this, MenuPrincipal.class);
        startActivity(intent);
    }
}