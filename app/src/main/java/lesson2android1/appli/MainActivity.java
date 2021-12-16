package lesson2android1.appli;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity {
    ImageView inImage;
    Button btnAdd;
    TextView tvText;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inImage = findViewById(R.id.in_image);
        btnAdd = findViewById(R.id.btn_add);
        tvText = findViewById(R.id.tv_text);
        Intent intent = getIntent();
        String Text = intent.getStringExtra("Text");
        tvText.setText(Text);

        Bitmap bitmap = (Bitmap) intent.getParcelableExtra("image");
        inImage.setImageBitmap(bitmap);



        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SecondActivity2 .class);
                startActivity(intent);

            }
        });
    }
}