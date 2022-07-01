/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.contolador;

import br.com.senac.entidade.Cliente;

/**
 *
 * @author vitor.kuhnen
 */

public class Controlador {
    private Cliente cliente;
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
}
