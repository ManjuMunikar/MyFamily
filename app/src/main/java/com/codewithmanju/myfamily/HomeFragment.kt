package com.codewithmanju.myfamily

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class HomeFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listMembers = listOf<MemberModel>(
            MemberModel(
                "Shyam",
                "9th building, 2nd floor",
                "90%",
                "220"
            ),
            MemberModel(
                "Raju",
                "10th building, 3rd floor, Kalopul road, 3rd floor",
                "80%",
                "210"
            ),
            MemberModel(
                "Nanu",
                "11th building, 4th floor, Ratopul road, 4th floor",
                "70%",
                "200"
            ),
            MemberModel(
                "Sanju",
                "12th building, 5th floor, Gyaneshwor road, 5th floor",
                "60%",
                "190"
            ),
        )


        val adapter= MemberAdapter(listMembers)

        val recycler= requireView().findViewById<RecyclerView>(R.id.recycler_member)
        recycler.layoutManager= LinearLayoutManager(requireContext())
        recycler.adapter= adapter


    }

    companion object {

        @JvmStatic
        fun newInstance() = HomeFragment()
    }
}