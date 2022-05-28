package br.com.julioneto.desafiocrud.controllers;

import br.com.julioneto.desafiocrud.models.Cliente;
import br.com.julioneto.desafiocrud.services.IClienteServices;
import br.com.julioneto.desafiocrud.utils.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientesController {

    @Autowired
    private IClienteServices service;

    @GetMapping("/clientes")
    public ResponseEntity<List<Cliente>> recuperarTodos() {
        return ResponseEntity.ok(service.recuperarTodos());
    }

    @GetMapping("/clientes/{id}")
    public ResponseEntity<?> recuperarPeloId(@PathVariable Integer id) {
        Cliente cliente = service.recuperarPeloId(id);
        if (cliente != null) {
            return ResponseEntity.ok(cliente);
        }
        return ResponseEntity.status(404).body(new Messages(404, "Cliente não encontrado"));
    }

    @PostMapping("/clientes")
    public ResponseEntity<?> cadastrarNovoCliente(@RequestBody Cliente novo) {
        Cliente cliente = service.novoCliente(novo);
        if (cliente != null) {
            return ResponseEntity.status(201).body(cliente);
        }
        return ResponseEntity.badRequest().body(new Messages(400, "Dados Invalidos"));
    }

    @PutMapping("/clientes/{id}")
    public ResponseEntity<?> alterarDados(@RequestBody Cliente dados, @PathVariable Integer id) {
        if (service.recuperarPeloId(id) == null) {
            return ResponseEntity.status(404).body(new Messages(404, "Cliente não encontrado"));
        }

        dados.setId(id);

        Cliente novosDadosCliente = service.alterarDados(dados, id);
        if (novosDadosCliente != null) {
            return ResponseEntity.ok(novosDadosCliente);
        }
        return ResponseEntity.badRequest().body(new Messages(400, "Dados invalidos para atualizacao"));
    }

    @DeleteMapping("/clientes/{id}")
    public ResponseEntity<?> deletarCliente(@PathVariable Integer id) {
        if (service.recuperarPeloId(id) == null) {
            return ResponseEntity.status(404).body(new Messages(404, "Cliente não encontrado"));
        }

        if (service.deletarCliente(id)) {
            return ResponseEntity.ok(new Messages(200, "Cliente deletado com sucesso"));
        }
        return ResponseEntity.badRequest().body(new Messages(400, "Erro ao deletar cliente"));
    }
}
