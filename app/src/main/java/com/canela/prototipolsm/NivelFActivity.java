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

public class NivelFActivity extends AppCompatActivity {

    ImageView imageConejo;
    AnimationDrawable conejoSaltando;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nivel_factivity);
        getSupportActionBar().setTitle("Nivel 2");

        imageConejo = (ImageView) findViewById(R.id.img_conejo);
        imageConejo.setImageResource(R.drawable.conejo_saltando);
        conejoSaltando = (AnimationDrawable) imageConejo.getDrawable();
        conejoSaltando.start();


        Dialog dialog = new Dialog(NivelFActivity.this);
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
        Intent intent = new Intent(this, AprendeLasNotasActivity3.class);
        startActivity(intent);
    }
}