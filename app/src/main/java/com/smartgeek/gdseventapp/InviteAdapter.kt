package com.smartgeek.gdseventapp

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class InviteAdapter(
    private val inviteList: List<Profile>
) : BaseAdapter() {

    private var layoutInflater: LayoutInflater? = null
    private lateinit var profileName: TextView
    private lateinit var profileImage: ImageView

    override fun getCount(): Int {
        return inviteList.size
    }

    override fun getItem(position: Int): Any? {
        return null
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    @SuppressLint("InflateParams")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var convertView1 = convertView

        if (convertView1 != null) {
            convertView1 = layoutInflater?.inflate(R.layout.custom_card_view, null)
        }

        profileName = convertView1!!.findViewById(R.id.tv_invite_name)
        profileImage = convertView1.findViewById(R.id.iv_invite_pp)

        profileImage.setImageResource(inviteList[position].image)
        profileName.text = inviteList[position].profileName

        return convertView1
    }

}


//class InviteAdapter(private var inviteList: ArrayList<Profile>) :
//    RecyclerView.Adapter<InviteAdapter.InviteViewHolder>() {
//
//
//    // swipe gesture code
//    private lateinit var myListener: OnItemClickListener
//
//    // to view the details of current clicked profile
//    interface OnItemClickListener{
//        fun onItemClick(position: Int)
//    }
//
//    fun setOnItemClickListener(listener: OnItemClickListener){
//        myListener = listener
//    }
//
//    @SuppressLint("NotifyDataSetChanged")
//    fun deleteItem(i: Int){
//        inviteList.removeAt(i)
//        notifyDataSetChanged()
//    }
//    // end of swipe Gesture code
//
//
//    class InviteViewHolder(val binding: CustomCardViewBinding) :
//        RecyclerView.ViewHolder(binding.root)
//
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InviteViewHolder {
//        val binding =
//            CustomCardViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        return InviteViewHolder(binding)
//    }
//
//    override fun onBindViewHolder(holder: InviteViewHolder, position: Int) {
//        val profiles = inviteList[position]
//        holder.binding.apply {
//            Glide.with(ivInvitePp).load(inviteList[position].image).into(ivInvitePp)
//            ivInviteName.text = profiles.profileName
//        }
//    }
//
//    override fun getItemCount(): Int = inviteList.size
//}