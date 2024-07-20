package unal.todosalau.solarsports;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class EnterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter);

        Button btnRegisterE = findViewById(R.id.btnRegisterE);
        btnRegisterE.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(EnterActivity.this, "Registrar nuevo usuario", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });

        Button btnIngresarE = findViewById(R.id.btnIngresarE);
        btnIngresarE.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(EnterActivity.this, "Ingresando a la APP", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),MajorActivity.class);
                startActivity(intent);
            }
        });





    }
}