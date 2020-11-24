package app.sunrin.bestbefore;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class NewActivity extends AppCompatActivity {
    String[][][] foods  = {
            {
                    //채소
                    {"대파", "10", "30"},
                    {"양파", "7", "0"},
                    {"가지", "5", "0"},
                    {"애호박", "6", "0"},
                    {"브로콜리", "7", "30"},
                    {"당근", "15", "0"},
                    {"양배추", "10", "0"},
                    {"오이", "7", "0"},
                    {"버섯", "5", "30"},
                    {"감자", "5", "0"},
                    {"마늘", "10", "0"},
                    {"시금치", "3", "0"},
                    {"고구마", "60", "0"},
                    {"고추", "30", "0"},
                    {"꺳잎", "90", "0"},
                    {"배추&양배추", "7", "0"},
                    {"도라지", "5", "0"},
                    {"버섯류", "6", "0"},
                    {"부추", "7", "45"},
                    {"상추", "3", "0"},
                    {"숙주나물", "4", "0"},
                    {"콩나물", "10", "0"},
                    {"방울토마토", "7", "30"},
                    {"파프리카&피망", "25", "0"},
                    {"호박", "30", "0"},
            },
            {
                    //과일
                    {"파인애플", "4", "0"},
                    {"참외", "5", "0"},
                    {"무화과", "4", "0"},
                    {"체리", "7", "0"},
                    {"복숭아", "4", "0"},
                    {"블루베리", "3", "10"},
                    {"아보카도", "4", "120"},
                    {"산딸기", "7", "0"},
                    {"자두", "4", "0"},
                    {"레몬", "21", "0"},
                    {"대추", "360", "0"},
                    {"사과", "20", "0"},
                    {"배", "6", "0"},
                    {"포도", "3", "0"},
                    {"복숭아", "4", "0"},
                    {"수박", "5", "0"},
                    {"바나나", "3", "20"}
            },
            {
                    //육류
                    {"소고기", "4", "180"},
                    {"돼지고기", "3", "150"},
                    {"닭고기", "2", "60"},
                    {"익힌고기", "2", "0"},
                    {"양고기", "7", "0"},
                    {"오리고기", "10", "30"},
                    {"소시지&햄", "60", "60"},
                    {"베이컨", "14", "240"},
                    {"달걀", "30", "0"},
            },
            {
                    //해산물
                    {"생선", "2", "90"},
                    {"조개", "2", "30"},
                    {"마른미역&다시마", "480", "0"},

            },
            {
                    //장&기름&조미료
                    {"고추가루", "360", "360"},
                    {"간장", "720", "0"},
                    {"고추장", "600", "0"},
                    {"된장", "720", "0"},
                    {"마늘", "15", "0"},
                    {"참기름", "360", "0"},
                    {"식용유", "720", "0"},
                    {"핫소스", "1080", "0"},
                    {"다대기", "21", "90"},

            },
            {
                    //냉동식품

                    {"냉동닭가슴살", "60", "270"},
            },
            {
                    //음료
                    {"물", "360", "0"},
                    {"식혜", "5", "360"},
                    {"탄산음료", "360", "360"},
                    {"맥주(CAN)", "360", "0"},
                    {"맥주(PET)", "180", "0"},
                    {"막걸리", "12", "0"},
                    {"전통주", "720", "0"},
                    {"과실주", "360", "0"},
                    {"이온음료", "360", "360"},
                    {"주스", "180", "180"},
                    {"탄산수", "360", "0"}
            },
            {
                    //기타
                    {"국&반찬", "30", "30"},
                    {"두부", "4", "0"},
                    {"견과류", "0", "1080"},
                    {"떡", "1", "30"},
                    {"빵", "3", "90"},
                    {"찹쌀가루", "0", "360"},
                    {"멸치젓", "360", "0"},
                    {"새우젓", "180", "0"},
                    {"조개젓", "180", "0"},
                    {"청란젓", "130", "0"}
            },
            {
                    //유제품
                    {"우유", "45", "0"},
                    {"치즈", "60", "70"},
                    {"버터", "210", "0"},
                    {"크림", "7", "0"},
                    {"연유", "180", "0"},
                    {"요거트&요구르트", "30", "0"},
            },

    };




    EditText editText;
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    RecyclerNewAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        recyclerView = findViewById(R.id.recyclerViewNew);
        editText = findViewById(R.id.editTextTextPersonName);
        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), 1));
        layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new RecyclerNewAdapter();
        recyclerView.setAdapter(adapter);
        SharedPreferences sharedPreferences = getSharedPreferences("food", 0);


        search();

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // 여기에 change되면 할 거 넣기
                search();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }


    public void search()
    {
        adapter = new RecyclerNewAdapter();
        recyclerView.setAdapter(adapter);
        String searchFood = editText.getText().toString();

        if(searchFood.equals(""))
        {
            for(int i = 0; i<foods.length; i++)
            {
                for(int j = 0; j<foods[i].length; j++)
                {

                        Data data = new Data();
                        data.setProductName(foods[i][j][0]);

                        switch (i)
                        {
                            case 0: data.setProductCategory("채소"); break;
                            case 1: data.setProductCategory("과일"); break;
                            case 2: data.setProductCategory("육류"); break;
                            case 3: data.setProductCategory("해산물"); break;
                            case 4: data.setProductCategory("장&기름&조미료"); break;
                            case 5: data.setProductCategory("냉동식품"); break;
                            case 6: data.setProductCategory("음료"); break;
                            case 7: data.setProductCategory("기타"); break;
                            case 8: data.setProductCategory("유제품"); break;


                        }
                        data.setProductDate(foods[i][j][1]);
                        adapter.addItem(data);


                }
            }
        }
        else
        {
            for(int i = 0; i<foods.length; i++)
            {
                for(int j = 0; j<foods[i].length; j++)
                {
                    if(foods[i][j][0].contains(searchFood))
                    {
                        Data data = new Data();
                        data.setProductName(foods[i][j][0]);
                        switch (i)
                        {
                            case 0: data.setProductCategory("채소"); break;
                            case 1: data.setProductCategory("과일"); break;
                            case 2: data.setProductCategory("육류"); break;
                            case 3: data.setProductCategory("해산물"); break;
                            case 4: data.setProductCategory("장&기름&조미료"); break;
                            case 5: data.setProductCategory("냉동식품"); break;
                            case 6: data.setProductCategory("음료"); break;
                            case 7: data.setProductCategory("기타"); break;
                            case 8: data.setProductCategory("유제품"); break;

                        }
                        data.setProductDate(foods[i][j][1]);
                        adapter.addItem(data);
                    }

                }
            }
        }
        adapter.notifyDataSetChanged();


    }
}


