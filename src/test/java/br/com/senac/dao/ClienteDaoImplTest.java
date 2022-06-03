/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.dao;

import br.com.senac.entidade.Cliente;
import br.com.senac.entidade.Endereco;
import br.com.senac.entidade.Pedido;
import static br.com.senac.util.GeradorUtil.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author vitor.kuhnen
 */
public class ClienteDaoImplTest {

    private Session session;
    private Cliente cliente;
    private ClienteDao clienteDao;
    private Endereco endereco;

    public ClienteDaoImplTest() {

        clienteDao = new ClienteDaoImpl();
    }

    @Test
    public void testSalvar() {
        System.out.println("Salvar");

        cliente = new Cliente(false, "Víter", "Vit@gmasil.com", "888758988");
        List<Endereco> enderecos = new ArrayList<>();
        enderecos.add(gerarEndereco());
        cliente.setEnderecos(enderecos);

        for (Endereco endereco : enderecos) {
            endereco.setPessoa(cliente);
        }
        
        List<Pedido> pedidos = new ArrayList<>();
        pedidos.add(gerarPedido());
        cliente.setPedidos(pedidos);
        for (Pedido pedido : pedidos) {
            pedido.setCliente(cliente);
        }
        
        session = HibernateUtil.abrirConexao();
        clienteDao.saveOrAlter(cliente, session);
        session.close();
        assertNotNull(cliente.getId());

    }

//    @Test
    public void testPesquisarPorId() {
        System.out.println("pesquisarPorId");
        Long id = null;
        Session session = null;
        ClienteDaoImpl instance = new ClienteDaoImpl();
        Cliente expResult = null;
        Cliente result = instance.pesquisarPorId(id, session);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

//    @Test
    public void testAskPerName() {
        System.out.println("askPerName");
        String nome = "";
        Session session = null;
        ClienteDaoImpl instance = new ClienteDaoImpl();
        List<Cliente> expResult = null;
        List<Cliente> result = instance.askPerName(nome, session);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

}
