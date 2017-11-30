package projetomobile.projetomobile.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

import projetomobile.projetomobile.R;

public class Estatistica4Activity extends AppCompatActivity {
    private TextView txtProximo;
    PieChart pieChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estatistica);

        pieChart =(PieChart) findViewById(R.id.piechart);
        txtProximo = (TextView) findViewById(R.id.txtProximo);


        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        txtProximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Estatistica4Activity.this, Estatistica5Activity.class);
                startActivity(intent);
            }
        });


        pieChart.setUsePercentValues(false);
        pieChart.getDescription().setEnabled(false);
        pieChart.setExtraOffsets(10,10,5,5);

        pieChart.setDragDecelerationFrictionCoef(0.95f);

        pieChart.setDrawHoleEnabled(false);
        pieChart.setHoleColor(Color.WHITE);
        pieChart.setTransparentCircleRadius(70f);

        ArrayList<PieEntry> yValues = new ArrayList<>();


        yValues.add(new PieEntry(45.9f,"Sedentários"));
        yValues.add(new PieEntry(25.6f,"Praticante de esporte"));
        yValues.add(new PieEntry(28.5f,"Praticante de atividade física"));


        pieChart.animateY(1000, Easing.EasingOption.EaseInCubic);


        Description description = new Description();
        description.setText("Porcentual das pessoas sedentarias e das pessoas que praticam atividade física");
        description.setTextSize(11);
        pieChart.setDescription(description);




        PieDataSet dataSet = new PieDataSet(yValues, "Adultos");
        dataSet.setSliceSpace(2f);
        dataSet.setSelectionShift(5f);
        dataSet.setColors(ColorTemplate.MATERIAL_COLORS);

        PieData data = new PieData((dataSet));
        data.setValueTextSize(15f);
        data.setValueTextColor(Color.BLACK);

        pieChart.setData(data);



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
