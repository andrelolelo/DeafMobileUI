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

public class Nivel6Activity extends AppCompatActivity {

    ImageView imageSapo;
    AnimationDrawable sapoSaltando;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nivel6);
        getSupportActionBar().setTitle("Nivel 1");

        imageSapo = (ImageView) findViewById(R.id.img_sapo);
        imageSapo.setImageResource(R.drawable.sapo_saltando);
        sapoSaltando = (AnimationDrawable) imageSapo.getDrawable();
        sapoSaltando.start();


        Dialog dialog = new Dialog(Nivel6Activity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_design_correcto);
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
        Intent intent = new Intent(this, AprendeLasNotasActivity2.class);
        startActivity(intent);
    }



    }
