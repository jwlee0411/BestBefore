package app.sunrin.bestbefore;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainFragment extends Fragment {

    String[][] foods;

    RecyclerView recyclerView;
    RecyclerMainAdapter adapter;
    LinearLayoutManager layoutManager;
    FloatingActionButton floatingActionButton;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        //recyclerView 관련 코드
        recyclerView = root.findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), 1));
        adapter = new RecyclerMainAdapter();
        recyclerView.setAdapter(adapter);

        ConstraintLayout constraintLayout = root.findViewById(R.id.layout_main);

        foods = new String[][]{};
        if(foods.length == 0)
        {
            constraintLayout.setBackground(ContextCompat.getDrawable(root.getContext(), R.drawable.ic_dashboard_black_24dp));
        }
        else
        {

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

        adapter.notifyDataSetChanged();


        floatingActionButton = root.findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), NewActivity.class);
            startActivity(intent);
        });


        return root;
    }

}