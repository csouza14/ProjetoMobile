package projetomobile.projetomobile.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import projetomobile.projetomobile.R;

public class PrincipalActivity extends AppCompatActivity {
    private LinearLayout laImc;
    private LinearLayout layoutEstatistica;
    private LinearLayout liDieta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        laImc = (LinearLayout) findViewById(R.id.laImc);
        layoutEstatistica = (LinearLayout) findViewById(R.id.layoutEstatistica);
        liDieta = (LinearLayout) findViewById(R.id.liDieta);


        laImc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PrincipalActivity.this, ImcActivity.class);
                startActivity(intent);
            }
        });


        layoutEstatistica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PrincipalActivity.this, EstatisticaActivity.class);
                startActivity(intent);
            }
        });


        liDieta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PrincipalActivity.this, DietaActivity.class);
                startActivity(intent);
            }
        });


    }

}
