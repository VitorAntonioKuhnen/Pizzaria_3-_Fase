/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.contolador;

import br.com.senac.dao.HibernateUtil;
import br.com.senac.tela.TelaInicial;
import java.awt.Window;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;

/**
 *
 * @author Vítor
 */
public class ProgressBar extends SwingWorker<Void, Integer>{
    
    private Window telaPai;
    private JProgressBar progresso;
    
    public ProgressBar(Window telaPai, JProgressBar progresso) {
        this.telaPai = telaPai;
        this.progresso = progresso;
    } 
    
    @Override
    protected Void doInBackground() throws Exception {
        HibernateUtil.abrirConexao();
        Thread.sleep(1000);
        
        this.telaPai.dispose();
        new TelaInicial().setVisible(true);
        return null;
    }
    
}
