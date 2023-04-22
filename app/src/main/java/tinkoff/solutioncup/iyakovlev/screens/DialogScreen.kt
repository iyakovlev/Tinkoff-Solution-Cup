package tinkoff.solutioncup.iyakovlev.screens

import androidx.fragment.app.DialogFragment
import com.github.terrakok.cicerone.Screen

interface DialogScreen : Screen {
    fun getDialog(): DialogFragment
}