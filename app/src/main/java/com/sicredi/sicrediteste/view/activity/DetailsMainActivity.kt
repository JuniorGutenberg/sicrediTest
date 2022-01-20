package com.sicredi.sicrediteste.view.activity

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Dialog
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.Window
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.sicredi.sicrediteste.R
import com.sicredi.sicrediteste.databinding.ActivityDetailsMainBinding
import com.sicredi.sicrediteste.databinding.CustomDialogCheckinBinding
import com.sicredi.sicrediteste.di.component.DaggerCheckInComponent
import com.sicredi.sicrediteste.di.module.CheckInModule
import com.sicredi.sicrediteste.presenter.CheckInPresenter
import com.sicredi.sicrediteste.presenter.contract.ICheckInContract
import com.sicredi.sicrediteste.utils.FormatUtils
import com.sicredi.sicrediteste.utils.ViewUtils
import com.sicredi.sicrediteste.view.enums.BaseUrl
import javax.inject.Inject
import android.util.Patterns
import androidx.core.util.PatternsCompat


class DetailsMainActivity: Activity(), ICheckInContract.ICheckInView {

    private lateinit var binding: ActivityDetailsMainBinding
    private lateinit var bindingCustom: CustomDialogCheckinBinding
    private lateinit var dialog: Dialog


    @Inject
    lateinit var presenter: CheckInPresenter

    private val FORMAT:String = "dd/MM/yyyy"
    private val CODE:String =   "R$"
    private var price:String=""
    private var desc:String=""
    private var date:String=""
    private var title:String=""
    private var eventId:String=""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsMainBinding.inflate(layoutInflater)
        bindingCustom = CustomDialogCheckinBinding.inflate(layoutInflater)
        setContentView(binding.root)

        DaggerCheckInComponent
            .builder()
            .checkInModule(CheckInModule(this))
            .build()
            .inject(this)

        changeStatusBarColor()
        getExtras()
        initializeComponents()

    }
    private fun changeStatusBarColor(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = ContextCompat.getColor(this,R.color.fundo)
        }
    }
    @SuppressLint("SetTextI18n")
    fun initializeComponents(){
        Glide.with(this)
            .load(intent.getStringExtra("image"))
            .centerCrop()
            .error(R.drawable.ic_img_not_found)
            .into(binding.ivFundo)

        setTexts()
        setDialog()
        clickComponents()

    }
    private fun setTexts(){

        binding.tvPrice.text    =  price
        binding.tvDesc.text     =  desc
        binding.tvCalendar.text = date
    }
    private fun clickComponents(){
        binding.btShare.setOnClickListener {
            compartilharEvento()
        }
        binding.btCheck.setOnClickListener {
            dialog.show()
        }
    }
    private fun getExtras(){
        title = intent.getStringExtra("title").toString()
        eventId = intent.getStringExtra("eventId").toString()
        desc = intent.getStringExtra("desc").toString()
        price =  CODE + FormatUtils.formataMoeda(intent.getDoubleExtra("price",0.0))
        date =   intent.getLongExtra("date",0).let { FormatUtils.timeToDate(it.toString(),FORMAT) }
    }
    private fun compartilharEvento(){

        val intent = Intent(Intent.ACTION_SEND)
        val msg = gerarMsg()


        intent.putExtra(Intent.EXTRA_SUBJECT,getString(R.string.title_share))
        intent.putExtra(Intent.EXTRA_TEXT,msg)
        intent.type = "text/plain"
        startActivity(Intent.createChooser(intent,getString(R.string.app_name)))

    }

    private fun gerarMsg():String{
        return title+
                "\n"+
                "\n"+ getString(R.string.dia_share)+" "+date+
                "\n"+
                "\n"+ getString(R.string.price_share)+" "+price+
                "\n"+
                "\n"+ getString(R.string.final_share)
    }

    fun fazerCheckIn(eventId:String,nome:String,email:String){
        presenter.postCheckIn(BaseUrl.URL.value,eventId,nome,email)
    }

    private fun setDialog(){
        dialog = Dialog(this)
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(bindingCustom.root)
        clickCheckDialog()
    }
    private fun clickCheckDialog(){
        bindingCustom.btnCheck.setOnClickListener {
            val nome = bindingCustom.etNome.text.toString()
            val email = bindingCustom.etEmail.text.toString()

            if(nome.isNotEmpty()){
                if(isValidEmail(email)){
                    fazerCheckIn(eventId,nome,email)
                    dialog.dismiss()
                    runOnUiThread {
                        ViewUtils.loading(this)
                    }
                }else{
                    Toast.makeText(this,R.string.error_email,Toast.LENGTH_LONG).show()
                }
            }else{
                Toast.makeText(this,R.string.error_nome,Toast.LENGTH_LONG).show()
            }
        }
    }
     fun isValidEmail(email: CharSequence): Boolean {
        return email.isNotEmpty() && PatternsCompat.EMAIL_ADDRESS.matcher(email).matches()
    }
    override fun onSucess() {
        runOnUiThread {
            ViewUtils.dismissLoading()
        }
        Toast.makeText(this,R.string.check_sucess,Toast.LENGTH_LONG).show()
        finish()
    }

    override fun onError(error: Throwable) {
        runOnUiThread {
            ViewUtils.dismissLoading()
        }
        Toast.makeText(this,error.message,Toast.LENGTH_LONG).show()
    }
}