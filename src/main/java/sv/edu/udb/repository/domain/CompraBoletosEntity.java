package sv.edu.udb.repository.domain;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "compra_boletos", schema = "eventos_catedra")

@NamedQueries({
        @NamedQuery(name = "CompraBoletosEntity.findAll", query = "SELECT cb FROM CompraBoletosEntity cb"),
        @NamedQuery(name = "CompraBoletosEntity.findById", query = "SELECT cb FROM CompraBoletosEntity cb WHERE cb.id = :id"),
        @NamedQuery(name = "CompraBoletosEntity.findByIdEvento", query = "SELECT cb FROM CompraBoletosEntity cb WHERE cb.idEvento = :idEvento"),
        @NamedQuery(name = "CompraBoletosEntity.findByIdAsistente", query = "SELECT cb FROM CompraBoletosEntity cb WHERE cb.idAsistente = :idAsistente"),
        @NamedQuery(name = "CompraBoletosEntity.findByCantidad", query = "SELECT cb FROM CompraBoletosEntity cb WHERE cb.cantidad = :cantidad"),
        @NamedQuery(name = "CompraBoletosEntity.findByPrecioTotal", query = "SELECT cb FROM CompraBoletosEntity cb WHERE cb.precioTotal = :precioTotal"),
        @NamedQuery(name = "CompraBoletosEntity.findByFechaCompra", query = "SELECT cb FROM CompraBoletosEntity cb WHERE cb.fechaCompra = :fechaCompra"),
        @NamedQuery(name = "CompraBoletosEntity.isExist", query = "SELECT COUNT(cb) FROM CompraBoletosEntity cb WHERE cb.id = :id")
})

public class CompraBoletosEntity {
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
    @Basic
    @Column(name = "cantidad", nullable = false)
    private int cantidad;
    @Basic
    @Column(name = "precio_total", nullable = false, precision = 2)
    private BigDecimal precioTotal;
    @Basic
    @Column(name = "fecha_compra", nullable = true)
    private Timestamp fechaCompra;

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

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(BigDecimal precioTotal) {
        this.precioTotal = precioTotal;
    }

    public Timestamp getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Timestamp fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CompraBoletosEntity that = (CompraBoletosEntity) o;

        if (id != that.id) return false;
        if (idEvento != that.idEvento) return false;
        if (idAsistente != that.idAsistente) return false;
        if (cantidad != that.cantidad) return false;
        if (precioTotal != null ? !precioTotal.equals(that.precioTotal) : that.precioTotal != null) return false;
        if (fechaCompra != null ? !fechaCompra.equals(that.fechaCompra) : that.fechaCompra != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + idEvento;
        result = 31 * result + idAsistente;
        result = 31 * result + cantidad;
        result = 31 * result + (precioTotal != null ? precioTotal.hashCode() : 0);
        result = 31 * result + (fechaCompra != null ? fechaCompra.hashCode() : 0);
        return result;
    }
}
