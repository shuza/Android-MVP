package me.shuza.android_mvp.fetures

import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import me.shuza.android_mvp.R
import me.shuza.android_mvp.base.BaseActivity
import me.shuza.android_mvp.models.StudentModel
import org.jetbrains.anko.sdk25.coroutines.onClick
import javax.inject.Inject

class MainActivity : BaseActivity(), MainActivityMvpView {

    @Inject
    lateinit var presenter: MainActivityPresenter<MainActivityMvpView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityComponent.inject(this)
        presenter.attachView(this)
        setContentView(R.layout.activity_main)
        btn_load_data.onClick {
            presenter.fetchDataFromNetwork()
        }
    }

    override fun showData(dataList: List<StudentModel>) {
        var message = ""
        dataList.forEach { message = "$message \n ${it.toString()}" }
        tv_result.text = message
    }
}
