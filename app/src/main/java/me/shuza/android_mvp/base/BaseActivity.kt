package me.shuza.android_mvp.base

import android.app.AlertDialog
import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.os.PersistableBundle

import android.support.v7.app.AppCompatActivity
import dmax.dialog.SpotsDialog
import me.shuza.android_mvp.R
import me.shuza.android_mvp.injection.components.ActivityComponent
import me.shuza.android_mvp.injection.components.DaggerActivityComponent
import me.shuza.android_mvp.injection.modules.ActivityModule
import me.shuza.android_mvp.injection.modules.NetworkModule
import org.jetbrains.anko.toast
import kotlin.properties.Delegates

/**
 *
 * :=  created by:  Shuza
 * :=  create date:  3/22/2018
 * :=  (C) CopyRight Shuza
 * :=  www.shuza.ninja
 * :=  shuza.sa@gmail.com
 * :=  Fun  :  Coffee  :  Code
 *
 **/
open class BaseActivity : AppCompatActivity(), BaseMvpView {
    var dialog: AlertDialog by Delegates.notNull()
    val activityComponent: ActivityComponent by lazy {
        DaggerActivityComponent.builder()
                .activityModule(ActivityModule(this))
                .applicationComponent(BaseApplication.get(this).component)
                .networkModule(NetworkModule())
                .build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dialog = SpotsDialog(this, R.style.LoadingDialog)
        dialog.setCancelable(false)
    }

    override fun isNetworkAvailable(): Boolean {
        val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return (networkInfo != null && networkInfo.isConnectedOrConnecting)

    }

    override fun showLoadingDialog() {
        if (!dialog.isShowing) {
            dialog.show()
        }
    }

    override fun dismissLoadingDialog() {
        if (dialog.isShowing) {
            dialog.dismiss()
        }
    }

    override fun showSuccessMessage(message: String) {
        toast(message)
    }

    override fun showErrorMessage(message: String) {
        toast(message)
    }

    override fun getResourceText(id: Int): String {
        return resources.getString(id)
    }
}
