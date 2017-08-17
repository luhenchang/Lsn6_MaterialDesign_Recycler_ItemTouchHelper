package com.example.ls.lsn6_materialdesign_recycler_itemtouchhelper.baseclass;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

/**
 * Created by ls on 2017/8/17.
 */

public class ItemTouchHelperCallBack extends ItemTouchHelper.Callback {
    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        int dragFlages = ItemTouchHelper.DOWN | ItemTouchHelper.UP;
        int swipFlags = 0;
        int flages = makeMovementFlags(dragFlages, swipFlags);
        return flages;
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        return true;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

    }

    @Override
    public boolean isLongPressDragEnabled() {
        return true;
    }
}
