package sv.edu.udb.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import sv.edu.udb.repository.domain.EventosAsistentesEntity;
import java.util.List;

@Transactional
@ApplicationScoped
public class EventosAsistentesRepository {
    @PersistenceContext
    private EntityManager em;
    public List<EventosAsistentesEntity> findAll() {
        return em.createNamedQuery("EventosAsistentesEntity.findAll").getResultList();
    }
    public EventosAsistentesEntity getEventosAsistentePorID(final int id) {
        if (existeEventosAsistente(id) > 0) {
            return em.find(EventosAsistentesEntity.class, id);
        } else {
            return null;
        }
    }
    public int saveEventosAsistente(final EventosAsistentesEntity registro) {
        if (existeEventosAsistente(registro.getId()) > 0) {
            return 0; //Registro ya existe;
        } else {
            em.persist(registro); //Guardando el objeto en la BD
            return 1;
        }
    }
    public int updateEventosAsistente(final EventosAsistentesEntity registro) {
        if (existeEventosAsistente(registro.getId()) > 0) {
            em.merge(registro); //Guardando el objeto en la BD
            return 1;
        } else {
            return 0;
        }
    }
    public int eliminarEventosAsistente(final int id) {
        int filasBorradas = 0;
        //Recuperando el objeto a eliminar
        final EventosAsistentesEntity est = em.find(EventosAsistentesEntity.class, id);
        if (est != null) {
            em.remove(est);//Borrando la instancia
            filasBorradas = 1;
        }
        return filasBorradas;
    }
    private Long existeEventosAsistente(final int id) {
        return (Long) em.createNamedQuery("EventosAsistentesEntity.isExist").setParameter("id", id).getSingleResult();
    }
}
