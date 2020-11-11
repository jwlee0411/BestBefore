package app.sunrin.bestbefore;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainFragment extends Fragment {


    RecyclerView recyclerView;
    RecyclerAdapter adapter;
    RecyclerView.LayoutManager layoutManager;

    ArrayList<FoodInformation> foodInformationBundle = new ArrayList<FoodInformation>();
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        recyclerView = root.findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(this.layoutManager);
        adapter = new RecyclerAdapter(this.foodInformationBundle);
        recyclerView.setAdapter(this.adapter);
        return root;
    }
    public void floatingActionButton_Click(View v){
        ArrayList<String> asd = new ArrayList<String>();
        asd.add("사과 톡톡톡");
        this.foodInformationBundle.add(new FoodInformation(asd, "맛있다사과", 10));
    }
}