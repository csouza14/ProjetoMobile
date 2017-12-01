package projetomobile.projetomobile.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

import projetomobile.projetomobile.R;


public class ImcActivity extends AppCompatActivity {
    private EditText edtPeso;
    private EditText edtAltura;
    private TextView txtResultado;
    private Button btnCalcular;
    private Button btnLimpar;
    private TextView MuitoBaixo;
    private TextView abaixo;
    private TextView pesoIdeal;
    private TextView sobrepeso;
    private TextView obeso;
    private TextView obesoSevero;
    private TextView obesoMorbido;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc);




        MuitoBaixo= (TextView) findViewById(R.id.idMuitobaixo);
        MuitoBaixo.setVisibility(View.INVISIBLE);

        abaixo= (TextView) findViewById(R.id.idAbaixo);
        abaixo.setVisibility(View.INVISIBLE);

        pesoIdeal= (TextView) findViewById(R.id.idPesoIdeal);
        pesoIdeal.setVisibility(View.INVISIBLE);

        sobrepeso= (TextView) findViewById(R.id.idSobrepeso);
        sobrepeso.setVisibility(View.INVISIBLE);

        obeso= (TextView) findViewById(R.id.idObeso);
        obeso.setVisibility(View.INVISIBLE);

        obesoSevero= (TextView) findViewById(R.id.idObesoSevero);
        obesoSevero.setVisibility(View.INVISIBLE);

        obesoMorbido= (TextView) findViewById(R.id.idObesoMorbido);
        obesoMorbido.setVisibility(View.INVISIBLE);


        edtPeso = (EditText) findViewById(R.id.edtPeso);
        edtAltura = (EditText) findViewById(R.id.edtAltura);
        txtResultado = (TextView) findViewById(R.id.txtResultado);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        Button btnCalcular = (Button) findViewById(R.id.btnCalcular);
        Button btnLimpar = (Button) findViewById(R.id.btnLimpar);


        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtPeso.setText(" ");
                edtAltura.setText(" ");
                MuitoBaixo.setVisibility(View.INVISIBLE);
                abaixo.setVisibility(View.INVISIBLE);
                pesoIdeal.setVisibility(View.INVISIBLE);
                sobrepeso.setVisibility(View.INVISIBLE);
                obeso.setVisibility(View.INVISIBLE);
                obesoSevero.setVisibility(View.INVISIBLE);
                obesoMorbido.setVisibility(View.INVISIBLE);
            }
        });

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                float peso = Float.parseFloat(edtPeso.getText().toString());
                float altura = Float.parseFloat(edtAltura.getText().toString())/100;
                float resultado = peso/(altura*altura);
                txtResultado.setText(resultado+"");



                if (resultado < 17) {
                    Toast.makeText(ImcActivity.this, "Muito Abaixo do Peso", Toast.LENGTH_LONG).show();
                    MuitoBaixo.setVisibility(View.VISIBLE);
                    MuitoBaixo.setText(resultado+" - Muito Abaixo");

                } else {
                    if (resultado >= 17 && resultado < 18.5) {
                        Toast.makeText(ImcActivity.this, "Abaixo do Peso", Toast.LENGTH_LONG).show();
                        abaixo.setVisibility(View.VISIBLE);
                        abaixo.setText(resultado+" - Muito Abaixo");
                    } else {
                        if (resultado >= 18.5 && resultado < 24.9) {
                            Toast.makeText(ImcActivity.this, "Peso Ideal", Toast.LENGTH_LONG).show();
                            pesoIdeal.setVisibility(View.VISIBLE);
                            pesoIdeal.setText(resultado + " - Peso Ideal");
                        } else {
                            if (resultado >= 25 && resultado < 29.9) {
                                Toast.makeText(ImcActivity.this, "SobrePeso", Toast.LENGTH_LONG).show();
                                sobrepeso.setVisibility(View.VISIBLE);
                                sobrepeso.setText(resultado + " - Sobrepeso");
                            } else {
                                if (resultado>= 30 && resultado < 34.9) {
                                    Toast.makeText(ImcActivity.this, "Obeso", Toast.LENGTH_LONG).show();
                                    obeso.setVisibility(View.VISIBLE);
                                    obeso.setText(resultado + " - Obeso");
                                } else {
                                    if (resultado >= 35 && resultado < 39.9) {
                                        Toast.makeText(ImcActivity.this, "Obeso Severo", Toast.LENGTH_LONG).show();
                                        obesoSevero.setVisibility(View.VISIBLE);
                                        obesoSevero.setText(resultado + " - Obeso Severo ");
                                    } else {
                                        if (resultado > 40) {
                                            Toast.makeText(ImcActivity.this, "Obeso Morbido", Toast.LENGTH_LONG).show();
                                            obesoMorbido.setVisibility(View.VISIBLE);
                                            obesoMorbido.setText(resultado + " - Obeso Morbido ");
                                        } else if (edtPeso == null) {
                                            Toast.makeText(ImcActivity.this, "Informe seu peso.", Toast.LENGTH_LONG).show();


                                        } else if (edtAltura == null) {
                                            Toast.makeText(ImcActivity.this, "Informe seu altura.", Toast.LENGTH_LONG).show();

                                        }
                                    }
                                }
                            }
                        }
                    }
                }

            }

        });
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id==android.R.id.home){
            this.finish();
        }

        return super.onOptionsItemSelected(item);
    }
}