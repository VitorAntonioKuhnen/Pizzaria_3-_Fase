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
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.query.Query;
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

//    @Test
    public void testSalvar() {
        System.out.println("Salvar");

        cliente = new Cliente(false, "Vítor", "vitor@gmail.com", "898778988");
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
    public void testAlterar(){
        System.out.println("AlteraCliente");
        clienteBd();
        cliente.setNome("viasdemais");
        cliente.setEmail("viasdasd@gmail.com");
        session = HibernateUtil.abrirConexao();
        clienteDao.saveOrAlter(cliente, session);
        
        Cliente clienteAlt = clienteDao.pesquisarPorId(cliente.getId(), session);
        session.close();
        
        System.out.println("Alterado " + clienteAlt);
        System.out.println("Old " + cliente.getId());
        
        
    }
//    @Test
    public void testExcluir(){
        System.out.println("Excluir");
        clienteBd();
        session = HibernateUtil.abrirConexao();
        clienteDao.excluir(cliente, session);
        
        Cliente cliExc = clienteDao.pesquisarPorId(cliente.getId(), session);
        session.close();
        
        assertNull(cliExc.getId());
    }

//    @Test
    public void testPesquisarPorId() {
        System.out.println("pesquisarPorId");
        clienteBd();
        session = HibernateUtil.abrirConexao();
        Cliente pesqCli = clienteDao.pesquisarPorId(cliente.getId(), session);
        session.close();
        
        assertTrue(pesqCli.getNome().isEmpty());
    }

//    @Test
    public void testAskPerName() {
        System.out.println("askPerName");
        clienteBd();
        session = HibernateUtil.abrirConexao();

        List<Cliente> clientes = clienteDao.askPerName(cliente.getNome(), session);
        session.close();
        assertTrue(!clientes.isEmpty());
    }
    
//    @Test
    public void testAskPerListEmail() {
        System.out.println("askPerListEmail");
        clienteBd();
        session = HibernateUtil.abrirConexao();

        List<Cliente> clientes = clienteDao.askListEmail(cliente.getNome(), session);
        session.close();
        assertTrue(!clientes.isEmpty());
    }
    
//    @Test
    public void testAskPerNamePed() {
        System.out.println("askPerNamePed");
        clienteBd();
        session = HibernateUtil.abrirConexao();

        List<Cliente> clientes = clienteDao.askPerNamePed(cliente.getNome(), session);
        session.close();
        assertTrue(!clientes.isEmpty());
    }
    
//    @Test
    public void testAskPerTel(){
        System.out.println("askPerTel");
        clienteBd();
        
        session = HibernateUtil.abrirConexao();
        List<Cliente> clienteTel = clienteDao.askPerTell(cliente.getTelefone(), session);
        session.close();
        
        assertNotNull(clienteTel);
    }
    
    
    public Cliente clienteBd(){
        String hql = "from Cliente c";
        session = HibernateUtil.abrirConexao();
        Query<Cliente> consult = session.createQuery(hql);
        List<Cliente> clientes = consult.getResultList();
        session.close();
        if (clientes.isEmpty()){
            testSalvar();
        } else {
            cliente = clientes.get(0);
        }
        return cliente;
    }

}
