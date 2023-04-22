package tinkoff.solutioncup.iyakovlev.nav

import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentFactory
import androidx.fragment.app.FragmentManager
import tinkoff.solutioncup.iyakovlev.screens.DialogScreen
import com.github.terrakok.cicerone.Forward
import com.github.terrakok.cicerone.androidx.AppNavigator

class MyNavigator(
    activity: FragmentActivity,
    containerId: Int,
    fragmentManager: FragmentManager = activity.supportFragmentManager,
    fragmentFactory: FragmentFactory = fragmentManager.fragmentFactory
) : AppNavigator(activity, containerId, fragmentManager, fragmentFactory) {

    override fun forward(command: Forward) {
        super.forward(command)
        (command.screen as? DialogScreen)?.let {
            it.getDialog().show(fragmentManager, command.screen.screenKey)
        }
    }
}
