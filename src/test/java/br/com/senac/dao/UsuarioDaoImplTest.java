/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.dao;

import br.com.senac.entidade.Pedido;
import br.com.senac.entidade.Usuario;
import java.util.Collections;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Vítor
 */
public class UsuarioDaoImplTest {
    private Usuario usuario;
    private UsuarioDao usuarioDao;
    private Session session;
    
    
    public UsuarioDaoImplTest() {
        usuarioDao = new UsuarioDaoImpl();
    }
    
    @Test
    public void testSalvar(){
        System.out.println("Salvar");
        usuario = new Usuario("admin", "admin", "");
        session = HibernateUtil.abrirConexao();
        usuarioDao.saveOrAlter(usuario, session);
        
        Usuario use = usuarioDao.pesquisarPorId(usuario.getId(), session);
        session.close();
        assertNotNull(use.getUser());
    }
    
    @Test
    public void testAlterar(){
        System.out.println("Alterar");
        buscarUsuarioBd();
        usuario.setUser("V123");
        
        session = HibernateUtil.abrirConexao();
        usuarioDao.saveOrAlter(usuario, session);
        
        Usuario userAlt = usuarioDao.pesquisarPorId(usuario.getId(), session);
        
        session.close();
        
        assertTrue(usuario.getUser().equals(userAlt.getUser()));
    }
    
    @Test
    public void testExcluir(){
        System.out.println("Excluir");
        buscarUsuarioBd();
        session = HibernateUtil.abrirConexao();
        usuarioDao.excluir(usuario, session);
        
        Usuario userDel = usuarioDao.pesquisarPorId(usuario.getId(), session);
        session.close();
        
        assertNull(userDel);
                
    }
    
    

    @Test
    public void testPesquisarPorId() {
        System.out.println("pesquisarPorId");
        buscarUsuarioBd();
        
        session = HibernateUtil.abrirConexao();
        Usuario userAskID = usuarioDao.pesquisarPorId(usuario.getId(), session);
        session.close();
        assertNotNull(userAskID);
        
    }

    @Test
    public void testAskPerUserAndPassword() {
        System.out.println("askPerUserAndPassword");
        buscarUsuarioBd();
        
        session = HibernateUtil.abrirConexao();
        Usuario userEPassAsk = usuarioDao.askPerUserAndPassword(usuario.getUser(), usuario.getSenha(), session);
        session.close();
        
        assertNotNull(userEPassAsk);
    }
    
    public Usuario buscarUsuarioBd(){
        session = HibernateUtil.abrirConexao();
        Query<Usuario> consulta = session.createQuery("from Usuario u");
        List<Usuario> usuarios = consulta.getResultList();
        session.close();
        Collections.shuffle(usuarios);
        return usuarios.get(0);
    }
    
}
