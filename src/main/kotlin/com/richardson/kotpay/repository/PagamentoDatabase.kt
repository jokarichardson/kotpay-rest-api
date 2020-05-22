package com.richardson.kotpay.repository

import com.richardson.kotpay.exception.KotpayException
import com.richardson.kotpay.model.Pagamento
import org.springframework.stereotype.Component
import java.time.LocalDateTime
import java.time.ZoneId
import javax.annotation.PostConstruct

@Component
class PagamentoDatabase {

    private val pagamentos = mutableListOf<Pagamento?>()

    @PostConstruct
    private fun init() {
        pagamentos.add(
                Pagamento(
                        1, "DINHEIRO", 100.0, "BRL", "Pagamento parcela 1/4", "EM ABERTO", LocalDateTime.now(
                        ZoneId.of("America/Sao_Paulo")
                ), null
                )
        )
        pagamentos.add(
                Pagamento(
                        2, "CARTAO", 223.15, "BRL", "Pagamento único", "EM ABERTO", LocalDateTime.now(
                        ZoneId.of("America/Sao_Paulo")
                ), null
                )
        )
    }

    fun listar() = this.pagamentos;

    fun listarPorId(id: Int): Pagamento? =
            this.pagamentos.find { it?.getId() == id } ?: throw KotpayException("Pagamento não localizado")

    fun adicionar(pagamento: Pagamento): Pagamento {
        pagamento.setId(this.pagamentos.size + 1)
        pagamento.setDataCriacao(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")))
        this.pagamentos.add(pagamento)

        return pagamento;
    }

    fun pagar(id: Int): Pagamento? {
        var pagamento: Pagamento? = this.listarPorId(id)

        var indice = this.pagamentos.indexOf(pagamento)

        pagamento?.setStatus("PAGO")
        pagamento?.setDataModificacao(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")))

        this.pagamentos.removeAt(indice)
        this.pagamentos.add(pagamento)

        return pagamento
    }

    fun cancelar(id: Int): Pagamento? {
        var pagamento: Pagamento? = this.listarPorId(id)

        var indice = this.pagamentos.indexOf(pagamento)

        pagamento?.setStatus("CANCELADO")
        pagamento?.setDataModificacao(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")))

        this.pagamentos.removeAt(indice)
        this.pagamentos.add(pagamento)

        return pagamento
    }
}