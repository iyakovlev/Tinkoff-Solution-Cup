package tinkoff.solutioncup.iyakovlev.di

import tinkoff.solutioncup.iyakovlev.nav.MyNavigator
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Navigator
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import org.koin.dsl.module
import tinkoff.solutioncup.iyakovlev.R

val mainModule = module {
    single<Cicerone<Router>> { Cicerone.create() }
    single<Router> { get<Cicerone<Router>>().router }
    single<NavigatorHolder> { get<Cicerone<Router>>().getNavigatorHolder() }
    single<Navigator> { MyNavigator(get(), R.id.fragment_container) }
}