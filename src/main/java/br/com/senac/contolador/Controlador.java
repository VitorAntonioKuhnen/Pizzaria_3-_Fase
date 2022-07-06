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

    private Cliente cliente;
    private ClienteDao clienteDao = new ClienteDaoImpl();
    private Session session;

    public Boolean validaCliente(Cliente cliente, String nome, String email, String telefone) {
        if (nome.length() > 3) {
            cliente.setNome(nome);
            cliente.setEmail(email);
            cliente.setTelefone(telefone);
            return true;
        } else {
            return false;
        }
    }

    public static Boolean validaEnd(Cliente cliente, Endereco endereco, String logradouro, String numero, String bairro, String localidade, String uf, String complemento, String cep) {
        if (!logradouro.isEmpty() || !numero.isEmpty() || !bairro.isEmpty() || !localidade.isEmpty() || !uf.isEmpty()) {
            List<Endereco> enderecos = new ArrayList<>();
            endereco = new Endereco(logradouro, numero, bairro, localidade, uf, complemento, cep);
            enderecos.add(endereco);
            cliente.setEnderecos(enderecos);
            for (Endereco end : enderecos) {
                end.setPessoa(cliente);
            }
            return true;
        } else {
            return false;
        }
    }
}
