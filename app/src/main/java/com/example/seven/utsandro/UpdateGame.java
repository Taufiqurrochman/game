package com.example.seven.utsandro;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class UpdateGame extends AppCompatActivity {

    protected Cursor cursor;
    GameHelper dbHelper;
    Button btn1,btn2;
    TextView text3, text4, text5, text6;
    String textID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_game);

        dbHelper = new GameHelper(this);
        text3 = findViewById(R.id.editText3);
        text4 = findViewById(R.id.editText4);
        text5 = findViewById(R.id.editText5);
        text6 = findViewById(R.id.editText6);

        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM game WHERE id = "
                +getIntent().getIntExtra("id",0),null);
        cursor.moveToFirst();

        if (cursor.getCount()>0)
        {
            cursor.moveToPosition(0);
            textID = cursor.getString(0);
            text3.setText(cursor.getString(1));
            text4.setText(cursor.getString(2));
            text5.setText(cursor.getString(3));
            text6.setText(cursor.getString(4));

        }

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("UPDATE game SET nama='"+text3.getText().toString()+"'," +
                        "genre='"+text4.getText().toString()+"'," +
                        "rating='"+text5.getText().toString()+"'," +
                        "developer='"+text6.getText().toString()+"' WHERE id ="+Integer.parseInt(textID)+"");
                Toast.makeText(getApplicationContext(), "berhasil dirubah",
                        Toast.LENGTH_LONG).show();
                MainActivity.layarutama.gameList();
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                finish();
            }
        });
    }
}
