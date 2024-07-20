package unal.todosalau.solarsports;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnRegisterMain = (Button) findViewById(R.id.btnRegisterMain);
        btnRegisterMain.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
            Toast.makeText(MainActivity.this, "Ingrese Email y Contraseña", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
            startActivity(intent);
            }
        });

        Button btnEnterMain =findViewById(R.id.btnEnterMain);
        btnEnterMain.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Entrar a la APP", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),EnterActivity.class);
                startActivity(intent);
            }
        });
    }
}