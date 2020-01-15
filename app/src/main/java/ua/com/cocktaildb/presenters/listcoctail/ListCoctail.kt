package ua.com.cocktaildb.presenters.listcoctail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.listcoctail.*
import ua.com.cocktaildb.R
import ua.com.cocktaildb.di.listcoctail.DaggerListCoctailComponent
import ua.com.cocktaildb.di.listcoctail.ListCoctailPresetModul
import ua.com.cocktaildb.presenters.discription.Discription
import ua.com.cocktaildb.repository.retrofit.entity.RowType
import ua.com.cocktaildb.repository.retrofit.entity.TitleDrink
import javax.inject.Inject

class ListCoctail : Fragment(), IListCoctail.IListCoctailView {

    @Inject
    lateinit var mPresenter: IListCoctail.IListCoctailPresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        addDaggerDepandance()
        return inflater.inflate(R.layout.listcoctail, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mPresenter.onStart()
    }


    private fun addDaggerDepandance() {
        DaggerListCoctailComponent.builder()
            .listCoctailPresetModul(ListCoctailPresetModul(this))
            .build()
            .inject(this)
    }


    override fun showRecyclerList(list: List<RowType>) {
        val recyclerAdapter =
            RecyclerAdapter(
                items = list,
                callback = object : RecyclerAdapter.Callback {
                    override fun onItemClicked(item: TitleDrink) {
                        showDialig(item)
                    }
                })
        myRecycler.adapter = recyclerAdapter
        myRecycler.layoutManager = LinearLayoutManager(context)
    }

    fun showDialig(item: TitleDrink) {
        Discription(item).show(childFragmentManager, "list")
    }

}