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

class BoysFragment : Fragment(),  NamesAdapter.Listener {

    var boys: ArrayList<User> = ArrayList()

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        return inflater.inflate(R.layout.fragment_boys, container, false)



    }

    fun fillBoys(){
        boys.add(User("Aidar", "17", "Android Developer"))
        boys.add(User("Elbrus", "30", "Android Developer"))
        boys.add(User("Eldos", "21", "Project Manager"))
        boys.add(User("Eldyar", "18", "Back End Developer"))
        boys.add(User("Dastan", "28", "Front End Developer"))
        boys.add(User("Taalai", "28", "Back End Developer"))
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.boysRecycler)
        fillBoys()
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = NamesAdapter(boys, this)

    }

    override fun onItemClick(names: User) {

        Toast.makeText(activity, names.name, Toast.LENGTH_LONG).show()

    }


}