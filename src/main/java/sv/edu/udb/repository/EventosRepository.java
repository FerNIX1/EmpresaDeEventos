package sv.edu.udb.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import sv.edu.udb.repository.domain.EventosEntity;
import java.util.List;

@Transactional
@ApplicationScoped
public class EventosRepository {
    @PersistenceContext
    private EntityManager em;
    public List<EventosEntity> findAll() {
        return em.createNamedQuery("EventosEntity.findAll").getResultList();
    }
    public EventosEntity getEventosPorID(final int id) {
        if (existeEventos(id) > 0) {
            return em.find(EventosEntity.class, id);
        } else {
            return null;
        }
    }
    public int saveEventos(final EventosEntity registro) {
        if (existeEventos(registro.getId()) > 0) {
            return 0; //Registro ya existe;
        } else {
            em.persist(registro); //Guardando el objeto en la BD
            return 1;
        }
    }
    public int updateEventos(final EventosEntity registro) {
        if (existeEventos(registro.getId()) > 0) {
            em.merge(registro); //Guardando el objeto en la BD
            return 1;
        } else {
            return 0;
        }
    }
    public int eliminarEventos(final int id) {
        int filasBorradas = 0;
        //Recuperando el objeto a eliminar
        final EventosEntity est = em.find(EventosEntity.class, id);
        if (est != null) {
            em.remove(est);//Borrando la instancia
            filasBorradas = 1;
        }
        return filasBorradas;
    }
    private Long existeEventos(final int id) {
        return (Long) em.createNamedQuery("EventosEntity.isExist").setParameter("id", id).getSingleResult();
    }
}
