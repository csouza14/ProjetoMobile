package projetomobile.projetomobile.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

import projetomobile.projetomobile.R;

public class Estatistica3Activity extends AppCompatActivity {

    private TextView txtProximo;
    PieChart pieChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estatistica);

        pieChart =(PieChart) findViewById(R.id.piechart);
        txtProximo = (TextView) findViewById(R.id.txtProximo);

        txtProximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Estatistica3Activity.this, Estatistica4Activity.class);
                startActivity(intent);
            }
        });


        pieChart.setUsePercentValues(false);
        pieChart.getDescription().setEnabled(false);
        pieChart.setExtraOffsets(10,10,5,5);

        pieChart.setDragDecelerationFrictionCoef(0.95f);

        pieChart.setDrawHoleEnabled(true);
        pieChart.setHoleColor(Color.WHITE);
        pieChart.setTransparentCircleRadius(60f);

        ArrayList<PieEntry> yValues = new ArrayList<>();


        yValues.add(new PieEntry(49f,"Normal"));
        yValues.add(new PieEntry(17f,"Sobrepeso"));
        yValues.add(new PieEntry(9f,"Obesidade"));
        yValues.add(new PieEntry(14f,"Magreza aguda"));
        yValues.add(new PieEntry(11f,"Magreza"));


        Description description = new Description();
        description.setText("Porcentual de peso de Adolescentes no Brasil");
        description.setTextSize(11);
        pieChart.setDescription(description);




        PieDataSet dataSet = new PieDataSet(yValues, "Adolescentes");
        dataSet.setSliceSpace(2f);
        dataSet.setSelectionShift(5f);
        dataSet.setColors(ColorTemplate.VORDIPLOM_COLORS);

        PieData data = new PieData((dataSet));
        data.setValueTextSize(15f);
        data.setValueTextColor(Color.BLACK);

        pieChart.setData(data);



    }
}
