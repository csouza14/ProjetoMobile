package projetomobile.projetomobile.Activity;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

import projetomobile.projetomobile.R;

public class Estatistica5Activity extends AppCompatActivity {

    PieChart pieChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estatistica);

        pieChart =(PieChart) findViewById(R.id.piechart);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        pieChart.setUsePercentValues(false);
        pieChart.getDescription().setEnabled(false);
        pieChart.setExtraOffsets(10,10,5,5);

        pieChart.setDragDecelerationFrictionCoef(0.95f);

        pieChart.setDrawHoleEnabled(false);
        pieChart.setHoleColor(Color.WHITE);
        pieChart.setTransparentCircleRadius(70f);

        ArrayList<PieEntry> yValues = new ArrayList<>();


        yValues.add(new PieEntry(50f,"Alimentos não saudáveis"));
        yValues.add(new PieEntry(35f,"Sedentarismo"));
        yValues.add(new PieEntry(10f,"Hormonios"));
        yValues.add(new PieEntry(5f,"Genética"));


        pieChart.animateY(1000, Easing.EasingOption.EaseInCubic);


        Description description = new Description();
        description.setText("O que causa a Obesidade");
        description.setTextSize(11);
        pieChart.setDescription(description);




        PieDataSet dataSet = new PieDataSet(yValues, "Adultos");
        dataSet.setSliceSpace(2f);
        dataSet.setSelectionShift(5f);
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);

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
