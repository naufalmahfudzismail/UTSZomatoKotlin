package naufalmahfudz.uts.zomato.restoran

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_restoran.view.*
import naufalmahfudz.uts.zomato.R
import naufalmahfudz.uts.zomato.restoran.detail.RestoranDetailActivity
import org.jetbrains.anko.*

class RestoranAdapter(private val context: Context, private val data: List<Restoran>) :
    RecyclerView.Adapter<RestoranAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_restoran, parent, false))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        viewHolder.bindItems(context, data[position], position)
    }

    class ViewHolder(private val containerView: View) : RecyclerView.ViewHolder(containerView) {

        fun bindItems(context: Context, kategori: Restoran, position: Int) {

            doAsync {

                kategori.imageUrl.let {
                    Glide.with(context).load(it).asBitmap().into(containerView.imageHeader2)
                }

                uiThread {
                    containerView.text_nama_restaurant.text = kategori.nama
                    containerView.text_harga.text = kategori.harga
                    containerView.text_lokasi.text = kategori.lokasi
                    containerView.setOnClickListener {
                        context.startActivity(context.intentFor<RestoranDetailActivity>())
                    }
                }
            }
        }
    }
}