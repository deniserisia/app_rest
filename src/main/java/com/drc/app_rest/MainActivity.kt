import android.os.Bundle
import android.widget.Button  // Importe necessário para a classe Button
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import com.drc.app_rest.R

class MainActivity : AppCompatActivity() {

    // Declaração dos componentes
    private lateinit var cbArrozCamarao: CheckBox
    private lateinit var cbCarneSol: CheckBox
    private lateinit var cbPicanhaBrasa: CheckBox
    private lateinit var cbCocaCola: CheckBox
    private lateinit var cbAgua: CheckBox
    private lateinit var tvTotal: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicialização dos componentes
        cbArrozCamarao = findViewById(R.id.cbArrozCamarao)
        cbCarneSol = findViewById(R.id.cbCarneSol)
        cbPicanhaBrasa = findViewById(R.id.cbPicanhaBrasa)
        cbCocaCola = findViewById(R.id.cbCocaCola)
        cbAgua = findViewById(R.id.cbAgua)
        tvTotal = findViewById(R.id.tvTotal)

        // Ação do botão "Calcular Total do Pedido"
        findViewById<Button>(R.id.btnCalcularTotal).setOnClickListener {
            calcularTotalPedido()
        }
    }

    private fun calcularTotalPedido() {
        var total = 0.0

        // Lógica para cada item selecionado
        if (cbArrozCamarao.isChecked) {
            total += 56.0
        }
        if (cbCarneSol.isChecked) {
            total += 100.0
        }
        if (cbPicanhaBrasa.isChecked) {
            total += 120.0
        }
        if (cbCocaCola.isChecked) {
            total += 10.0
        }
        if (cbAgua.isChecked) {
            total += 3.0
        }

        // Exibir o total na TextView
        tvTotal.text = getString(R.string.total_pedido, total)
    }
}
