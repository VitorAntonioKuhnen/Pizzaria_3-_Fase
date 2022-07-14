/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.dao;

import br.com.senac.entidade.Pedido;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author vitor.kuhnen
 */
public class PedidoDaoImpl extends BaseDaoImpl<Pedido, Long> implements PedidoDao, Serializable{

    @Override
    public Pedido pesquisarPorId(Long id, Session session) throws HibernateException {
        return session.find(Pedido.class, id);
    }

    @Override
    public List<Pedido> askPerDate(Date dataIni, Date dataFim, Session session) throws HibernateException {
        Query<Pedido> consult = session.createQuery("from Pedido p join fetch p.cliente where p.dt_pedido between :dataIni and :dataFim");
        consult.setParameter("dataIni", dataIni);
        consult.setParameter("dataFim", dataFim);
        return consult.getResultList();
    }
    
}
