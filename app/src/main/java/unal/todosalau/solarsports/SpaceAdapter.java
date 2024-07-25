package unal.todosalau.solarsports;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Space;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SpaceAdapter  extends RecyclerView.Adapter<SpaceAdapter.SpaceHolder>{

    List<SportSpace> spaceList;
    int layout;
    Activity activity;

    //generar el constructor


    public SpaceAdapter(List<SportSpace> spaceList, int layout, Activity activity) {
        this.spaceList = spaceList;
        this.layout = layout;
        this.activity = activity;
    }

    @NonNull
    @Override
    public SpaceHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);

        return new SpaceHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SpaceHolder holder, int position) {
        SportSpace sportSpace = spaceList.get(position);
        holder.imgCatField.setImageResource(sportSpace.getImg());
        holder.txvFieldName.setText(sportSpace.getName());
        holder.txvFieldAddress.setText("Dirección : " + sportSpace.getAddress());
        holder.txvFieldCity.setText("Ciudad : " + sportSpace.getCity());
        holder.txvFieldPhone.setText("Teléfono : " + sportSpace.getPhone());
        holder.txvFieldPower.setText("Potencia Instalada : " + String.valueOf(sportSpace.getPower() + " Watts"));
        holder.txvEnergyGenerat.setText(String.valueOf(sportSpace.getGenerated() + " Watts"));
        holder.txvEnergyConsum.setText(String.valueOf(sportSpace.getConsumed() + " Watts"));

    }

    @Override
    public int getItemCount() {
        return spaceList.size();
    }


    public class SpaceHolder extends RecyclerView.ViewHolder{

        ImageView imgCatField;
        TextView txvFieldName, txvFieldAddress, txvFieldCity, txvFieldPhone, txvFieldPower,
                 txvEnergyGenerat, txvEnergyConsum;

        public SpaceHolder(@NonNull View itemView) {
            super(itemView);
            imgCatField = itemView.findViewById(R.id.imgCatField);
            txvFieldName = itemView.findViewById(R.id.txvFieldName);
            txvFieldAddress = itemView.findViewById(R.id.txvFieldAddress);
            txvFieldCity = itemView.findViewById(R.id.txvFieldCity);
            txvFieldPhone = itemView.findViewById(R.id.txvFieldPhone);
            txvFieldPower = itemView.findViewById(R.id.txvFieldPower);
            txvEnergyGenerat = itemView.findViewById(R.id.txvEnergyGenerat);
            txvEnergyConsum = itemView.findViewById(R.id.txvEnergyConsum);

        }


    }

}
