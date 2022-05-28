/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.dao;

import br.com.senac.entidade.Pedido;
import java.util.List;
import org.hibernate.Session;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author vitor.kuhnen
 */
public class PedidoDaoImplTest {
    
    public PedidoDaoImplTest() {
    }

    @Test
    public void testPesquisarPorId() {
        System.out.println("pesquisarPorId");
        Long id = null;
        Session session = null;
        PedidoDaoImpl instance = new PedidoDaoImpl();
        Pedido expResult = null;
        Pedido result = instance.pesquisarPorId(id, session);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testAskPerName() {
        System.out.println("askPerName");
        String nome = "";
        Session session = null;
        PedidoDaoImpl instance = new PedidoDaoImpl();
        List<Pedido> expResult = null;
        List<Pedido> result = instance.askPerName(nome, session);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
