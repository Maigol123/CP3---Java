package com.example.clinica.dao;

import com.example.clinica.model.Paciente;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.*;
import java.util.List;

@ApplicationScoped
public class PacienteDAO {

    @PersistenceContext
    EntityManager em;

    public Paciente cadastrar(Paciente p) {
        em.persist(p);
        return p;
    }

    public Paciente pesquisarPorId(Long id) {
        return em.find(Paciente.class, id);
    }

    public List<Paciente> listar() {
        TypedQuery<Paciente> q = em.createQuery("SELECT p FROM Paciente p", Paciente.class);
        return q.getResultList();
    }

    public Paciente atualizar(Paciente p) {
        return em.merge(p);
    }

    public void remover(Long id) {
        Paciente p = pesquisarPorId(id);
        if (p != null) em.remove(p);
    }
}
