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
                //View를 클릭했을 때 관련된 화면이 나오게 하려면
               // Intent intent = new Intent(v.getContext(), FoodInformation.class);
                //name, category, date 정보를 보내주고
             //   intent.putExtra("foodName", data.getProductName());
            //    intent.putExtra("foodCategory", data.getProductCategory());
            //    intent.putExtra("foodDate", data.getProductDate());
                //activity를 시작함.
              //  v.getContext().startActivity(intent);


                //걍 화면 없이 데이터를 바로 지우려면
                //이 Toast를 띄워주는 걸로
              //  Toast.makeText(v.getContext(), "삭제하려면 길게 눌러주세요.", Toast.LENGTH_LONG).show();
            });
            constraintLayout.setOnLongClickListener(v -> {
                //여기에 삭제 관련 내용 추가하기
               // Toast.makeText(v.getContext(), "삭제되었습니다.", Toast.LENGTH_LONG).show();

                return true;
            });

        }
    }
}
