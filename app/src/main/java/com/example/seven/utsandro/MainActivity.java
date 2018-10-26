package com.example.seven.utsandro;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager layoutManager;
    Adapter mAdapter;
    GameHelper gameHelper;
    List<Game> games = new ArrayList<>();
    Cursor cursor;
    Button btnTambah, btnLogout;

    public static MainActivity layarutama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampilan);

        layarutama = this;
        btnTambah = findViewById(R.id.btnTambah);
        btnLogout = findViewById(R.id.logout);
        mRecyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(layoutManager);


        mAdapter = new Adapter(this, gameList());
        mRecyclerView.setAdapter(mAdapter);

        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), InsertGame.class);
                startActivity(i);
            }
        });

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp = getPreferences(Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();


                editor.clear();
                editor.remove("username");
                editor.remove("password");
                editor.commit();
                editor.apply();

                Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(i);

            }
        });

    }

    public List<Game> gameList(){
        gameHelper = new GameHelper(this);
        SQLiteDatabase db = gameHelper.getReadableDatabase();
        List<Game> list = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM game",null);

        if (cursor.getCount()>0){
            for (int i = 0; i < cursor.getCount(); i++) {
                cursor.moveToPosition(i);
                Game s = new Game(cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4)
                );
                list.add(s);
            }
        }
        mAdapter = new Adapter(this,list);
        mRecyclerView.setAdapter(mAdapter);

        return list;
    }



    }