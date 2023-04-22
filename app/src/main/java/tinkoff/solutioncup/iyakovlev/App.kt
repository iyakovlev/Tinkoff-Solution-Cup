package tinkoff.solutioncup.iyakovlev

import android.app.Application
import tinkoff.solutioncup.iyakovlev.di.mainModule
import org.koin.core.context.startKoin

class App  : Application(){

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(mainModule)
        }
    }
}