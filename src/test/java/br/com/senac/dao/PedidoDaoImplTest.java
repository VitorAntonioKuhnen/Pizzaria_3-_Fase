/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.dao;

import br.com.senac.entidade.Cliente;
import br.com.senac.entidade.Pedido;
import java.util.List;
import org.hibernate.Session;
import org.junit.Test;
import static org.junit.Assert.*;
import static br.com.senac.util.GeradorUtil.*;
import java.math.BigDecimal;
import java.util.Collections;
import org.hibernate.query.Query;

/**
 *
 * @author vitor.kuhnen
 */
public class PedidoDaoImplTest {

    private Session session;
    private Pedido pedido;
    private PedidoDao pedidoDao;

//    public PedidoDaoImplTest() {
//        pedidoDao = new PedidoDaoImpl();
//    }
//
//    @Test
//    public void testSalvar() {
//        System.out.println("Salvar");
//        ClienteDaoImplTest cdit = new ClienteDaoImplTest();
//
//        Pedido pedido = gerarPedido();
//        pedido.setCliente(buscarClienteBd());
//        session = HibernateUtil.abrirConexao();
//        pedidoDao.saveOrAlter(pedido, session);
//        session.close();
//        
//        assertNotNull(pedido.getId());
//
//    }
//
////    @Test
//    public void testPesquisarPorId() {
//        System.out.println("pesquisarPorId");
//        Long id = null;
//        Session session = null;
//        PedidoDaoImpl instance = new PedidoDaoImpl();
//        Pedido expResult = null;
//        Pedido result = instance.pesquisarPorId(id, session);
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }
//
////    @Test
//    public void testAskPerName() {
//        System.out.println("askPerName");
//        String nome = "";
//        Session session = null;
//        PedidoDaoImpl instance = new PedidoDaoImpl();
//        List<Pedido> expResult = null;
//        List<Pedido> result = instance.askPerName(nome, session);
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }
//
//    public Cliente buscarClienteBd() {
//        session = HibernateUtil.abrirConexao();
//        Query<Cliente> consulta = session.createQuery("from Cliente c");
//        List<Cliente> clientes = consulta.getResultList();
//        session.close();
//        Collections.shuffle(clientes);
//        return clientes.get(0);
//    }

}
