package sv.edu.udb.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import sv.edu.udb.repository.domain.CompraBoletosEntity;
import java.util.List;

@Transactional
@ApplicationScoped
public class CompraBoletosRepository {
    @PersistenceContext
    private EntityManager em;
    public List<CompraBoletosEntity> findAll() {
        return em.createNamedQuery("CompraBoletosEntity.findAll").getResultList();
    }
    public CompraBoletosEntity getCompraBoletoPorID(final int id) {
        if (existeBoleto(id) > 0) {
            return em.find(CompraBoletosEntity.class, id);
        } else {
            return null;
        }
    }
    public int saveCompraBoleto(final CompraBoletosEntity boleto) {
        if (existeBoleto(boleto.getId()) > 0) {
            return 0; //Boleto ya existe;
        } else {
            em.persist(boleto); //Guardando el objeto en la BD
            return 1;
        }
    }
    public int updateBoleto(final CompraBoletosEntity boleto) {
        if (existeBoleto(boleto.getId()) > 0) {
            em.merge(boleto); //Guardando el objeto en la BD
            return 1;
        } else {
            return 0;
        }
    }
    public int eliminarBoleto(final int id) {
        int filasBorradas = 0;
        //Recuperando el objeto a eliminar
        final CompraBoletosEntity est = em.find(CompraBoletosEntity.class, id);
        if (est != null) {
            em.remove(est);//Borrando la instancia
            filasBorradas = 1;
        }
        return filasBorradas;
    }
    private Long existeBoleto(final int id) {
        return (Long) em.createNamedQuery("CompraBoletosEntity.isExist").setParameter("id", id).getSingleResult();
    }
}
