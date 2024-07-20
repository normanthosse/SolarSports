package unal.todosalau.solarsports;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterPoolActivity extends AppCompatActivity {

    EditText edtxRegNameField;
    EditText edtxRegAddressField;
    EditText edtxRegPhoneField;
    EditText edtxRegPowerField;
    EditText edtxRegPowerGenField;
    EditText edtxRegPowerConsumField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_pool);

        //buscar toolbar y configurar
        Toolbar tbarRegisterPool = findViewById(R.id.tbarRegisterPool);
        setSupportActionBar(tbarRegisterPool);
        //Habilitar retorno en Toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        edtxRegNameField = findViewById(R.id.edtxRegNameField);
        edtxRegAddressField = findViewById(R.id.edtxRegAddressField);
        edtxRegPhoneField = findViewById(R.id.edtxRegPhoneField);
        edtxRegPowerField = findViewById(R.id.edtxRegPowerField);
        edtxRegPowerGenField = findViewById(R.id.edtxRegPowerGenField);
        edtxRegPowerConsumField = findViewById(R.id.edtxRegPowerConsumField);


        Button btnRegPool = findViewById(R.id.btnRegPool);
        btnRegPool.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(RegisterPoolActivity.this, "SE REGISTRO UN NUEVA PISCINA", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), CategoryPoolActivity.class);
                startActivity(intent);

                registerField();
            }
        });


    }

    //configurar regreso en toolbar
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void registerField (){

        String fieldName = edtxRegNameField.getText().toString();
        String fieldAddress = edtxRegAddressField.getText().toString();
        String fieldPhone = edtxRegPhoneField.getText().toString();
        String fieldPower = edtxRegPowerField.getText().toString();
        String fieldPowerGen = edtxRegPowerGenField.getText().toString();
        String fieldPowerCons = edtxRegPowerConsumField.getText().toString();

    }


}