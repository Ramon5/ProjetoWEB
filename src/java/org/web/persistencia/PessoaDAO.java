/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.web.persistencia;

import org.web.entidade.Pessoa;

/**
 *
 * @author Ramon
 */
public class PessoaDAO extends GenericDAO<Pessoa>{
    
    public PessoaDAO() {
        super(Pessoa.class);
    }
    
}
