package unal.todosalau.solarsports;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MajorActivity extends AppCompatActivity {

    private TextView txvDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_major);

        //Colocar fecha en el layout
        txvDate = findViewById(R.id.txvDate);
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE, d 'de' MMMM 'de' yyyy", new Locale("es", "CO"));
        String currentDate = sdf.format(new Date());
        txvDate.setText(currentDate);



        Button btnExitMajor = findViewById(R.id.btnExitMajor);
        btnExitMajor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MajorActivity.this, "Saliendo de la APP", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        LinearLayout linlayoutCategory = findViewById(R.id.linlayoutCategory);
        linlayoutCategory.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(MajorActivity.this,"Entrando a categorias", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), CategoryFieldActivity.class);
                startActivity(intent);
            }
        });

        LinearLayout linlayoutStatistics = findViewById(R.id.linlayoutStatistics);
        linlayoutStatistics.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(MajorActivity.this,"Ingresando a Estadisticas", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), StatisticsActivity.class);
                startActivity(intent);

            }
        });

        LinearLayout linlayoutTips = findViewById(R.id.linlayoutTips);
        linlayoutTips.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Ingresando a TIPS", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), TipsActivity.class);
                startActivity(intent);
            }
        });


    }
}