package projetomobile.projetomobile.Activity;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import projetomobile.projetomobile.R;

public class PrincipalActivity extends AppCompatActivity {
    private LinearLayout laImc;
    private LinearLayout layoutEstatistica;
    private LinearLayout layoutdieta;
  //  private DrawerLayout mDrawer;
  //  private ActionBarDrawerToggle mToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        laImc = (LinearLayout) findViewById(R.id.laImc);
        layoutEstatistica = (LinearLayout) findViewById(R.id.layoutEstatistica);
        layoutdieta = (LinearLayout) findViewById(R.id.layoutdieta);

        //mDrawer = (DrawerLayout) findViewById(R.id.drawer);
       // mToggle = new ActionBarDrawerToggle(PrincipalActivity.this, mDrawer, R.string.Open, R.string.Close);
       // mDrawer.addDrawerListener(mToggle);
       // mToggle.syncState();
       // getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


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

        layoutdieta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentd = new Intent(PrincipalActivity.this, DietasActivity.class);
                startActivity(intentd);
            }
        });


    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            this.finish();
        }
    //    if (mToggle.onOptionsItemSelected(item)) {
     //       return true;
       // }

        return super.onOptionsItemSelected(item);
    }

}
