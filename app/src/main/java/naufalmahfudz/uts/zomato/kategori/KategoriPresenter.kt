package naufalmahfudz.uts.zomato.kategori

import android.content.Context
import org.jetbrains.anko.doAsync
import android.app.Activity
import naufalmahfudz.uts.zomato.R
import org.jetbrains.anko.uiThread


class KategoriPresenter(
    val context: Context,
    val view: KategoriView
) {

    fun onFecthingData() {
        view.onLoading()

        val res = context.resources

        val judul = res.getStringArray(R.array.judul)
        val outlet = res.getStringArray(R.array.outlet)
        val deskripsi = res.getStringArray(R.array.deskripsi)
        val imageURL = res.getStringArray(R.array.imageURL)
        val datas: MutableList<Kategori> = mutableListOf()

        judul.indices.forEach { i ->
            datas.add(Kategori(judul[i], outlet[i], deskripsi[i], imageURL[i]))
        }
        view.getData(datas)
        view.onStopLoading()
    }

}