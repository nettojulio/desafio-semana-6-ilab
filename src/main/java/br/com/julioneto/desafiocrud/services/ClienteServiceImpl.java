package br.com.julioneto.desafiocrud.services;

import br.com.julioneto.desafiocrud.dao.ClienteDAO;
import br.com.julioneto.desafiocrud.models.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClienteServiceImpl implements IClienteServices {

    @Autowired
    private ClienteDAO dao;

    @Override
    public List<Cliente> recuperarTodos() {
        return dao.recuperarTodos();
    }

    @Override
    public Cliente recuperarPeloId(Integer id) {
        return dao.recuperarPeloId(id);
    }

    @Override
    public Cliente novoCliente(Cliente novoCliente) {
        try {
            if (dao.recuperarPeloCpf(novoCliente.getCpf()) != null
                    || dao.recuperarPeloEmail(novoCliente.getEmail()) != null
                    || dao.recuperarPeloTelefone(novoCliente.getTelefone()) != null) {
                return null;
            }
            return dao.save(novoCliente);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Cliente alterarDados(Cliente novosDados, Integer id) {
        try {
            Cliente verificacaoCpf = dao.recuperarPeloCpf(novosDados.getCpf());
            Cliente verificacaoEmail = dao.recuperarPeloEmail(novosDados.getEmail());
            Cliente verificacaoTelefone = dao.recuperarPeloTelefone(novosDados.getTelefone());

            if (verificacaoCpf != null && verificacaoCpf.getCpf() != null && !verificacaoCpf.getId().equals(id)) {
                return null;
            }

            if (verificacaoEmail != null && verificacaoEmail.getEmail() != null
                    && !verificacaoEmail.getId().equals(id)) {
                return null;
            }

            if (verificacaoTelefone != null && verificacaoTelefone.getTelefone() != null
                    && !verificacaoTelefone.getId().equals(id)) {
                return null;
            }

            return dao.save(novosDados);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean deletarCliente(Integer id) {
        try {
            dao.deleteById(id);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
