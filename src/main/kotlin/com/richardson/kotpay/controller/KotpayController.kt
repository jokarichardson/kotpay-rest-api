package com.richardson.kotpay.controller

import com.richardson.kotpay.model.PagamentoDTO
import com.richardson.kotpay.service.PagamentoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

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
    fun adicionarPagamento(@RequestBody pagamentoDTO: PagamentoDTO) = this.pagamentoService.adicionar(pagamentoDTO)

    @PatchMapping("/{id}")
    fun realizarPagamento(@PathVariable("id") id: Int) = this.pagamentoService.pagar(id)

    @DeleteMapping("/{id}")
    fun cancelarPagamento(@PathVariable("id") id: Int) = this.pagamentoService.cancelar(id)
}