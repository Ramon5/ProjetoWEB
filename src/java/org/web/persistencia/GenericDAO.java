/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.web.persistencia;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Ramon
 */
public abstract class GenericDAO <T>{
    
    private static EntityManager em;
    private Class<T> classe;

    public GenericDAO(Class<T> classe) {
        this.classe = classe;
        if(em == null){
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("PessoaPU");
            em = emf.createEntityManager();
        }
    }
    
    public void salvar(T entidade){
        em.getTransaction().begin();
        em.merge(entidade);
        em.flush();
        em.getTransaction().commit();
    }
    
    public void excluir(T entidade){
        em.getTransaction().begin();
        em.remove(entidade);
        em.flush();
        em.getTransaction().commit();
    }
    
    public T recuperar(Long id){
        return em.find(classe, id);
    }
    
    public List<T> listar(){
        return em.createQuery("from " + classe.getSimpleName() + " e").getResultList();   
    }
    
}
