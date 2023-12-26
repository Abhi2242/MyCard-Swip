package com.smartgeek.gdseventapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.smartgeek.gdseventapp.databinding.ActivityConnectFragmentBinding

@Suppress("DEPRECATION")
class ConnectFragment : Fragment() {

    private lateinit var bindingConnect: ActivityConnectFragmentBinding
    val acceptedProfile: MutableList<Profile> = ArrayList()

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bindingConnect = ActivityConnectFragmentBinding.inflate(inflater, container, false)

        val profileLists = ArrayList<Profile>()
        profileLists.add(
            Profile(
                1, R.drawable.gen_logo, "Milind Prabhu",
                "Genora Infotech", "CEO & MD", "_"
            )
        )

        profileLists.add(
            Profile(
                2, R.drawable.gen_logo, "Abhishek Vengurlekar",
                "Genora Infotech", "Trainee Android Developer", "_"
            )
        )

        profileLists.add(
            Profile(
                3, R.drawable.gen_logo, "Aditya Hiranwale",
                "Genora Infotech", "Flutter Developer", "_"
            )
        )

        profileLists.add(
            Profile(
                4, R.drawable.gen_logo, "Sweta",
                "Genora Infotech", "Software Engineer", "_"
            )
        )

        val adaptor = ConnectAdapter(profileLists)


        // Here is swipe gesture code
        val swipeGesture = object : SwipeGesture(bindingConnect.root.context) {

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {

                when (direction) {
                    ItemTouchHelper.LEFT -> {
                        Toast.makeText(bindingConnect.root.context, "Rejected", Toast.LENGTH_SHORT)
                            .show()
                        adaptor.deleteItem(viewHolder.adapterPosition)
                    }

                    ItemTouchHelper.RIGHT -> {
                        //  here I'm adding accepted /right swiped profile to new list
                        val acceptedProfileList = profileLists[viewHolder.adapterPosition]
                        acceptedProfile.add(acceptedProfile.size, acceptedProfileList)

                        Toast.makeText(
                            bindingConnect.root.context,
                            "Accepted $acceptedProfile",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                        adaptor.deleteItem(viewHolder.adapterPosition)
                    }
                }
            }
        }

        val touchHelper = ItemTouchHelper(swipeGesture)
        touchHelper.attachToRecyclerView(bindingConnect.rcvConnectProfile)
        // end of swipe gesture code


        bindingConnect.apply {
            rcvConnectProfile.adapter = adaptor
            rcvConnectProfile.isNestedScrollingEnabled = false
            rcvConnectProfile.isFocusable = false
        }

        return bindingConnect.root
    }
}