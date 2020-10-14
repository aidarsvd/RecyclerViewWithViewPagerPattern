package ru.test.worktest.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.test.worktest.R
import ru.test.worktest.fragments.adapter.NamesAdapter
import ru.test.worktest.models.User
import java.util.ArrayList

class GirlsFragment : Fragment(),  NamesAdapter.Listener {
    var girls: ArrayList<User> = ArrayList()
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {




        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_girls, container, false)
    }


    fun fillGirls(){
        girls.add(User("Aimeerim", "17", "Android Developer"))
        girls.add(User("Altynai", "17", "Android Developer"))

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.girlsRecycler)
        fillGirls()
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = NamesAdapter(girls, this)

    }

    override fun onItemClick(names: User) {

        Toast.makeText(activity, names.name, Toast.LENGTH_LONG).show()

    }




}