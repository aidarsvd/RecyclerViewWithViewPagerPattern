package ru.test.worktest.fragments.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.test.worktest.R
import ru.test.worktest.models.User
import java.util.*



class NamesAdapter(var list : ArrayList<User>, var listener: Listener) : RecyclerView.Adapter<NamesAdapter.NamesViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NamesViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.name_item, parent, false)

        return NamesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: NamesViewHolder, position: Int) {
        holder.onBind(list[position], listener)

    }


    class NamesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var name = itemView.findViewById(R.id.name) as TextView
        var speciality = itemView.findViewById(R.id.speciality) as TextView
        var age = itemView.findViewById(R.id.age) as TextView


        fun onBind(names: User, listener: Listener) {
            name.text = names.name
            speciality.text = names.speciality
            age.text = names.age


            itemView.setOnClickListener{
                listener.onItemClick(names)
            }

        }




    }

    interface Listener {
        fun onItemClick(names: User)


    }


}



