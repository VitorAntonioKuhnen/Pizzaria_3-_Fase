/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.dao;

import br.com.senac.entidade.Cliente;
import br.com.senac.entidade.Usuario;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author vitor.kuhnen
 */
public interface UsuarioDao extends BaseDao<Usuario, Long>{
    Usuario askPerUserAndPassword(String usuario, String senha, Session session) throws HibernateException;
}
