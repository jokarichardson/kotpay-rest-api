package com.richardson.kotpay.service

import com.richardson.kotpay.model.Pagamento
import com.richardson.kotpay.model.PagamentoDTO
import com.richardson.kotpay.repository.PagamentoDatabase
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PagamentoService {

    @Autowired
    private lateinit var pagamentoDatabase: PagamentoDatabase

    fun listar(): MutableList<PagamentoDTO?> {
        var pagamentosDTO = mutableListOf<PagamentoDTO?>()
        this.pagamentoDatabase.listar().forEach {
            pagamentosDTO.add(PagamentoDTO.fromPagamento(it))
        }
        return pagamentosDTO
    }

    fun listarPorId(id: Int): PagamentoDTO? {
        return PagamentoDTO.fromPagamento(this.pagamentoDatabase.listarPorId(id))
    }

    fun adicionar(pagamento: Pagamento): PagamentoDTO? {
        return PagamentoDTO.fromPagamento(this.pagamentoDatabase.adicionar(pagamento))
    }

    fun pagar(id: Int): PagamentoDTO? {
        return PagamentoDTO.fromPagamento(this.pagamentoDatabase.pagar(id))
    }

    fun cancelar(id: Int): PagamentoDTO? {
        return PagamentoDTO.fromPagamento(this.pagamentoDatabase.cancelar(id))
    }
}