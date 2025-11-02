package com.example.clinica.dao;

import com.example.clinica.model.Medico;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.*;
import java.util.List;

@ApplicationScoped
public class MedicoDAO {

    @PersistenceContext
    EntityManager em;

    public Medico cadastrar(Medico m) {
        em.persist(m);
        return m;
    }

    public Medico pesquisarPorId(Long id) {
        return em.find(Medico.class, id);
    }

    public List<Medico> listar() {
        TypedQuery<Medico> q = em.createQuery("SELECT m FROM Medico m", Medico.class);
        return q.getResultList();
    }

    public Medico atualizar(Medico m) {
        return em.merge(m);
    }

    public void remover(Long id) {
        Medico m = pesquisarPorId(id);
        if (m != null) em.remove(m);
    }
}