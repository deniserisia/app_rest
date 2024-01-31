package com.drc.app_rest

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var cbArrozCamarao: CheckBox
    private lateinit var cbCarneSol: CheckBox
    private lateinit var cbPicanhaBrasa: CheckBox
    private lateinit var cbCocaCola: CheckBox
    private lateinit var cbAgua: CheckBox
    private lateinit var tvTotal: TextView
    private lateinit var tvResultado: TextView
    private lateinit var btnCalcularTotal: Button

    private val valorArrozCamarao: Int by lazy { resources.getInteger(R.integer.valor_arroz_camarao) }
    private val valorCarneSol: Int by lazy { resources.getInteger(R.integer.valor_carne_sol) }
    private val valorPicanhaBrasa: Int by lazy { resources.getInteger(R.integer.valor_picanha_brasa) }
    private val valorCocaCola: Int by lazy { resources.getInteger(R.integer.valor_coca_cola) }
    private val valorAgua: Int by lazy { resources.getInteger(R.integer.valor_agua) }

    private var totalPedido: Float = 0.0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cbArrozCamarao = findViewById(R.id.cbArrozCamarao)
        cbCarneSol = findViewById(R.id.cbCarneSol)
        cbPicanhaBrasa = findViewById(R.id.cbPicanhaBrasa)
        cbCocaCola = findViewById(R.id.cbCocaCola)
        cbAgua = findViewById(R.id.cbAgua)
        tvTotal = findViewById(R.id.tvTotal)
        tvResultado = findViewById(R.id.tvResultado)
        btnCalcularTotal = findViewById(R.id.btnCalcularTotal)

        setCheckBoxClickListener(cbArrozCamarao, valorArrozCamarao)
        setCheckBoxClickListener(cbCarneSol, valorCarneSol)
        setCheckBoxClickListener(cbPicanhaBrasa, valorPicanhaBrasa)
        setCheckBoxClickListener(cbCocaCola, valorCocaCola)
        setCheckBoxClickListener(cbAgua, valorAgua)


        btnCalcularTotal.setOnClickListener {
            calcularTotalPedido()
        }
    }

    private fun setCheckBoxClickListener(checkBox: CheckBox, valorItem: Int) {
        checkBox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                totalPedido += valorItem
            } else {
                totalPedido -= valorItem
            }

            atualizarExibicaoTotal()
        }
    }

    private fun calcularTotalPedido() {
        tvResultado.text = getString(R.string.total_pedido, totalPedido)
    }

    private fun atualizarExibicaoTotal() {
        tvTotal.text = getString(R.string.total_pedido, totalPedido)
    }
}
