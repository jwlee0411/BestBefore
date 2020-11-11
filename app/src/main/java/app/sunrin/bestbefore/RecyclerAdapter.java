package app.sunrin.bestbefore;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    ArrayList<FoodInformation> foodInformationBundle = new ArrayList<FoodInformation>();
    Context context;
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textCategory;
        TextView textName;
        TextView textDay;

        public ViewHolder(@NonNull View v){
            super(v);
            this.textCategory = v.findViewById(R.id.textCategory);
            this.textName = v.findViewById(R.id.textName);
            this.textDay = v.findViewById(R.id.textDay);
        }
    }

    public RecyclerAdapter(ArrayList<FoodInformation> foodInformationBundle){
        this.foodInformationBundle =foodInformationBundle;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        return new ViewHolder(inflater.inflate(R.layout.item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        FoodInformation foodInformation = this.foodInformationBundle.get(position);
        holder.textCategory.setText(foodInformation.category.get(0));
        holder.textName.setText(foodInformation.productName);
        holder.textDay.setText(foodInformation.dateLeft);
    }

    @Override
    public int getItemCount() {
        return this.foodInformationBundle.size();
    }
}
