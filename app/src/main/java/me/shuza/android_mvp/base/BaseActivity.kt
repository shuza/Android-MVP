package me.shuza.android_mvp.base

import android.app.AlertDialog
import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.os.PersistableBundle

import android.support.v7.app.AppCompatActivity
import dmax.dialog.SpotsDialog
import me.shuza.android_mvp.R
import org.jetbrains.anko.toast
import kotlin.properties.Delegates

/**
 *
 * :=  created by:  Shuza
 * :=  create date:  3/22/2018
 * :=  (C) CopyRight Shuza
 * :=  www.shuza.me
 * :=  shuza.sa@gmail.com
 * :=  Fun  :  Coffee  :  Code
 *
 **/
open class BaseActivity : AppCompatActivity(), BaseMvpView {
    var dialog: AlertDialog by Delegates.notNull()

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
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