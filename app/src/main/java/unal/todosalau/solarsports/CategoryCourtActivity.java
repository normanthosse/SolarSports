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
import android.widget.ImageView;
import android.widget.TextView;

public class CategoryCourtActivity extends AppCompatActivity {


    String[] courts = {"Cancha : Creativos FC Sede Dorado",
            "Cancha :  La Amistad",
            "Cancha : Fultbol 8 Paris",
            "Cancha : La 11 Futbol 8",
            "Cancha : Somos Messi"};

    String [] addressCourts = {"Calle 98 No. 89 -55",
            "Transversal 55 No. 57-00",
            "Carrera 11 No. 11-77",
            "Callejon de la 94 No. 55.99",
            "Carrera 12 No. 9-04"};

    String [] cityCourts = {"Bogotá", "Bogotá", "Bogotá", "Bogotá", "Bogotá"};
    String [] phoneCourts = {"3118866035", "3124332123", "3125678899", "3002345678", "3103211223"};
    int [] imgCourts = {R.drawable.field_creativos, R.drawable.field_amistad, R.drawable.field_futbol8, R.drawable.field_messi, R.drawable.fiel_la11};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_court);

        //buscar toolbar y configurar
        Toolbar tbarCatCourt = findViewById(R.id.tbarCatCourt);
        setSupportActionBar(tbarCatCourt);
        //Habilitar retorno en Toolbar
        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }



        //inten para registrar nuevo
        Button btnAddCourt = findViewById(R.id.btnAddCourt);
        btnAddCourt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RegisterCourtActivity.class);
                startActivity(intent);
            }
        });

        //intent para los textview del toolbar
        TextView txvCourtCampos = findViewById(R.id.txvCourtCampos);
        txvCourtCampos.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CategoryFieldActivity.class);
                startActivity(intent);
            }
        });

        TextView txvCourtCanchas = findViewById(R.id.txvCourtCanchas);
        txvCourtCanchas.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CategoryCourtActivity.class);
                startActivity(intent);
            }
        });

        TextView txvCourtSalas = findViewById(R.id.txvCourtSalas);
        txvCourtSalas.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CategoryRoomActivity.class);
                startActivity(intent);
            }
        });


        TextView txvCourtPiscinas = findViewById(R.id.txvCourtPiscinas);
        txvCourtPiscinas.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(getApplicationContext(), CategoryPoolActivity.class);
               startActivity(intent);
            }
        });


        //Referenciar el recyclerView del layout, como se va a ver y setear
        RecyclerView recycler_courts = findViewById(R.id.recycler_courts);
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) new LinearLayoutManager(this); //vista en lista
        recycler_courts.setLayoutManager(linearLayoutManager); //set en lista

        //setear adaptador
        recycler_courts.setAdapter(new CourtsAdapter());

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
        private class  CourtsAdapter extends RecyclerView.Adapter<CourtsAdapter.CourtsAdapterHolder>{

        @NonNull
        @Override
        public CourtsAdapter.CourtsAdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new CourtsAdapterHolder(getLayoutInflater().inflate(R.layout.item_cat_field, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull CourtsAdapter.CourtsAdapterHolder holder, int position) {
            holder.imprimirCourts(position);

        }

        @Override
        public int getItemCount() {
            return courts.length;
        }

        //crear viewHolder para fields, donde se ubican los datos de cada item
        private class CourtsAdapterHolder extends RecyclerView.ViewHolder {

            //generar variables desde el item/cat/field
            ImageView imgCatField;
            TextView txvFieldName, txvFieldAddress, txvFieldCity, txvFieldPhone;


            //crear construcctor [definir y construir objeto]
            public CourtsAdapterHolder(@NonNull View itemView) {
                super(itemView);

                //generar referencias de las variables para multiples elementos del itemviev
                imgCatField = itemView.findViewById(R.id.imgCatField);
                txvFieldName = itemView.findViewById(R.id.txvFieldName);
                txvFieldAddress = itemView.findViewById(R.id.txvFieldAddress);
                txvFieldCity = itemView.findViewById(R.id.txvFieldCity);
                txvFieldPhone = itemView.findViewById(R.id.txvFieldPhone);

            }

            //generar posiciones desde field
            public void imprimirCourts(int position) {
                imgCatField.setImageResource(imgCourts[position]);
                txvFieldName.setText(courts[position]);
                txvFieldCity.setText(cityCourts[position]);
                txvFieldAddress.setText(addressCourts[position]);
                txvFieldPhone.setText(phoneCourts[position]);
            }
        }
    }

}