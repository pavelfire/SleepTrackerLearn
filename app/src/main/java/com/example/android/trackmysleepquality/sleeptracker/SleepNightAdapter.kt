package com.example.android.trackmysleepquality.sleeptracker

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.trackmysleepquality.R
import com.example.android.trackmysleepquality.convertDurationToFormatted
import com.example.android.trackmysleepquality.convertNumericQualityToString
import com.example.android.trackmysleepquality.database.SleepNight
import com.example.android.trackmysleepquality.databinding.ListItemSleepNightBinding

// improve code
//https://developer.android.com/codelabs/kotlin-android-training-recyclerview-fundamentals?index=..%2F..android-kotlin-fundamentals#5

// 8:53 21.09.21
//https://developer.android.com/codelabs/kotlin-android-training-diffutil-databinding#4

//https://developer.android.com/codelabs/kotlin-android-training-diffutil-databinding#6
/*
class SleepNightAdapter: ListAdapter<SleepNight, SleepNightAdapter.ViewHolder>(SleepNightDiffCallback()) {
//old easy text view
//class SleepNightAdapter : RecyclerView.Adapter<TextItemViewHolder>() {

    */
/*var data = listOf<SleepNight>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }*//*


    // called when the RecyclerView needs a view holder.
    // This function takes two parameters and return a ViewHolder.
    // The -parent- parameter, which is the view group that holds the view holder,
    // is always the RecyclerView. The -viewType- parameter is used when there are multiple
    // views in the same RecyclerView. For example, if you put a list of text views, an
    // image, and a video all in the same RecyclerView, the onCreateViewHolder() function
    // would need to know what type of view to use.
    */
/*override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextItemViewHolder {

        // the layout inflater knows how to create views from XML layouts. The -context-
        // contains information on how to correctly inflate the view. In an adapter for
        // a recycler view, you always pass in the context of the -parent- view group,
        // which is the RecyclerView.
        val layoutInflater = LayoutInflater.from(parent.context)

        val view = layoutInflater
                .inflate(R.layout.text_item_view, parent, false) as TextView

        return TextItemViewHolder(view)

    }*//*

    override fun onCreateViewHolder(
            parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }


    // function called by RecyclerView to display the data for one list item at the
    // specified position. So the onBindViewHolder() method takes two arguments:
    // a view holder, and a position of the data to bind.
    // override fun onBindViewHolder(holder: TextItemViewHolder, position: Int) {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)

        // The ViewHolder you just created has a property called textView.
        // Inside onBindViewHolder(), set the text of the textView to the sleep-quality number.
        // This code displays only a list of numbers, but this simple example lets you
        // see how the adapter gets the data into the view holder and onto the screen.
        */
/*holder.textView.text = item.sleepQuality.toString()
        if(item.sleepQuality <=1) {
            holder.textView.setTextColor(Color.RED) //red
        } else {
            //reset
            holder.textView.setTextColor(Color.BLACK) //black
        }*//*



    }




    class ViewHolder private constructor(val binding: ListItemSleepNightBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(item: SleepNight) {
            binding.sleep = item

            // optimization that asks data binding to execute any pending right away
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding =
                        ListItemSleepNightBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }



}

class SleepNightDiffCallback : DiffUtil.ItemCallback<SleepNight>(){
    override fun areItemsTheSame(oldItem: SleepNight, newItem: SleepNight): Boolean {
        return oldItem.nightId == newItem.nightId
    }

    override fun areContentsTheSame(oldItem: SleepNight, newItem: SleepNight): Boolean {
        return oldItem == newItem
    }

}*/

class SleepNightAdapter : ListAdapter<SleepNight, SleepNightAdapter.ViewHolder>(SleepNightDiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(val binding: ListItemSleepNightBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(item: SleepNight) {
            binding.sleep = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ListItemSleepNightBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }
}


class SleepNightDiffCallback : DiffUtil.ItemCallback<SleepNight>() {

    override fun areItemsTheSame(oldItem: SleepNight, newItem: SleepNight): Boolean {
        return oldItem.nightId == newItem.nightId
    }


    override fun areContentsTheSame(oldItem: SleepNight, newItem: SleepNight): Boolean {
        return oldItem == newItem
    }


}
