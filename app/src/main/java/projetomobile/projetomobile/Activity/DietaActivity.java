package projetomobile.projetomobile.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import projetomobile.projetomobile.R;

public class DietaActivity extends AppCompatActivity {
    private ImageView dietaCarb;
    private ImageView dietaOvo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dieta);


        dietaCarb = (ImageView) findViewById(R.id.imgCarb);
        dietaOvo = (ImageView) findViewById(R.id.imgOvo);

        dietaCarb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DietaActivity.this, LowCarbActivity.class);
                startActivity(intent);
            }
        });

        dietaOvo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DietaActivity.this, OvoActivity.class);
                startActivity(intent);
            }
        });

    }
}
