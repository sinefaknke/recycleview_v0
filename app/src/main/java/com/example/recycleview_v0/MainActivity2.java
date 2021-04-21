package com.example.recycleview_v0;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycleview_v0.Object.Order;

import java.util.ArrayList;
import java.util.List;
import yujie_package.function.Other_Functions;

public class MainActivity2 extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<Order> listOrder ;
    private Button button2;
    private Other_Functions OF = new Other_Functions();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        initialization();
    }

    private void initialization() {
        Log.i("*","開始初始化...");
        listOrder = new ArrayList<>();
        loadData();

        Log.i("*","結束初始化...");
    };

    private void loadData(){
        for(int i = 0; i<10;i++){
            Order oo = new Order();
            oo.setorderTime(OF.getDate("yyyy/MM/dd", "GMT"));
            oo.setdeliveryTime(OF.getDate("yyyy/MM/dd", "GMT"));
            oo.setvegetableName("新項目");
            oo.setvegetableID(String.valueOf(i));
            oo.setnumber(String.valueOf(i)+"包");
            oo.setprice(String.valueOf(i*100)+"元");
            oo.setcustomerName("人員"+String.valueOf(i));
            oo.setcustomerPhoneNumber("0915833602");
            oo.setremark("竹筍大小不拘");
            listOrder.add(oo);
        }
        setView(listOrder);
    }

    private void setView(List<Order> listOrder){
        Log.i("*","開始設定介面...");
        recyclerView = findViewById(R.id.recyclerView);
        button2 = findViewById(R.id.button2);

        // 如果您知道內容的更改不會更改RecyclerView的佈局大小，請使用此設置來提高性能
        recyclerView.setHasFixedSize(true);
        // 設定RecyclerView的排序種類
        layoutManager = new LinearLayoutManager(this); // LinearLayoutManager 將各項內容排列在一維列表中
        //layoutManager = new GridLayoutManager(this); // GridLayoutManager 將各項內容排列在二維網格中，就像棋盤上的方格一樣
        //layoutManager = new StaggeredGridLayoutManager(this); //StaggeredGridLayoutManager 將各項內容排列在二維網格中，每一列都在前一列基礎上稍微偏移
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        mAdapter = new RecyclerViewAdapter(this,listOrder);

        recyclerView.setAdapter(mAdapter);
//        button2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mAdapter.addItem();
//            }
//        });
    }
}