package sv.edu.udb.views;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import sv.edu.udb.common.JsfUtil;
import sv.edu.udb.repository.domain.AsistentesEntity;
import sv.edu.udb.repository.AsistentesRepository;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped
public class AsistentesView implements Serializable {
    @Inject
    private AsistentesRepository asistentesRepository;
    private AsistentesEntity asistente;
    private List<AsistentesEntity> listaAsistentes;
    @PostConstruct
    public void init() {
        asistente = new AsistentesEntity();
        listaAsistentes = new ArrayList<>();
    }
    public AsistentesEntity getAsistente() {
        return asistente;
    }
    public void setAsistente(AsistentesEntity asistente) {
        this.asistente = asistente;
    }
    public List<AsistentesEntity> getListaAsistentes() {
        return asistentesRepository.findAll();
    }
    public void guardarAsistente() {
        if (asistentesRepository.saveAsistente(asistente) != 1) {
            JsfUtil.setErrorMessage(null, "Ya se registró un alumno con este carnet");
        } else {
            JsfUtil.setFlashMessage("exito", "Alumno registrado exitosamente");
        }
    }
}

