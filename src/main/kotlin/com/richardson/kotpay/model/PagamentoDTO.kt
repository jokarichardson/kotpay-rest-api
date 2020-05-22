package com.richardson.kotpay.model

import com.richardson.kotpay.util.LocalDateTimeConverter

class PagamentoDTO {
    var id = 0
    var formaPagamento = ""
    var valor = 0.0
    var moeda = ""
    var descricao = ""
    var status = ""
    var dataCriacao: String? = ""
    var dataModificacao: String? = ""

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

    companion object {
        fun fromPagamento(pagamento: Pagamento?): PagamentoDTO? {
            if (pagamento == null)
                return null

            var pagamentoDTO = PagamentoDTO(pagamento.id, pagamento.formaPagamento, pagamento.valor, pagamento.moeda, pagamento.descricao, pagamento.status, "", "")
            pagamentoDTO.dataCriacao = LocalDateTimeConverter.convertToString(pagamento.dataCriacao)
            if (pagamento.dataModificacao != null)
                pagamentoDTO.dataModificacao = LocalDateTimeConverter.convertToString(pagamento.dataModificacao)

            return pagamentoDTO
        }

        fun toPagamento(pagamentoDTO: PagamentoDTO?): Pagamento? {
            if (pagamentoDTO == null)
                return null

            var pagamento = Pagamento(pagamentoDTO.id, pagamentoDTO.formaPagamento, pagamentoDTO.valor, pagamentoDTO.moeda, pagamentoDTO.descricao, pagamentoDTO.status, null, null)
            pagamento.dataCriacao = LocalDateTimeConverter.convertToLocalDateTime(pagamentoDTO.dataCriacao)
            if (pagamento.dataModificacao != null)
                pagamento.dataModificacao = LocalDateTimeConverter.convertToLocalDateTime(pagamentoDTO.dataModificacao)

            return pagamento
        }
    }

    override fun toString(): String {
        return "Pagamento(id=$id, formaPagamento='$formaPagamento', valor=$valor, moeda='$moeda', descricao='$descricao', status='$status', dataCriacao=$dataCriacao, dataModificacao=$dataModificacao)"
    }
}