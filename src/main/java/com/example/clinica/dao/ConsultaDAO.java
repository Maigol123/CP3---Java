package com.example.clinica.dao;

import com.example.clinica.model.Consulta;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.*;
import java.util.List;

@ApplicationScoped
public class ConsultaDAO {

    @PersistenceContext
    EntityManager em;

    public Consulta cadastrar(Consulta c) {
        em.persist(c);
        return c;
    }

    public Consulta pesquisarPorId(Long id) {
        return em.find(Consulta.class, id);
    }

    public List<Consulta> listar() {
        TypedQuery<Consulta> q = em.createQuery("SELECT c FROM Consulta c", Consulta.class);
        return q.getResultList();
    }

    public Consulta atualizar(Consulta c) {
        return em.merge(c);
    }

    public void remover(Long id) {
        Consulta c = pesquisarPorId(id);
        if (c != null) em.remove(c);
    }
}