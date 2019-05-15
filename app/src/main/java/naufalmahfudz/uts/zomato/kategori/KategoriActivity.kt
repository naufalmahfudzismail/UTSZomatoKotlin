package naufalmahfudz.uts.zomato.kategori

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_main.*
import naufalmahfudz.uts.zomato.R

class KategoriActivity : AppCompatActivity(), KategoriView {

    private lateinit var kategoriPresenter: KategoriPresenter
    private lateinit var kategoriAdapter: KategoriAdapter
    private var datas: MutableList<Kategori> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        kategoriPresenter = KategoriPresenter(this, this)
        kategoriPresenter.onFecthingData()

        kategoriAdapter = KategoriAdapter(this, datas)
        rcy_kategori.layoutManager = LinearLayoutManager(this)
        rcy_kategori.adapter = kategoriAdapter
    }


    override fun onStopLoading() {
        progressBar.visibility = View.GONE
    }
    override fun onLoading() {
        progressBar.visibility = View.VISIBLE
    }
    override fun getData(data: List<Kategori>?) {
        data?.let { datas.addAll(it) }
    }
}
