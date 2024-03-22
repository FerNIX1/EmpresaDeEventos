package sv.edu.udb.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import sv.edu.udb.repository.domain.AsistentesEntity;
import java.util.List;


@Transactional
@ApplicationScoped
public class AsistentesRepository {
    @PersistenceContext
    private EntityManager em;
    public List<AsistentesEntity> findAll() {
        return em.createNamedQuery("AsistentesEntity.findAll").getResultList();
    }
    public AsistentesEntity getAsistentePorID(final int id) {
        if (existeAsistente(id) > 0) {
            return em.find(AsistentesEntity.class, id);
        } else {
            return null;
        }
    }
    public int saveAsistente(final AsistentesEntity asistente) {
        if (existeAsistente(asistente.getId()) > 0) {
            return 0; //Asistente ya existe;
        } else {
            em.persist(asistente); //Guardando el objeto en la BD
            return 1;
        }
    }
    public int updateAsistente(final AsistentesEntity asistente) {
        if (existeAsistente(asistente.getId()) > 0) {
            em.merge(asistente); //Guardando el objeto en la BD
            return 1;
        } else {
            return 0;
        }
    }
    public int eliminarAsistente(final int id) {
        int filasBorradas = 0;
        //Recuperando el objeto a eliminar
        final AsistentesEntity est = em.find(AsistentesEntity.class, id);
        if (est != null) {
            em.remove(est);//Borrando la instancia
            filasBorradas = 1;
        }
        return filasBorradas;
    }
    private Long existeAsistente(final int id) {
        return (Long) em.createNamedQuery("AsistentesEntity.isExist").setParameter("id", id).getSingleResult();
    }
}
