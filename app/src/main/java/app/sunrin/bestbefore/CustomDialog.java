package app.sunrin.bestbefore;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CustomDialog extends Dialog {


    private Button mPositiveButton;
    private Button mNegativeButton;



    public CustomDialog(@NonNull Context context) {
        super(context);

    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //다이얼로그 밖의 화면은 흐리게 만들어줌
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        layoutParams.dimAmount = 0.8f;
        getWindow().setAttributes(layoutParams);

        setContentView(R.layout.dialog);


        mPositiveButton=findViewById(R.id.buttonOK);
        mNegativeButton=findViewById(R.id.buttonCancel);


        mPositiveButton.setOnClickListener(mPositiveListener);
        mNegativeButton.setOnClickListener(mNegativeListener);



    }

    private View.OnClickListener mPositiveListener = v -> {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference(String.valueOf(System.currentTimeMillis()));
        EditText editName = findViewById(R.id.editName);
        EditText editCategory = findViewById(R.id.editCategory);
        EditText editDate = findViewById(R.id.editDate);

        if(editDate.getText().toString().equals("") || editName.getText().toString().equals("") || editCategory.getText().toString().equals(""))
        {
            Toast.makeText(v.getContext(), "입력되지 않은 값이 있습니다.", Toast.LENGTH_LONG).show();
        }
        else if(editDate.getText().toString().length() > 4)
        {
            Toast.makeText(v.getContext(), "저장할 수 없는 값입니다.", Toast.LENGTH_LONG).show();
        }
        else
        {
            myRef.setValue(editName.getText().toString() + "@" + editCategory.getText().toString() + "@" + (Integer.parseInt(String.valueOf(System.currentTimeMillis()/1000)) + Integer.parseInt(editDate.getText().toString())*60*60*24));





            Intent intent = new Intent(v.getContext(), MainActivity.class);
            //  ArrayList<String> arrayList = new ArrayList<String>();
            //  arrayList.add(textName.getText().toString());
            // intent.putExtra("category", arrayList);
            intent.putExtra("category", editCategory.getText().toString());
            intent.putExtra("name", editName.getText().toString());
            intent.putExtra("date", editDate.getText().toString());


            //  intent.putExtra("debug", "debug string");
            dismiss();
            Toast.makeText(v.getContext(), "등록되었습니다.", Toast.LENGTH_LONG).show();
            v.getContext().startActivity(intent);
        }



        // finish();


    };

    private View.OnClickListener mNegativeListener = v -> {
        dismiss();



    };

}
