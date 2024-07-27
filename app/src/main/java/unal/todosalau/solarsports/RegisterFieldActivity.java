package unal.todosalau.solarsports;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class RegisterFieldActivity extends AppCompatActivity {

    EditText edtxRegNameField;
    EditText edtxRegAddressField;
    EditText edtxRegPhoneField;
    EditText edtxRegPowerField;
    EditText edtxRegPowerGenField;
    EditText edtxRegPowerConsumField;
    EditText edtxRegCityField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_field);

        //buscar toolbar y configurar
        Toolbar tbarRegisterField = findViewById(R.id.tbarRegisterField);
        setSupportActionBar(tbarRegisterField);
        //Habilitar retorno en Toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        edtxRegNameField = findViewById(R.id.edtxRegNameField);
        edtxRegAddressField = findViewById(R.id.edtxRegAddressField);
        edtxRegCityField = findViewById(R.id.edtxRegCityField);
        edtxRegPhoneField = findViewById(R.id.edtxRegPhoneField);
        edtxRegPowerField = findViewById(R.id.edtxRegPowerField);
        edtxRegPowerGenField = findViewById(R.id.edtxRegPowerGenField);
        edtxRegPowerConsumField = findViewById(R.id.edtxRegPowerConsumField);


        Button btnRegField = findViewById(R.id.btnRegField);
        btnRegField.setOnClickListener(v -> registerField());
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
        String fieldCity = edtxRegCityField.getText().toString();
        String fieldPhone = edtxRegPhoneField.getText().toString();
        String fieldPower = edtxRegPowerField.getText().toString();
        String fieldPowerGen = edtxRegPowerGenField.getText().toString();
        String fieldPowerCons = edtxRegPowerConsumField.getText().toString();

        if(fieldName.isEmpty()|| fieldAddress.isEmpty() || fieldCity.isEmpty() || fieldPhone.isEmpty()
                || fieldPowerCons.isEmpty() || fieldPowerGen.isEmpty() || fieldPower.isEmpty()){
            Toast.makeText(this, "Complete los campos obligatorios", Toast.LENGTH_SHORT).show();
            return;
        }

        //guardar los datos en ShareReference como RegisterField en modo privado
        SharedPreferences preferences = getSharedPreferences("RegisterField", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        int index = preferences.getInt("index", 0);
        editor.putString("name" + index, fieldName);
        editor.putString("address" + index, fieldAddress);
        editor.putString("phone" + index, fieldPhone);
        editor.putString("city" + index, fieldCity);
        editor.putString("Power" + index, fieldPower);
        editor.putString("Generated" + index, fieldPowerGen);
        editor.putString("consumed" + index, fieldPowerCons);

        editor.putInt("index", index+1);
        editor.apply();

        Toast.makeText(this,"Campo Registrado", Toast.LENGTH_SHORT).show();
        finish();
    }


}