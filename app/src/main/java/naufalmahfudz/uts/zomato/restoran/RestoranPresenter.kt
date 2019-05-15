package naufalmahfudz.uts.zomato.restoran

import android.content.Context
import naufalmahfudz.uts.zomato.R
import naufalmahfudz.uts.zomato.kategori.Kategori


class RestoranPresenter(val context : Context, val view : RestoranView) {

    fun onFetchingData(){

        view.onLoading()

        val res = context.resources

        val nama_restaurant = res.getStringArray(R.array.nama_restaurant)
        val nama_lokasi = res.getStringArray(R.array.nama_lokasi)
        val harga = res.getStringArray(R.array.harga)
        val url_restaurant = res.getStringArray(R.array.url_restaurant)

        val datas: MutableList<Restoran> = mutableListOf()

        nama_lokasi.indices.forEach { i ->
            datas.add(Restoran(nama_restaurant[i], nama_lokasi[i], harga[i], url_restaurant[i]))
        }

        view.getData(datas)
        view.onStopLoading()
    }
}