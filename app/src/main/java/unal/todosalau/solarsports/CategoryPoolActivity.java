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

public class CategoryPoolActivity extends AppCompatActivity {

    String [] pools = {"Complejo:Simón Bolivar",
                "Piscinas : Compensar",
            "Piscinas : Alberto Galindo",
            "Piscinas : Villa del Rio",
            "Complejo: Vida"};

    String [] addressPool = {"Calle 98 No. 100-20",
            "Calle 139 No. 94-00",
            "avenida pasoancho 100-15",
            "autopista sur No. 120-00",
            "Avenida Libertadores NO. 76-00"};

    String [] cityPool = {"Bogotá", "Bogota", "Cali","Bogota", "Santa Marta"};
    String [] phonePool = {"3118866044","312433244","3125678844","3002345644","3103211244"};
    int [] imgPools = {R.drawable.pool_simon, R.drawable.pool_compensar,R.drawable.pool_alberto,R.drawable.pool_villario, R.drawable.pool_vida};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_pool);

        //buscar toolbar y configurar
        Toolbar tbarCatPool = findViewById(R.id.tbarCatPool);
        setSupportActionBar(tbarCatPool);
        //Habilitar retorno en Toolbar
        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }


        Button btnAddPool = findViewById(R.id.btnAddPool);
        btnAddPool.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RegisterPoolActivity.class);
                startActivity(intent);
            }
        });

        TextView txvPoolCampos = findViewById(R.id.txvPoolCampos);
        txvPoolCampos.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CategoryFieldActivity.class);
                startActivity(intent);
            }
        });

        TextView txvPoolCanchas = findViewById(R.id.txvPoolCanchas);
        txvPoolCanchas.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CategoryCourtActivity.class);
                startActivity(intent);
            }
        });

        TextView txvPoolSalas = findViewById(R.id.txvPoolSalas);
        txvPoolSalas.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CategoryRoomActivity.class);
                startActivity(intent);
            }
        });

        TextView txvPoolPiscinas = findViewById(R.id.txvPoolPiscinas);
        txvPoolPiscinas.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CategoryPoolActivity.class);
                startActivity(intent);
            }
        });

        RecyclerView recycler_pools = findViewById(R.id.recycler_pools);
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) new LinearLayoutManager(this);
        recycler_pools.setLayoutManager(linearLayoutManager);

        recycler_pools.setAdapter(new PoolsAdapter());

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


    private class PoolsAdapter extends RecyclerView.Adapter<PoolsAdapter.PoolsAdapterHolder> {

        @NonNull
        @Override
        public PoolsAdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new PoolsAdapterHolder(getLayoutInflater().inflate(R.layout.item_cat_field, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull PoolsAdapterHolder holder, int position) {
            holder.imprimirPools(position);

        }

        @Override
        public int getItemCount() {
            return pools.length;
        }

        private class PoolsAdapterHolder extends RecyclerView.ViewHolder{

            ImageView imgCatField;
            TextView txvFieldName, txvFieldAddress, txvFieldCity, txvFieldPhone;
            Button btnFieldSee;

            public PoolsAdapterHolder(@NonNull View itemView) {
                super(itemView);

                imgCatField = itemView.findViewById(R.id.imgCatField);
                txvFieldName = itemView.findViewById(R.id.txvFieldName);
                txvFieldAddress = itemView.findViewById(R.id.txvFieldAddress);
                txvFieldCity = itemView.findViewById(R.id.txvFieldCity);
                txvFieldPhone = itemView.findViewById(R.id.txvFieldPhone);
                btnFieldSee = itemView.findViewById(R.id.btnFieldSee);
            }

            public void imprimirPools (int position){
                imgCatField.setImageResource(imgPools[position]);
                txvFieldName.setText(pools[position]);
                txvFieldCity.setText(cityPool[position]);
                txvFieldAddress.setText(addressPool[position]);
                txvFieldPhone.setText(phonePool[position]);

            }

        }
    }
}