package app.sunrin.bestbefore;


import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerMainAdapter extends RecyclerView.Adapter<RecyclerMainAdapter.ItemViewHolder> {

    private ArrayList<Data> listData = new ArrayList<>();


    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // LayoutInflater를 이용하여 전 단계에서 만들었던 item.xml을 inflate 시킵니다.
        // return 인자는 ViewHolder 입니다.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerMainAdapter.ItemViewHolder holder, int position) {
        // Item을 하나, 하나 보여주는(bind 되는) 함수입니다.
        holder.onBind(listData.get(position));
    }

    @Override
    public int getItemCount() {
        // RecyclerView의 총 개수 입니다.
        return listData.size();
    }

    void addItem(Data data) {
        // 외부에서 item을 추가시킬 함수입니다.
        listData.add(data);
    }


    class ItemViewHolder extends RecyclerView.ViewHolder {

        ConstraintLayout constraintLayout;
        TextView textName;
        TextView textCategory;
        TextView textDate;


        ItemViewHolder(View itemView) {
            super(itemView);

             constraintLayout = itemView.findViewById(R.id.MainRecyclerItem);
                textName = itemView.findViewById(R.id.textName);
                textCategory = itemView.findViewById(R.id.textCategory);
                textDate = itemView.findViewById(R.id.textDate);



        }

        void onBind(Data data) {

            textName.setText(data.getProductName());
            textCategory.setText(data.getProductCategory());
            textDate.setText(data.getProductDate());

            constraintLayout.setOnClickListener(v -> {
                Intent intent = new Intent(v.getContext(), MainActivity.class);
                v.getContext().startActivity(intent);
                Toast.makeText(v.getContext(), "등록되었습니다.", Toast.LENGTH_LONG).show();
            });

        }
    }
}
