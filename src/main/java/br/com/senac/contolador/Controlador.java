/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.contolador;

import br.com.senac.dao.ClienteDao;
import br.com.senac.dao.ClienteDaoImpl;
import br.com.senac.dao.HibernateUtil;
import br.com.senac.dao.UsuarioDao;
import br.com.senac.dao.UsuarioDaoImpl;
import br.com.senac.entidade.Cliente;
import org.hibernate.Hibernate;
import org.hibernate.Session;

/**
 *
 * @author vitor.kuhnen
 */

public class Controlador {
    private Cliente cliente;
    private ClienteDao clienteDao = new ClienteDaoImpl();
    private Session session;
    
    public Boolean valida_Cliente(String nome, String email, String telefone){
        if (nome.length() > 3 && telefone.length() >= 12 && email.contains("@") && email.contains(".")){
          cliente.setNome(nome);
          cliente.setEmail(email);
          cliente.setTelefone(telefone);
          return true;
        } else{
            return false;
        }
    }
    
    public Boolean valida_email(String email){
        if(email.contains("@") && email.contains(".")){
            try {
                session = HibernateUtil.abrirConexao();
                System.out.println(email);
                clienteDao.askPerEmail(email, session);
                
            } catch (Exception e) {
                System.out.println(e);
            }finally{
                session.close();
            }
            
            return false;
        }
        else{
            return true;
        }
    }
}
