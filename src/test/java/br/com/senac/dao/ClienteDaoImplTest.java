/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.dao;

import br.com.senac.entidade.Cliente;
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
    
    
    public ClienteDaoImplTest() {
        
        clienteDao = new ClienteDaoImpl();
    }

    
    
    @Test
    public void testSalvar(){
        System.out.println("Salvar");
        
        cliente = new Cliente(false, "Vítor", "Vitor@gmail.com", "888888888");
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
