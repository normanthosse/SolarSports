package unal.todosalau.solarsports;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EnterActivity extends AppCompatActivity {

    private EditText edtxEmailE;
    private EditText edtxPasswordE;

    private UserManager userManager;
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

                String email =edtxEmailE.getText().toString();
                String password =edtxPasswordE.getText().toString();

                if(userManager.loginUser(email, password)) {

                    Toast.makeText(EnterActivity.this, "Ingresando a la APP", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), MajorActivity.class);
                    startActivity(intent);
                    finish(); // deshabilita la opcion de devolverse
                }  else {
                    Toast.makeText(EnterActivity.this, "Email o password Incorrectos", Toast.LENGTH_SHORT).show();
                }
            }
        });


        edtxEmailE = findViewById(R.id.edtxEmailE);
        edtxPasswordE = findViewById(R.id.edtxPasswordE);

        userManager = new UserManager(this);


    }
}