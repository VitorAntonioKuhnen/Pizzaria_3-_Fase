/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.contolador;

import br.com.senac.dao.ClienteDao;
import br.com.senac.dao.ClienteDaoImpl;
import br.com.senac.entidade.Cliente;
import br.com.senac.entidade.Endereco;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author vitor.kuhnen
 */
public class Controlador {

    private ClienteDao clienteDao = new ClienteDaoImpl();

    public static Boolean validaCliente(Cliente cliente,Long id, String nome, String email, String telefone) {
        if (nome.length() > 3) {
            cliente.setNome(nome);
            cliente.setEmail(email);
            cliente.setTelefone(telefone);
            cliente.setId(id);
            return true;
        } else {
            return false;
        }
    }

    public static Boolean validaEnd(Cliente cliente, Endereco endereco, Long id, String logradouro, String numero, String bairro, String localidade, String uf, String complemento, String cep) {
        if (!logradouro.isEmpty() && !numero.isEmpty() && !bairro.isEmpty() && !localidade.isEmpty() && !uf.isEmpty()) {
            List<Endereco> enderecos = new ArrayList<>();
            endereco = new Endereco(logradouro, numero, bairro, localidade, uf, complemento, cep);
            endereco.setId(id);
            enderecos.add(endereco);
            for (Endereco end : enderecos) {
                end.setPessoa(cliente);
            }
            endereco.setPessoa(cliente);
            cliente.setEnderecos(enderecos);
            return true;
        } else {
            return false;
        }
    }
}
