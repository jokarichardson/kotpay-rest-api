package com.richardson.kotpay.model

import java.time.LocalDateTime

class Pagamento {
    var id = 0
    var formaPagamento = ""
    var valor = 0.0
    var moeda = ""
    var descricao = ""
    var status = ""
    var dataCriacao: LocalDateTime? = null
    var dataModificacao: LocalDateTime? = null

    constructor()

    constructor(
        id: Int,
        formaPagamento: String,
        valor: Double,
        moeda: String,
        descricao: String,
        status: String,
        dataCriacao: LocalDateTime?,
        dataModificacao: LocalDateTime?
    ) {
        this.id = id
        this.formaPagamento = formaPagamento
        this.valor = valor
        this.moeda = moeda
        this.descricao = descricao
        this.status = status
        this.dataCriacao = dataCriacao
        this.dataModificacao = dataModificacao
    }

    override fun toString(): String {
        return "Pagamento(id=$id, formaPagamento='$formaPagamento', valor=$valor, moeda='$moeda', descricao='$descricao', status='$status', dataCriacao=$dataCriacao, dataModificacao=$dataModificacao)"
    }
}