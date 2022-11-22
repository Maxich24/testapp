package com.example.testgravity2

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainView : AppCompatActivity(), MainContract.View {
    lateinit var presenter: MainPresenter
    lateinit var progress: View
    lateinit var startButton: Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MainPresenter(this)
        progress = findViewById(R.id.progressView)
        startButton = findViewById(R.id.startButton)
        startButton.setOnClickListener { presenter.buttonClicked() }

    }

    override fun showProgress() {
        progress.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progress.visibility = View.GONE
    }

    override fun showWebView(url: String) {
        val fragment = WebFragment()
        Log.d("MyLog url", url)

        val fram = supportFragmentManager.beginTransaction()
        val bundle = Bundle()
        bundle.putString("url", url)
        fragment.arguments = bundle
        fram.replace(R.id.fragment_main, fragment)
        fram.commit()

    }
}