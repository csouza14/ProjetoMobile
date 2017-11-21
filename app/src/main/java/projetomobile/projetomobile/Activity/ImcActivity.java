package projetomobile.projetomobile.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import projetomobile.projetomobile.R;


public class ImcActivity extends AppCompatActivity {
    private EditText edtPeso;
    private EditText edtAltura;
    private TextView txtResultado;
    private Button btnCalcular;
    private Button btnLimpar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc);

        edtPeso = (EditText) findViewById(R.id.edtPeso);
        edtAltura = (EditText) findViewById(R.id.edtAltura);
        txtResultado = (TextView) findViewById(R.id.txtResultado);


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
            }
        });

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                float peso = Float.parseFloat(edtPeso.getText().toString());
                float altura = Float.parseFloat(edtAltura.getText().toString()) / 100;
                float resultado = peso / (altura * altura);

                txtResultado.setText(" " + resultado);

                if (resultado < 17) {
                    Toast.makeText(ImcActivity.this, "Muito Abaixo do Peso", Toast.LENGTH_LONG).show();
                } else {
                    if (resultado >= 17 && resultado < 18.5) {
                        Toast.makeText(ImcActivity.this, "Abaixo do Peso", Toast.LENGTH_LONG).show();

                    } else {
                        if (resultado >= 18.5 && resultado < 24.9) {
                            Toast.makeText(ImcActivity.this, "Peso Ideal", Toast.LENGTH_LONG).show();

                        } else {
                            if (resultado >= 25 && resultado < 29.9) {
                                Toast.makeText(ImcActivity.this, "SobrePeso", Toast.LENGTH_LONG).show();

                            } else {
                                if (resultado >= 30 && resultado < 34.9) {
                                    Toast.makeText(ImcActivity.this, "Obeso", Toast.LENGTH_LONG).show();

                                } else {
                                    if (resultado >= 35 && resultado < 39.9) {
                                        Toast.makeText(ImcActivity.this, "Obeso Severo", Toast.LENGTH_LONG).show();

                                    } else {
                                        if (resultado > 40) {
                                            Toast.makeText(ImcActivity.this, "Obeso Morbido", Toast.LENGTH_LONG).show();

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
}