package com.example.ls.lsn6_materialdesign_recycler_itemtouchhelper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.example.ls.lsn6_materialdesign_recycler_itemtouchhelper.baseclass.DataUtils;
import com.example.ls.lsn6_materialdesign_recycler_itemtouchhelper.baseclass.ItemTouchHelperCallBack;
import com.example.ls.lsn6_materialdesign_recycler_itemtouchhelper.baseclass.QQAdapter;
import com.example.ls.lsn6_materialdesign_recycler_itemtouchhelper.baseclass.QQMessage;
import com.example.ls.lsn6_materialdesign_recycler_itemtouchhelper.baseclass.StartDragListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements StartDragListener {
    private RecyclerView mRecylerView;
    private List<QQMessage>mData;
    private QQAdapter mAdapter;
    private ItemTouchHelper itemTouchHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        setData();
    }

    private void setData() {
        mRecylerView.setAdapter(mAdapter);
        mRecylerView.setLayoutManager(new LinearLayoutManager(this));
        itemTouchHelper=new ItemTouchHelper(new ItemTouchHelperCallBack(mAdapter));
        itemTouchHelper.attachToRecyclerView(mRecylerView);
    }

    private void initData() {
        mAdapter=new QQAdapter(mData,this);
        mData.addAll(DataUtils.init());
        mAdapter.notifyDataSetChanged();

    }

    private void initView() {
        mRecylerView= (RecyclerView) findViewById(R.id.recyclerview);
        mData=new ArrayList<>();

    }

    @Override
    public void StartDragListener(RecyclerView.ViewHolder viewHolder) {
        itemTouchHelper.startDrag(viewHolder);

    }
}
