package com.example.ls.lsn6_materialdesign_recycler_itemtouchhelper.baseclass;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.example.ls.lsn6_materialdesign_recycler_itemtouchhelper.moveItemLisener.OnMoveItemLisenner;

/**
 * Created by ls on 2017/8/17.
 */

public class ItemTouchHelperCallBack extends ItemTouchHelper.Callback {
    private OnMoveItemLisenner onMoveItemLisenner;

    public ItemTouchHelperCallBack(OnMoveItemLisenner onMoveItemLisenner) {
        this.onMoveItemLisenner = onMoveItemLisenner;
    }

    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        int dragFlages = ItemTouchHelper.DOWN | ItemTouchHelper.UP;
        int swipFlags = 0;
        int flages = makeMovementFlags(dragFlages, swipFlags);
        return flages;
    }

    //拖拽
    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        if(viewHolder.getItemViewType()==target.getItemViewType()){
            int startPosition = viewHolder.getAdapterPosition();
            int endPosition = target.getAdapterPosition();
            boolean moveflag=onMoveItemLisenner.onMoveItemLisenner(startPosition,endPosition);
            if(moveflag){
                return true;
            }else {
                return false;
            }
        }else{
          return false;
        }


    }

    //侧滑
    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

    }

    @Override
    public boolean isLongPressDragEnabled() {
        return true;
    }
}
