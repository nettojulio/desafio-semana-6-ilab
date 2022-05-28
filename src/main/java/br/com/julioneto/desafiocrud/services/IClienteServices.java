package br.com.julioneto.desafiocrud.services;

import br.com.julioneto.desafiocrud.models.Cliente;

import java.util.List;

public interface IClienteServices {
    public List<Cliente> recuperarTodos();
    public Cliente recuperarPeloId(Integer id);
    public Cliente novoCliente(Cliente novoCliente);
    public Cliente alterarDados(Cliente novosDados, Integer id);
    public boolean deletarCliente(Integer id);
}
