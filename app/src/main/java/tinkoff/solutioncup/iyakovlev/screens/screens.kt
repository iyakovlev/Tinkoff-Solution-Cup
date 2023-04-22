package tinkoff.solutioncup.iyakovlev.screens

import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import tinkoff.solutioncup.iyakovlev.BottomSheetFragment
import tinkoff.solutioncup.iyakovlev.FirstFragment
import tinkoff.solutioncup.iyakovlev.SecondFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object FirstScreen: FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment {
        return FirstFragment()
    }
}

object SecondScreen : FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment {
        return SecondFragment()
    }
}

object BottomSheetScreen : DialogScreen {
    override fun getDialog(): DialogFragment {
        return BottomSheetFragment()
    }
}