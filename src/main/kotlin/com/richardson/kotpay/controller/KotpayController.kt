package com.richardson.kotpay.controller

import com.richardson.kotpay.model.Pagamento
import com.richardson.kotpay.service.PagamentoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/kotpay")
class KotpayController {
    @Autowired
    private lateinit var pagamentoService: PagamentoService

    @GetMapping
    fun listarPagamentos() = this.pagamentoService.listar()

    @GetMapping("/{id}")
    fun listarPagamentoPorId(@PathVariable("id") id: Int) = this.pagamentoService.listarPorId(id)

    @PostMapping
    fun adicionarPagamento(@RequestBody pagamento: Pagamento) = this.pagamentoService.adicionar(pagamento)

    @PatchMapping("/{id}")
    fun realizarPagamento(@PathVariable("id") id: Int) = this.pagamentoService.pagar(id)

    @DeleteMapping("/{id}")
    fun cancelarPagamento(@PathVariable("id") id: Int) = this.pagamentoService.cancelar(id)
}