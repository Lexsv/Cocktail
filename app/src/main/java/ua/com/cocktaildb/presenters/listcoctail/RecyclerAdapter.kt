package ua.com.cocktaildb.presenters.listcoctail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.squareup.picasso.PicassoProvider
import ua.com.cocktaildb.R
import ua.com.cocktaildb.repository.retrofit.entity.CategoryName
import ua.com.cocktaildb.repository.retrofit.entity.RowType
import ua.com.cocktaildb.repository.retrofit.entity.TitleDrink


class RecyclerAdapter(var items: List<RowType>, val callback: Callback) :
    RecyclerView.Adapter<RecyclerAdapter.RecyclerHolder>() {

    override fun getItemViewType(position: Int): Int {
        return when{
            items.get(position) is CategoryName -> RowType.CATEDGORY_ROW_TYPE
            items.get(position) is TitleDrink -> RowType.TITLE_ROW_TYPE
            else -> -1

        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        when (viewType){
            RowType.CATEDGORY_ROW_TYPE -> RecyclerHolder(LayoutInflater
                                                            .from(parent.context)
                                                            .inflate(R.layout.row_category, parent, false))

            else -> RecyclerHolder(LayoutInflater
                                    .from(parent.context)
                                    .inflate(R.layout.row_view_coctail, parent, false))

        }



    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: RecyclerHolder, position: Int) =  holder.bind(items[position])

    inner class RecyclerHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {




        private val titleCategory = itemView.findViewById<TextView>(R.id.row_category_title)
        private val titleCoctail= itemView.findViewById<TextView>(R.id.view_coctail_title)
        private val imagCoctail = itemView.findViewById<ImageView>(R.id.view_coctelail_image)




        fun bind(item: RowType) {
            when{
                item is CategoryName -> titleCategory.text = item.strCategory
                item is TitleDrink -> {
                    titleCoctail.text = item.strDrink
                    Picasso.get()
                        .load(item.strDrinkThumb)
                        .resize(100, 100)
                        .centerCrop()
                        .into(imagCoctail)
                    itemView.setOnClickListener {

                        if (adapterPosition != RecyclerView.NO_POSITION) callback.onItemClicked(items[adapterPosition] as TitleDrink)

                    }
                }
            }


        }

    }

    interface Callback {
        fun onItemClicked(item: TitleDrink)
    }
}