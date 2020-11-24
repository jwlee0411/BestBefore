package app.sunrin.bestbefore;


import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

public class RecyclerNewAdapter extends RecyclerView.Adapter<RecyclerNewAdapter.ItemViewHolder> {

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
    public void onBindViewHolder(@NonNull RecyclerNewAdapter.ItemViewHolder holder, int position) {
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
        TextView textRegisterDate;


        ItemViewHolder(View itemView) {
            super(itemView);

             constraintLayout = itemView.findViewById(R.id.MainRecyclerItem);
                textName = itemView.findViewById(R.id.textName);
                textCategory = itemView.findViewById(R.id.textCategory);
                textDate = itemView.findViewById(R.id.textDate);
                textRegisterDate = itemView.findViewById(R.id.debug);



        }

        void onBind(Data data) {

            textName.setText(data.getProductName());
            textCategory.setText(data.getProductCategory());
            textDate.setText(data.getProductDate());
            textRegisterDate.setText(data.getProductRegisterDate());

            constraintLayout.setOnClickListener(v -> {
                //여기에 등록 관련 내용 추가하기
//
//                FirebaseDatabase database = FirebaseDatabase.getInstance();
//                DatabaseReference myRef = database.getReference(data.getProductName());
//                myRef.setValue(System.currentTimeMillis()/1000);


                FirebaseDatabase database = FirebaseDatabase.getInstance();
                 DatabaseReference myRef = database.getReference(String.valueOf(System.currentTimeMillis()));
                 myRef.setValue(data.getProductName() + "@" + data.getProductCategory() + "@" + (Integer.parseInt(String.valueOf(System.currentTimeMillis()/1000)) + Integer.parseInt(data.getProductDate())*60*60*24));
                data.setProductRegisterDate(String.valueOf(System.currentTimeMillis()));

                Intent intent = new Intent(v.getContext(), MainActivity.class);
              //  ArrayList<String> arrayList = new ArrayList<String>();
              //  arrayList.add(textName.getText().toString());
               // intent.putExtra("category", arrayList);
                intent.putExtra("category", data.getProductCategory());
                intent.putExtra("name", data.getProductName());
                intent.putExtra("date", data.getProductDate());


              //  intent.putExtra("debug", "debug string");

                v.getContext().startActivity(intent);

               Toast.makeText(v.getContext(), "등록되었습니다.", Toast.LENGTH_LONG).show();
            });

        }
    }
}
