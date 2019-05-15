package naufalmahfudz.uts.zomato.restoran.detail

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_restoran_detail.*
import naufalmahfudz.uts.zomato.R
import naufalmahfudz.uts.zomato.restoran.Restoran

class RestoranDetailActivity : AppCompatActivity() {

    private lateinit var restoran: Restoran

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restoran_detail)

        actionBar?.setDisplayHomeAsUpEnabled(true)

        restoran = Restoran(
            intent.getStringExtra("nama"), intent.getStringExtra("lokasi"),
            intent.getStringExtra("harga"), intent.getStringExtra("image")
        )


        Glide.with(this).load(restoran.imageUrl).asBitmap().into(imageDetailGambar)
        textDetailNamaResto.text = restoran.nama
        textDetailAlamat.text = restoran.lokasi
        textDetailJamBuka.text = restoran.harga
    }
}
