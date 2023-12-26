package com.smartgeek.gdseventapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.smartgeek.gdseventapp.databinding.ActivityChatsFragmentBinding

@Suppress("CAST_NEVER_SUCCEEDS")
class ChatsFragment : Fragment() {

    private lateinit var bindingChats: ActivityChatsFragmentBinding
    private val acceptedProfiles = InviteFragment()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        bindingChats = ActivityChatsFragmentBinding.inflate(inflater, container,false)

        // Below lines access arrayList "acceptedProfile" from Invite
        val chatProfiles: ArrayList<Profile> = acceptedProfiles as ArrayList<Profile>

        val adapter = ChatAdapter(chatProfiles)

        bindingChats.apply {
            rcvChatProfile.adapter = adapter
        }

        return bindingChats.root
    }
}

