/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.web.mb;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.web.entidade.Pessoa;
import org.web.persistencia.PessoaDAO;
import org.web.relatorio.Relatorio;

/**
 *
 * @author Ramon
 */
@ManagedBean
@ViewScoped
public class PessoaMB {

    private Pessoa pessoa;
    private PessoaDAO pessoaDAO = new PessoaDAO();
    private List<Pessoa> lista = new ArrayList<Pessoa>();
    private boolean podeEditar;

    @PostConstruct
    public void inicio() {
        lista = pessoaDAO.listar();
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public PessoaDAO getPessoaDAO() {
        return pessoaDAO;
    }

    public void setPessoaDAO(PessoaDAO pessoaDAO) {
        this.pessoaDAO = pessoaDAO;
    }

    public List<Pessoa> getLista() {
        return lista;
    }

    public void setLista(List<Pessoa> lista) {
        this.lista = lista;
    }

    public boolean getPodeEditar() {
        return podeEditar;
    }

    public void setPodeEditar(boolean podeEditar) {
        this.podeEditar = podeEditar;
    }

    public void novoAction() {
        pessoa = new Pessoa();
        podeEditar = true;
    }

    public void visualizarAction() {
        podeEditar = false;
    }

    public void editarAction() {
        podeEditar = true;
    }

    public void salvarAction() {
        pessoaDAO.salvar(pessoa);
        lista = pessoaDAO.listar();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Registro salvo com sucesso!"));
    }

    public void removerAction() {
        pessoaDAO.excluir(pessoa);
        lista = pessoaDAO.listar();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Registro excluido com sucesso!"));
    }

    public void gerarRelatorioAction() {
        Relatorio relatorio = new Relatorio();
        relatorio.getRelatorio();
    }

}
