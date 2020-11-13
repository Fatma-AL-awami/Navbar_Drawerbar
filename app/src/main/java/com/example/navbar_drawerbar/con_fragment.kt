package com.example.navbar_drawerbar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView



private const val nav = "nav"
class con_fragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var pos: Int? = null
    lateinit var conTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            pos = it.getInt(nav)

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var  vew=inflater.inflate(R.layout.con_fragment, container, false)
        conTextView=vew.findViewById(R.id.txt_content)

        when(pos){
            R.id.profile->{
                vew.setBackgroundResource(R.color.design_default_color_error)
                conTextView.setText("#profile")
            }
            R.id.setting->{
                vew.setBackgroundResource(R.color.colorAccent)
                conTextView.setText("Settings")
            }
            R.id.aboutUs->{
                vew.setBackgroundResource(R.color.colorPrimaryDark)
                conTextView.setText("aboutUs")
            }
            else->{conTextView.setText("profile")}
        }
        return vew
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Content.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, pos: Int) =
           con_fragment().apply {
                arguments = Bundle().apply {
                    putString(nav, param1)
                    putInt(nav,pos)
                }
            }
    }


}