package sv.edu.udb.repository.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "eventos_asistentes", schema = "eventos_catedra")

@NamedQueries({
        @NamedQuery(name = "EventosAsistentesEntity.findById", query = "SELECT ea FROM EventosAsistentesEntity ea WHERE ea.id = :id"),
        @NamedQuery(name = "EventosAsistentesEntity.findByIdEvento", query = "SELECT ea FROM EventosAsistentesEntity ea WHERE ea.idEvento = :idEvento"),
        @NamedQuery(name = "EventosAsistentesEntity.findByIdAsistente", query = "SELECT ea FROM EventosAsistentesEntity ea WHERE ea.idAsistente = :idAsistente"),
        @NamedQuery(name = "EventosAsistentesEntity.isExist", query = "SELECT COUNT(ea) FROM EventosAsistentesEntity ea WHERE ea.id = :id")
})

public class EventosAsistentesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "id_evento", nullable = false)
    private int idEvento;
    @Basic
    @Column(name = "id_asistente", nullable = false)
    private int idAsistente;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public int getIdAsistente() {
        return idAsistente;
    }

    public void setIdAsistente(int idAsistente) {
        this.idAsistente = idAsistente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EventosAsistentesEntity that = (EventosAsistentesEntity) o;

        if (id != that.id) return false;
        if (idEvento != that.idEvento) return false;
        if (idAsistente != that.idAsistente) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + idEvento;
        result = 31 * result + idAsistente;
        return result;
    }
}
