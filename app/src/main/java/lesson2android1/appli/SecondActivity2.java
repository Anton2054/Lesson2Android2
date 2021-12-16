package lesson2android1.appli;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;

public class SecondActivity2<convertView> extends AppCompatActivity implements View.OnClickListener {
    ImageView inImage2;
    EditText et_title2;
    Button btnOpenSecondActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2);
        inImage2 = findViewById(R.id.in_image2);
        et_title2 = findViewById(R.id.et_title2);
        btnOpenSecondActivity = findViewById(R.id.btn_Open_Second_Activity);
        btnOpenSecondActivity.setOnClickListener(this);
        inImage2.setOnClickListener(this);


        btnOpenSecondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inImage2.setDrawingCacheEnabled(true);
                Bitmap b=inImage2.getDrawingCache();
                Intent intent1 = new Intent(SecondActivity2.this,MainActivity .class);

                intent1.putExtra("image", b);
                startActivity(intent1);
            }
        });


        inImage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultLauncher.launch("image/*");
            }


        });
    }

    ActivityResultLauncher<String> resultLauncher = registerForActivityResult(
            new ActivityResultContracts.GetContent(),
            new ActivityResultCallback<Uri>() {
                @Override
                public void onActivityResult(Uri uri) {

                    inImage2.setImageURI(uri);

                }
            });


    public void onClick(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("Text", et_title2.getText().toString());
        startActivity(intent);


    }


}











