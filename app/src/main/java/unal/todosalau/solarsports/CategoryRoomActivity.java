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

public class CategoryRoomActivity extends AppCompatActivity {

    String [] rooms = {"Coliseo : La Estancia",
            "Coliseo : El Salitre",
            "Coliseo : Ancora II",
            "Coliseo : Tulio Cocina",
            "Coliseo : Las Palmas"};

    String [] addressRoom = {
            "Carrera 11 calle 14",
            "avenida Doradal No. 55-00",
            "Callejon del Ancora No. 100",
            "Calle La Constancia Peperoni",
            "La Palmas No. 111-00"};

    String [] cityRoom = {"Popayán", "Cali", "Medellin", "San Jose", "Medellin"};
    String [] phoneRoom = {"3118866033","312433233","3125678833","3002345633","3103211233"};
    int[] imgRooms = {R.drawable.room_estancia, R.drawable.room_salitre, R.drawable.room_ancora, R.drawable.room_tulio, R.drawable.room_palmas};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_room);

        //buscar toolbar y configurar
        Toolbar tbarCatRoom = findViewById(R.id.tbarCatRoom);
        setSupportActionBar(tbarCatRoom);
        //Habilitar retorno en Toolbar
        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }



        Button btnAddRoom = findViewById(R.id.btnAddRoom);
        btnAddRoom.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RegisterRoomActivity.class);
                startActivity(intent);
            }
        });

        TextView txvRoomCampos = findViewById(R.id.txvRoomCampos);
        txvRoomCampos.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CategoryFieldActivity.class);
                startActivity(intent);
            }
        });

        TextView txvRoomCanchas = findViewById(R.id.txvRoomCanchas);
        txvRoomCanchas.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CategoryCourtActivity.class);
                startActivity(intent);
            }
        });

        TextView txvRoomSalas = findViewById(R.id.txvRoomSalas);
        txvRoomSalas.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CategoryRoomActivity.class);
                startActivity(intent);
            }
        });

        TextView txvRoomPiscinas = findViewById(R.id.txvRoomPiscinas);
        txvRoomPiscinas.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CategoryPoolActivity.class);
                startActivity(intent);
            }
        });



        RecyclerView recycler_rooms = findViewById(R.id.recycler_rooms);
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) new LinearLayoutManager(this);
        recycler_rooms.setLayoutManager(linearLayoutManager);

        recycler_rooms.setAdapter(new RoomsAdapter());

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


    private class RoomsAdapter extends RecyclerView.Adapter<RoomsAdapter.RoomsAdapterHolder> {

        //definir XML a usar para cada elemento
        @NonNull
        @Override
        public RoomsAdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new RoomsAdapterHolder(getLayoutInflater().inflate(R.layout.item_cat_field, parent, false));
        }   //parent= abrir en pantalla Root= false: No se abre en la raíz,, sino en la actividad

        //cada vez que necesite un elemento, llama a la posición imprimirrooms [por cada uno de los items de la lista]
        @Override
        public void onBindViewHolder(@NonNull RoomsAdapterHolder holder, int position) {
        holder.imprimirRooms(position);

        }

        //limite de la lista
        @Override
        public int getItemCount() {
            return rooms.length;
        }

        private class RoomsAdapterHolder extends RecyclerView.ViewHolder {
            ImageView imgCatField;
            TextView txvFieldName, txvFieldAddress, txvFieldCity, txvFieldPhone;


            public RoomsAdapterHolder(@NonNull View itemView) {
                super(itemView);

                imgCatField = itemView.findViewById(R.id.imgCatField);
                txvFieldName = itemView.findViewById(R.id.txvFieldName);
                txvFieldAddress = itemView.findViewById(R.id.txvFieldAddress);
                txvFieldCity = itemView.findViewById(R.id.txvFieldCity);
                txvFieldPhone = itemView.findViewById(R.id.txvFieldPhone);

            }

            public void imprimirRooms (int position) {
                imgCatField.setImageResource(imgRooms[position]);
                txvFieldName.setText(rooms[position]);
                txvFieldCity.setText(cityRoom[position]);
                txvFieldAddress.setText(addressRoom[position]);
                txvFieldPhone.setText(phoneRoom[position]);
            }
        }
    }
}