package fr.larrieu_lacoste.noe.ce_que_vous_voulez.util

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class ActivityUtil {
    companion object {
        fun addFragmentToActivity(manager: FragmentManager, fragment: Fragment, frameId: Int) {
            val transaction: FragmentTransaction = manager.beginTransaction()
            transaction.add(frameId, fragment)
            transaction.commit()
        }
    }
}