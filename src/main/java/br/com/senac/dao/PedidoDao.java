/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.dao;

import br.com.senac.entidade.Pedido;
import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author vitor.kuhnen
 */
public interface PedidoDao extends BaseDao<Pedido, Long>{
    
    List<Pedido> askPerDate (Date dataIni, Date dataFim, Session session) throws HibernateException;
    
    
    
}
