package com.smartgeek.gdseventapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.smartgeek.gdseventapp.databinding.ActivityInviteFragmentBinding

@Suppress("DEPRECATION")
class InviteFragment : Fragment() {

    private lateinit var bindingInvite: ActivityInviteFragmentBinding
    private lateinit var inviteList: List<Profile>

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        bindingInvite = ActivityInviteFragmentBinding.inflate(inflater, container, false)
        inviteList = ArrayList()
        inviteList = inviteList + Profile(
            1, R.drawable.gen_logo, "Milind Prabhu",
            "Genora Infotech", "CEO & MD", "_"
        )

        inviteList = inviteList + Profile(
            2, R.drawable.abhishek_profile_pic, "Abhishek Vengurlekar",
            "Genora Infotech", "Trainee Android Developer", "_"
        )

        inviteList = inviteList + Profile(
            3, R.drawable.gen_logo, "Aditya Hiranwale",
            "Genora Infotech", "Flutter Developer", "_"
        )

        inviteList = inviteList + Profile(
            4, R.drawable.gen_logo, "Sweta",
            "Genora Infotech", "Software Engineer", "_"
        )

        val adapter = InviteAdapter(inviteList)
        bindingInvite.apply {
            gridProfile.adapter = adapter
        }

        return bindingInvite.root
//        return inflater.inflate(R.layout.custom_card_view, container, false)
    }
}




//        // Here is swipe gesture code
//        val swipeGesture = object : SwipeGesture(bindingInvite.root.context) {
//
//            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
//
//                when (direction) {
//                    ItemTouchHelper.LEFT -> {
//                        Toast.makeText(bindingInvite.root.context, "Rejected", Toast.LENGTH_SHORT)
//                            .show()
//                        adaptor.deleteItem(viewHolder.adapterPosition)
//                        if (profileLists.size == 0) {
//                            tv_invite_number.text = "No invites"
//                            tv_invite_info.text = " "
//                        } else {
//                            tv_invite_number.text = "${profileLists.size} Invite"
//                        }
//                    }
//
//                    ItemTouchHelper.RIGHT -> {
//                        //  here I'm adding accepted /right swiped profile to new list
//                        val acceptedProfileList = profileLists[viewHolder.adapterPosition]
//                        acceptedProfile.add(acceptedProfile.size, acceptedProfileList)
//
//                        Toast.makeText(
//                            bindingInvite.root.context,
//                            "Accepted $acceptedProfile",
//                            Toast.LENGTH_SHORT
//                        )
//                            .show()
//                        adaptor.deleteItem(viewHolder.adapterPosition)
//                        if (profileLists.size == 0) {
//                            tv_invite_number.text = "No invites"
//                            tv_invite_info.text = " "
//
//                            val bundle = Bundle()
//                            bundle.putString(
//                                "profile",
//                                acceptedProfile.toString()
//                            ) // Put anything what you want
//
//                            val fragment = ChatsFragment()
//                            fragment.arguments = bundle
//                        } else {
//                            tv_invite_number.text = "${profileLists.size} Invite"
//                        }
//                    }
//                }
//            }
//        }
//
//        val touchHelper = ItemTouchHelper(swipeGesture)
//        touchHelper.attachToRecyclerView(bindingInvite.rcvProfile)
//        // end of swipe gesture code
