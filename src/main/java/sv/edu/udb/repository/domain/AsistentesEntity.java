package sv.edu.udb.repository.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "asistentes", schema = "eventos_catedra")

@NamedQueries({
        @NamedQuery(name = "AsistentesEntity.findAll", query = "SELECT a FROM AsistentesEntity a"),
        @NamedQuery(name = "AsistentesEntity.findById", query = "SELECT a FROM AsistentesEntity a WHERE a.id = :id"),
        @NamedQuery(name = "AsistentesEntity.findByNombre", query = "SELECT a FROM AsistentesEntity a WHERE a.nombre = :nombre"),
        @NamedQuery(name = "AsistentesEntity.findByEmail", query = "SELECT a FROM AsistentesEntity a WHERE a.email = :email"),
        @NamedQuery(name = "AsistentesEntity.findByTelefono", query = "SELECT a FROM AsistentesEntity a WHERE a.telefono = :telefono"),
        @NamedQuery(name = "AsistentesEntity.findByDireccion", query = "SELECT a FROM AsistentesEntity a WHERE a.direccion = :direccion"),
        @NamedQuery(name = "AsistentesEntity.isExist", query = "SELECT COUNT(a) FROM AsistentesEntity a WHERE a.id = :id")
        })

public class AsistentesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;
    @Basic
    @Column(name = "email", nullable = false, length = 100)
    private String email;
    @Basic
    @Column(name = "telefono", nullable = true, length = 20)
    private String telefono;
    @Basic
    @Column(name = "direccion", nullable = true, length = 200)
    private String direccion;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AsistentesEntity that = (AsistentesEntity) o;

        if (id != that.id) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (telefono != null ? !telefono.equals(that.telefono) : that.telefono != null) return false;
        if (direccion != null ? !direccion.equals(that.direccion) : that.direccion != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (telefono != null ? telefono.hashCode() : 0);
        result = 31 * result + (direccion != null ? direccion.hashCode() : 0);
        return result;
    }
}
