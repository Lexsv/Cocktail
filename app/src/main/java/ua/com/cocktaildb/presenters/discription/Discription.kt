package ua.com.cocktaildb.presenters.discription

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.LifecycleOwner
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.description.*
import ua.com.cocktaildb.R
import ua.com.cocktaildb.di.discription.DaggerDiscriptionComponent
import ua.com.cocktaildb.di.discription.DiscriptionPresenterModul
import ua.com.cocktaildb.repository.retrofit.entity.DescriptionCoctail

import ua.com.cocktaildb.repository.retrofit.entity.TitleDrink
import javax.inject.Inject

class Discription(var item : TitleDrink): DialogFragment(),IDiscription.IDiscriptionView {
    @Inject
    lateinit var mPresenter : IDiscription.IDiscriptionPresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        addDaggerDepandance()
        return inflater.inflate(R.layout.description, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mPresenter.onStart(item)
        addClickLisan()
    }

    private fun addClickLisan() {
        descript_button.setOnClickListener{
            dismiss()
        }
    }

    private fun addDaggerDepandance() {
        DaggerDiscriptionComponent.builder()
            .discriptionPresenterModul(DiscriptionPresenterModul(this))
            .build()
            .inject(this)
    }

    override fun getLifecycleOwner(): LifecycleOwner = this
    override fun viewDescription(item: DescriptionCoctail) {
        Picasso.get()
            .load(item.strDrinkThumb)
            .resize(100, 100)
            .centerCrop()
            .into(descript_imag)

        descript_title.text = item.strDrink
        descript_text.text = item.strInstructions
    }
}