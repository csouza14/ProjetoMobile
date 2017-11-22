package projetomobile.projetomobile.Activity;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

import projetomobile.projetomobile.R;

public class EstatisticaActivity extends AppCompatActivity {


    PieChart pieChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estatistica);

        pieChart =(PieChart) findViewById(R.id.piechart);

        pieChart.setUsePercentValues(true);
        pieChart.getDescription().setEnabled(false);
        pieChart.setExtraOffsets(10,10,5,5);

        pieChart.setDragDecelerationFrictionCoef(0.95f);

        pieChart.setDrawHoleEnabled(false);
        pieChart.setHoleColor(Color.WHITE);
        pieChart.setTransparentCircleRadius(60f);

        ArrayList<PieEntry> yValues = new ArrayList<>();


        yValues.add(new PieEntry(04f,"Abaixo do peso"));
        yValues.add(new PieEntry(85f,"Peso ideal"));
        yValues.add(new PieEntry(69f,"Acima do peso"));
        yValues.add(new PieEntry(35f,"Obeso"));


        Description description = new Description();
        description.setText("Evolução da frequência de obesidade");
        description.setTextSize(11);
        pieChart.setDescription(description);


        pieChart.animateY(1000, Easing.EasingOption.EaseInCubic);

        PieDataSet dataSet = new PieDataSet(yValues, "Festas");
        dataSet.setSliceSpace(2f);
        dataSet.setSelectionShift(5f);
        dataSet.setColors(ColorTemplate.LIBERTY_COLORS);

        PieData data = new PieData((dataSet));
        data.setValueTextSize(15f);
        data.setValueTextColor(Color.BLACK);

        pieChart.setData(data);



    }
}
