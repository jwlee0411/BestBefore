package app.sunrin.bestbefore;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainFragment extends Fragment {

    String[][] foods;
    ArrayList<FoodInformation> foodInformationArrayList = new ArrayList<FoodInformation>();
    RecyclerView recyclerView;
    RecyclerMainAdapter adapter;
    LinearLayoutManager layoutManager;
    FloatingActionButton floatingActionButton;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        foods = new String[][]{};

        Intent intent = getActivity().getIntent();
        if(intent.getExtras()!=null)
        {
           // String getIntent = intent.getExtras().getStringArrayList("category").toString();
            Toast.makeText(getContext(), intent.getExtras().getString("debug"), Toast.LENGTH_LONG).show();
            System.out.println(intent.getExtras().getString("name"));
            System.out.println(intent.getExtras().getString("date"));
        }

//        foodInformationArrayList.add(
//                new FoodInformation(
//                    intent.getExtras().getStringArrayList("category"),
//                    intent.getExtras().getString("name"),
//                    intent.getExtras().getInt("date")
//                )
//            );

        //recyclerView 관련 코드
        recyclerView = root.findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), 1));
        adapter = new RecyclerMainAdapter();
        recyclerView.setAdapter(adapter);

        ConstraintLayout constraintLayout = root.findViewById(R.id.layout_main);


        if(foods.length == 0)
        {
            constraintLayout.setBackground(ContextCompat.getDrawable(root.getContext(), R.drawable.ic_dashboard_black_24dp));
        }
        else
        {
            adapter.notifyDataSetChanged();
        }



        for(int i = 0; i<foods.length; i++)
        {
            for(int j = 0; j<foods[i].length; j++)
            {
                /*
                Data data = new Data();
                data.setProductName(foods[i][j][0]);
                data.setProductCategory("그럴듯한 카테고리");
                data.setProductDate(foods[i][j][1]); // 추후 수정 필요
                adapter.addItem(data);
                 */
            }
        }




        floatingActionButton = root.findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(v -> {
            Intent intent1 = new Intent(getActivity(), NewActivity.class);
            startActivity(intent1);
        });


        return root;
    }

}