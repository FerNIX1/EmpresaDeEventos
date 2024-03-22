package sv.edu.udb.repository.domain;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "eventos", schema = "eventos_catedra")

@NamedQueries({
        @NamedQuery(name = "EventosEntity.findAll", query = "SELECT e FROM EventosEntity e"),
        @NamedQuery(name = "EventosEntity.findById", query = "SELECT e FROM EventosEntity e WHERE e.id = :id"),
        @NamedQuery(name = "EventosEntity.findByNombre", query = "SELECT e FROM EventosEntity e WHERE e.nombre = :nombre"),
        @NamedQuery(name = "EventosEntity.findByFecha", query = "SELECT e FROM EventosEntity e WHERE e.fecha = :fecha"),
        @NamedQuery(name = "EventosEntity.findByHora", query = "SELECT e FROM EventosEntity e WHERE e.hora = :hora"),
        @NamedQuery(name = "EventosEntity.findByLugar", query = "SELECT e FROM EventosEntity e WHERE e.lugar = :lugar"),
        @NamedQuery(name = "EventosEntity.findByDescripcion", query = "SELECT e FROM EventosEntity e WHERE e.descripcion = :descripcion"),
        @NamedQuery(name = "EventosEntity.findByTipoEvento", query = "SELECT e FROM EventosEntity e WHERE e.tipoEvento = :tipoEvento"),
        @NamedQuery(name = "EventosEntity.isExist", query = "SELECT COUNT(e) FROM EventosEntity e WHERE e.id = :id")
})

public class EventosEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;
    @Basic
    @Column(name = "fecha", nullable = false)
    private Date fecha;
    @Basic
    @Column(name = "hora", nullable = false)
    private Time hora;
    @Basic
    @Column(name = "lugar", nullable = false, length = 100)
    private String lugar;
    @Basic
    @Column(name = "descripcion", nullable = true, length = -1)
    private String descripcion;
    @Basic
    @Column(name = "tipo_evento", nullable = false)
    private Object tipoEvento;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Object getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(Object tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EventosEntity that = (EventosEntity) o;

        if (id != that.id) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (fecha != null ? !fecha.equals(that.fecha) : that.fecha != null) return false;
        if (hora != null ? !hora.equals(that.hora) : that.hora != null) return false;
        if (lugar != null ? !lugar.equals(that.lugar) : that.lugar != null) return false;
        if (descripcion != null ? !descripcion.equals(that.descripcion) : that.descripcion != null) return false;
        if (tipoEvento != null ? !tipoEvento.equals(that.tipoEvento) : that.tipoEvento != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (fecha != null ? fecha.hashCode() : 0);
        result = 31 * result + (hora != null ? hora.hashCode() : 0);
        result = 31 * result + (lugar != null ? lugar.hashCode() : 0);
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        result = 31 * result + (tipoEvento != null ? tipoEvento.hashCode() : 0);
        return result;
    }
}
