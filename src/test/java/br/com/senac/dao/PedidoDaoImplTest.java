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
import java.util.Date;
import org.hibernate.query.Query;

/**
 *
 * @author vitor.kuhnen
 */
public class PedidoDaoImplTest {

    private Session session;
    private Pedido pedido;
    private PedidoDao pedidoDao;

    public PedidoDaoImplTest() {
        pedidoDao = new PedidoDaoImpl();
    }

    @Test
    public void testSalvar() {
        System.out.println("Salvar");
        ClienteDaoImplTest cdit = new ClienteDaoImplTest();

        Pedido pedido = gerarPedido();
        pedido.setCliente(buscarClienteBd());
        session = HibernateUtil.abrirConexao();
        pedidoDao.saveOrAlter(pedido, session);
        session.close();
        
        assertNotNull(pedido.getId());

    }
    
    @Test
    public void testAlterar(){
        System.out.println("Alterar");
        buscarPedidoBd();
        
        pedido.setCupom("Vitor");
        session = HibernateUtil.abrirConexao();
        pedidoDao.saveOrAlter(pedido, session);
        
        Pedido pedidoAlt = pedidoDao.pesquisarPorId(pedido.getId(), session);
        session.close();
        
        assertTrue(pedido.getCupom().equals(pedidoAlt.getCupom()));
    }
    
    @Test
    public void testExcluir(){
        System.out.println("Excluir");
        buscarPedidoBd();
        session = HibernateUtil.abrirConexao();
        pedidoDao.excluir(pedido, session);
        
        Pedido pedExc = pedidoDao.pesquisarPorId(pedido.getId(), session);
        
        session.close();
        
        assertNull(pedExc);
    }
    
    

//    @Test
    public void testPesquisarPorId() {
        System.out.println("pesquisarPorId");
        buscarPedidoBd();
        session = HibernateUtil.abrirConexao();
        Pedido pedId = pedidoDao.pesquisarPorId(pedido.getId(), session);
        session.close();
        
        assertTrue(pedId.getInf_pedidos().isEmpty());
    }

//    @Test
    public void testAskPerDate() {
        System.out.println("askPerName");
        buscarPedidoBd();
        Date dt = new Date();
        
        session = HibernateUtil.abrirConexao();
        List<Pedido> pedName = pedidoDao.askPerDate(dt, dt, session);
        session.close();
        assertTrue(pedName.isEmpty());
    }

    public Cliente buscarClienteBd() {
        session = HibernateUtil.abrirConexao();
        Query<Cliente> consulta = session.createQuery("from Cliente c");
        List<Cliente> clientes = consulta.getResultList();
        session.close();
        Collections.shuffle(clientes);
        return clientes.get(0);
    }
    
    public Pedido buscarPedidoBd(){
        session = HibernateUtil.abrirConexao();
        Query<Pedido> consulta = session.createQuery("from Pedido p");
        List<Pedido> pedidos = consulta.getResultList();
        session.close();
        Collections.shuffle(pedidos);
        return pedidos.get(0);
    }

}
