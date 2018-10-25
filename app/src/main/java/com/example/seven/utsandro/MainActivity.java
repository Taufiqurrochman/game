package com.example.seven.utsandro;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter mAdapter;
    GameHelper gameHelper;
    Cursor cursor;

    public static MainActivity layarutama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampilan);

        layarutama = this;

        mRecyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(layoutManager);

        ArrayList<String> data = new ArrayList<>();
        dumy(data);

        mAdapter = new Adapter(data);
        mRecyclerView.setAdapter(mAdapter);
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

        return list;
    }

    private void dumy(ArrayList<String> data) {
    }
    }