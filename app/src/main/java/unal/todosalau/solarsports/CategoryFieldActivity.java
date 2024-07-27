package unal.todosalau.solarsports;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class CategoryFieldActivity extends AppCompatActivity {


    String[] fields = {"Campo : Creativos FC Sede Dorado",
            "Campo :  La Amistad",
            "Campo : Fultbol 8 Paris",
            "Campo : La 11 Futbol 8",
            "Campo : Somos Messi"};

    String [] address = {"Calle 98 No. 89 -55",
            "Transversal 55 No. 57-00",
            "Carrera 11 No. 11-77",
            "Callejon de la 94 No. 55.99",
            "Carrera 12 No. 9-04"};

    String [] city = {"Bogotá", "Bogotá", "Bogotá", "Bogotá", "Bogotá"};
    String [] phone = {"3118866011", "3124332111", "3125678811", "3002345611", "3103211211"};

    Double [] power = {4000.0, 4800.0, 5200.0, 6000.0, 6800.0};
    Double [] generated = {20000.0, 24000.0, 25000.0, 26000.0, 34000.0};
    Double [] consumed = {20000.0, 24000.0, 25000.0, 126000.0, 18000.0};
    int [] imgfields = {R.drawable.field_creativos, R.drawable.field_amistad, R.drawable.field_futbol8, R.drawable.field_messi, R.drawable.fiel_la11};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_field);


        //buscar toolbar y configurar
        Toolbar tbarCatField = findViewById(R.id.tbarCatField);
        setSupportActionBar(tbarCatField);
        //Habilitar retorno en Toolbar
        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }


        //IR a registrar nuevo campo
        Button btnAddField = findViewById(R.id.btnAddField);
        btnAddField.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RegisterFieldActivity.class);
                startActivity(intent);
            }
        });

        //intent para los textview del toolbar
        TextView txvFieldCampos = findViewById(R.id.txvFieldCampos);
        txvFieldCampos.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CategoryFieldActivity.class);
                startActivity(intent);
            }
        });

        TextView txvFieldCanchas =findViewById(R.id.txvFieldCanchas);
        txvFieldCanchas.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CategoryCourtActivity.class);
                startActivity(intent);
            }
        });

        TextView txvFieldSalas = findViewById(R.id.txvFieldSalas);
        txvFieldSalas.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CategoryRoomActivity.class);
                startActivity(intent);
            }
        });

        TextView txvFieldPiscinas = findViewById(R.id.txvFieldPiscinas);
        txvFieldPiscinas.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CategoryPoolActivity.class);
                startActivity(intent);
            }
        });

        //Referenciar el recyclerView del layout, como se va a ver y setear
        RecyclerView recycler_fields = findViewById(R.id.recycler_fields);
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) new LinearLayoutManager(this); //vista en lista
        recycler_fields.setLayoutManager(linearLayoutManager); //set en lista

        //setear adaptador
        recycler_fields.setAdapter(new FieldsAdapter());

    }

    //configurar regreso en toolbar
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            Intent intent = new Intent(getApplicationContext(), MajorActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    // crear clase para gestionar el recyclerview y los metodos de la interfaz lógica
    private class FieldsAdapter extends RecyclerView.Adapter<FieldsAdapter.FieldsAdapterHolder> {
        @NonNull
        @Override
        public FieldsAdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new FieldsAdapterHolder(getLayoutInflater().inflate(R.layout.item_cat_field,parent,false));
            //definir el xml y pone el diseño creado
        }

        //hace la referencia por cada item en la lista según la posición
        @Override
        public void onBindViewHolder(@NonNull FieldsAdapterHolder holder, int position) {
            holder.imprimir(position);//cada vez q necesita elemento llame a la posición

        }

        //indica cantidad de elementos de la lista acorde con la cantidad ingresada
        @Override
        public int getItemCount() {

            return fields.length;
        }

        //crear viewHolder para fields, donde se ubican los datos de cada item
        private class FieldsAdapterHolder extends RecyclerView.ViewHolder{
            //generar variables del modelo cate_field
            ImageView imgCatField;
            TextView txvFieldName, txvFieldAddress, txvFieldCity, txvFieldPhone, txvFieldPower, txvEnergyGenerat, txvEnergyConsum;

                //crear construcctor [definir y construir objeto]
            public FieldsAdapterHolder(@NonNull View itemView) {
                super(itemView);
                //generar referencias de las variables para multiples elementos del itemviev
                imgCatField = itemView.findViewById(R.id.imgCatField);
                txvFieldName = itemView.findViewById(R.id.txvFieldName);
                txvFieldAddress = itemView.findViewById(R.id.txvFieldAddress);
                txvFieldCity = itemView.findViewById(R.id.txvFieldCity);
                txvFieldPhone = itemView.findViewById(R.id.txvFieldPhone);
                txvFieldPower = itemView.findViewById(R.id.txvFieldPower);
                txvEnergyGenerat = itemView.findViewById(R.id.txvEnergyGenerat);
                txvEnergyConsum = itemView.findViewById(R.id.txvEnergyConsum);

            }
            public void imprimir (int position) {
                imgCatField.setImageResource(imgfields[position]);
                txvFieldName.setText(fields[position]);
                txvFieldCity.setText("Ciudad : " +city[position]);
                txvFieldAddress.setText("Dirección : " + address[position]);
                txvFieldPhone.setText("Teléfono : " +phone[position]);
                txvFieldPower.setText(String.valueOf("Potencia Instalada : " +power[position] + "  Watts"));
                txvEnergyGenerat.setText(String.valueOf("Energía Generada : " + generated[position] + "Watts"));
                txvEnergyConsum.setText(String.valueOf("Energía Consumida : " + consumed[position] + "Watts"));

            }
        }
    }


}