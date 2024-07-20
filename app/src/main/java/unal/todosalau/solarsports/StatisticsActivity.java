package unal.todosalau.solarsports;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class StatisticsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        Button btnExitStatistics = findViewById(R.id.btnExitStatistics);
        btnExitStatistics.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Toast.makeText(StatisticsActivity.this, "Saliendo de Estadisticas",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(StatisticsActivity.this, MajorActivity.class);
                startActivity(intent);
            }
        });


    }
}