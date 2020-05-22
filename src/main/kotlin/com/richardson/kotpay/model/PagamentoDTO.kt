package com.richardson.kotpay.model

import com.richardson.kotpay.util.LocalDateTimeConverter

class PagamentoDTO {
    private var id = 0
    private var formaPagamento = ""
    private var valor = 0.0
    private var moeda = ""
    private var descricao = ""
    private var status = ""
    private var dataCriacao: String? = null
    private var dataModificacao: String? = null

    constructor()

    constructor(
            id: Int,
            formaPagamento: String,
            valor: Double,
            moeda: String,
            descricao: String,
            status: String,
            dataCriacao: String?,
            dataModificacao: String?
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

    fun getFormaPagamento() = this.formaPagamento

    fun getValor() = this.valor

    fun getMoeda() = this.moeda

    fun getDescricao() = this.descricao

    fun getStatus() = this.status

    fun getDataCriacao() = this.dataCriacao
    fun setDataCriacao(dataCriacao: String?) {
        this.dataCriacao = dataCriacao
    }

    fun getDataModificacao() = this.dataModificacao
    fun setDataModificacao(dataModificacao: String?) {
        this.dataModificacao = dataModificacao
    }

    companion object {
        fun fromPagamento(pagamento: Pagamento?): PagamentoDTO? {
            if (pagamento == null)
                return null

            var pagamentoDTO = PagamentoDTO(pagamento.getId(), pagamento.getFormaPagamento(), pagamento.getValor()
                    , pagamento.getMoeda(), pagamento.getDescricao(), pagamento.getStatus(), "", "")
            pagamentoDTO.setDataCriacao(LocalDateTimeConverter.convertToString(pagamento.getDataCriacao()))
            if (pagamento.getDataModificacao() != null)
                pagamentoDTO.setDataModificacao(LocalDateTimeConverter.convertToString(pagamento.getDataModificacao()))

            return pagamentoDTO
        }

        fun toPagamento(pagamentoDTO: PagamentoDTO?): Pagamento? {
            if (pagamentoDTO == null)
                return null

            var pagamento = Pagamento(pagamentoDTO.getId(), pagamentoDTO.getFormaPagamento(), pagamentoDTO.getValor()
                    , pagamentoDTO.getMoeda(), pagamentoDTO.getDescricao(), pagamentoDTO.getStatus(), null, null)

            pagamento.setDataCriacao(LocalDateTimeConverter.convertToLocalDateTime(pagamentoDTO.getDataCriacao()))

            if (pagamento.getDataModificacao() != null)
                pagamento.setDataModificacao(LocalDateTimeConverter.convertToLocalDateTime(pagamentoDTO.getDataModificacao()))

            return pagamento
        }
    }

    override fun toString(): String {
        return "Pagamento(id=$id, formaPagamento='$formaPagamento', valor=$valor, moeda='$moeda', descricao='$descricao', status='$status', dataCriacao=$dataCriacao, dataModificacao=$dataModificacao)"
    }
}