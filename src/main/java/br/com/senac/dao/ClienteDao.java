/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.dao;

import br.com.senac.entidade.Cliente;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author vitor.kuhnen
 */
public interface ClienteDao extends BaseDao<Cliente, Long>{
    List<Cliente> askPerName(String nome, Session session) throws HibernateException;
    
    List<Cliente> askPerNamePed(String nome, Session session) throws HibernateException;
    
    List<Cliente> askPerTell(String telefone, Session session) throws HibernateException;
    
    List<Cliente> askPerTellPed(String telefone, Session session) throws HibernateException;
    
    List<Cliente> askListEmail(String email, Session session) throws HibernateException;
    
    String askPerEmail(String email, Session session) throws HibernateException;
    
}
