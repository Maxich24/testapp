package com.example.testgravity2

import android.util.Log
import com.example.testgravity2.MainContract.MyCallback
import org.json.JSONException
import org.json.JSONObject

class MainPresenter(mView: MainContract.View) : MainContract.Presenter {
    private var mView: MainContract.View? = null
    var mModel: MainContract.Model

    init {
        this.mView = mView
        mModel = Model()
    }

    override fun buttonClicked() {
        mModel.loadMessage(object : MyCallback {
            override fun success(url: String?) {
                if (url != null) {
                    Log.d("MyLog url", url)
                    val json = url?.let { JSONObject(it) }
                    try {
                        val link = json!!.getString("link")
                        val home = json.getString("home")

                        mView?.showWebView(link)

                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                }
            }

            override fun failure(t: Throwable?) {
            }
        })
    }


}