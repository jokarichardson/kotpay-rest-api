package com.richardson.kotpay.model

import springfox.documentation.annotations.ApiIgnore
import java.time.LocalDateTime

@ApiIgnore
class Pagamento {
    private var id = 0
    private var formaPagamento = ""
    private var valor = 0.0
    private var moeda = ""
    private var descricao = ""
    private var status = ""
    private var dataCriacao: LocalDateTime? = null
    private var dataModificacao: LocalDateTime? = null

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

    fun getId() = this.id
    fun setId(id: Int) {
        this.id = id
    }

    fun getFormaPagamento() = this.formaPagamento
    fun setFormaPagamento(formaPagamento: String) {
        this.formaPagamento = formaPagamento
    }

    fun getValor() = this.valor
    fun setValor(valor: Double) { this.valor = valor }

    fun getMoeda() = this.moeda
    fun setMoeda(moeda: String) { this.moeda = moeda }

    fun getDescricao() = this.descricao
    fun setDescricao(descricao: String) { this.descricao = descricao }

    fun getStatus() = this.status
    fun setStatus(status: String) { this.status = status }

    fun getDataCriacao() = this.dataCriacao
    fun setDataCriacao(dataCriacao: LocalDateTime?) { this.dataCriacao = dataCriacao }

    fun getDataModificacao() = this.dataModificacao
    fun setDataModificacao(dataModificacao: LocalDateTime?) { this.dataModificacao = dataModificacao }

    override fun toString(): String {
        return "Pagamento(id=$id, formaPagamento='$formaPagamento', valor=$valor, moeda='$moeda', descricao='$descricao', status='$status', dataCriacao=$dataCriacao, dataModificacao=$dataModificacao)"
    }
}