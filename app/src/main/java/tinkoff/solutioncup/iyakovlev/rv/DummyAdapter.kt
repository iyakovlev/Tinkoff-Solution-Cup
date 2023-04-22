package tinkoff.solutioncup.iyakovlev.rv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import tinkoff.solutioncup.iyakovlev.R

class DummyAdapter(val count: Int) : RecyclerView.Adapter<DummyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DummyViewHolder {
         val v = LayoutInflater.from(parent.context).inflate(
            tnkoff.solutioncup.iyakovlev.design.R.layout.item_card_img_title_subtitle,
            parent,
            false
        )
        return DummyViewHolder(v)
    }

    override fun onBindViewHolder(holder: DummyViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount() = count
}

class DummyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val title = view.findViewById<TextView>(tnkoff.solutioncup.iyakovlev.design.R.id.title)
    private val subtitle = view.findViewById<TextView>(tnkoff.solutioncup.iyakovlev.design.R.id.subtitle)
    private val img = view.findViewById<ImageView>(tnkoff.solutioncup.iyakovlev.design.R.id.image)
    fun bind(int: Int) {
        title.text = "Title $int"
        subtitle.text = "Subtitle $int"
        img.setImageResource(tnkoff.solutioncup.iyakovlev.design.R.drawable.tui_avatar)
    }

}