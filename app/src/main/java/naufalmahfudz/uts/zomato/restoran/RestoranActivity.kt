package naufalmahfudz.uts.zomato.restoran

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.View
import kotlinx.android.synthetic.main.activity_restoran.*
import naufalmahfudz.uts.zomato.R

class RestoranActivity : AppCompatActivity(), RestoranView {

    private var datas: MutableList<Restoran> = mutableListOf()
    private lateinit var restoranAdapter: RestoranAdapter
    private lateinit var restoranPresenter: RestoranPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restoran)

        restoranPresenter = RestoranPresenter(this, this)
        restoranPresenter.onFetchingData()

        restoranAdapter = RestoranAdapter(this, datas)
        rcy_restoran.layoutManager = GridLayoutManager(this, 2)
        rcy_restoran.adapter = restoranAdapter
    }

    override fun onLoading() {

        progressBar.visibility = View.VISIBLE
    }

    override fun onStopLoading() {

        progressBar.visibility = View.GONE
    }

    override fun getData(data: List<Restoran>?) {

        data?.let {
            datas.addAll(it)
        }
    }
}
