package com.ruichaoqun.jetpackstudyapplication

import android.graphics.Color
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 *
 * @Author:         芮超群
 * @CreateDate:     2020/12/25 18:27
 * @Description:    TestAdapter
 * @Version:        1.0
 */
class TestAdapter : RecyclerView.Adapter<Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        Log.w("AAAAAA","onCreateViewHolder")
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_test,null)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return 2000
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        Log.w("AAAAAA","onBindViewHolder")
        holder.text1.text = "$position"
        if(position % 2 == 0){
            holder.itemView.setBackgroundColor(Color.parseColor("#FF4444"))
        }else{
            holder.itemView.setBackgroundColor(Color.parseColor("#4444FF"))
        }
    }

}

class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var text1:TextView = itemView.findViewById(R.id.text1)
    var text2:TextView = itemView.findViewById(R.id.text2)
}