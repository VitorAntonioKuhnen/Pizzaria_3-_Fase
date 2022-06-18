/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.dao;

import br.com.senac.entidade.Cliente;
import br.com.senac.entidade.Usuario;
import java.io.Serializable;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author vitor.kuhnen
 */
public class UsuarioDaoImpl extends BaseDaoImpl<Usuario, Long> implements UsuarioDao, Serializable {

    @Override
    public Usuario pesquisarPorId(Long id, Session session) throws HibernateException {
        return session.find(Usuario.class, id);
    }

    @Override
    public Usuario askPerUserAndPassword(String usuario, String senha, Session session) throws HibernateException {
        Query<Usuario> consultUser = session.createQuery("from Usuario u where u.user = :user");
        consultUser.setParameter("user", usuario);
        Boolean user = consultUser.getResultList().isEmpty();
        
        Query<Usuario> consultPassword = session.createQuery("from Usuario where senha = :senha");
        consultPassword.setParameter("senha", senha);
        Boolean password = consultPassword.getResultList().isEmpty();
        
        if (password == false && user == false) {
            return (Usuario) consultPassword.getResultList();
        }else{
            return null;
        }
    }

}
