package naufalmahfudz.uts.zomato.kategori

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_kategori.view.*
import naufalmahfudz.uts.zomato.R
import naufalmahfudz.uts.zomato.restoran.RestoranActivity
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.uiThread
import java.text.FieldPosition

class KategoriAdapter(val context: Context, val data: List<Kategori>) :
    RecyclerView.Adapter<KategoriAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_kategori, parent, false))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        viewHolder.bindItems(context, data[position], position)
    }


    class ViewHolder(private val containerView: View) : RecyclerView.ViewHolder(containerView) {

        fun bindItems(context: Context, kategori: Kategori, position: Int) {

            containerView.text_judul.text = kategori.judul
            containerView.text_outlet.text = kategori.outlet
            containerView.text_deskripsi.text = kategori.deskripsi


            kategori.imageURL.let {
                Glide.with(context).load(it).asBitmap().into(containerView.imageHeader)
            }

            containerView.setOnClickListener {
                context.startActivity(
                    context.intentFor<RestoranActivity>(
                        "image" to kategori.imageURL
                    )
                )

            }
        }
    }
}