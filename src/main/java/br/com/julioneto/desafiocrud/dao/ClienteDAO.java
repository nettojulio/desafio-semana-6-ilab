package br.com.julioneto.desafiocrud.dao;

import br.com.julioneto.desafiocrud.models.Cliente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClienteDAO extends CrudRepository<Cliente, Integer> {

    @Query("SELECT new br.com.julioneto.desafiocrud.models.Cliente(cliente.id, cliente.nome, cliente.cpf, cliente.email, cliente.telefone) FROM Cliente as cliente")
    public List<Cliente> recuperarTodos();

    @Query("SELECT new br.com.julioneto.desafiocrud.models.Cliente(cliente.id, cliente.nome, cliente.cpf, cliente.email, cliente.telefone) FROM Cliente as cliente WHERE cliente.id = :id")
    public Cliente recuperarPeloId(@Param("id") Integer id);

    @Query("SELECT new br.com.julioneto.desafiocrud.models.Cliente(cliente.id, cliente.nome, cliente.cpf, cliente.email, cliente.telefone) FROM Cliente as cliente WHERE cliente.cpf = :cpf")
    public Cliente recuperarPeloCpf(@Param("cpf") String cpf);

    @Query("SELECT new br.com.julioneto.desafiocrud.models.Cliente(cliente.id, cliente.nome, cliente.cpf, cliente.email, cliente.telefone) FROM Cliente as cliente WHERE cliente.email = :email")
    public Cliente recuperarPeloEmail(@Param("email") String email);

    @Query("SELECT new br.com.julioneto.desafiocrud.models.Cliente(cliente.id, cliente.nome, cliente.cpf, cliente.email, cliente.telefone) FROM Cliente as cliente WHERE cliente.telefone = :telefone")
    public Cliente recuperarPeloTelefone(@Param("telefone") String telefone);

}
