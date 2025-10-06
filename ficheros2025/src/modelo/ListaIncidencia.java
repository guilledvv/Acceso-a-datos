package modelo;

import java.util.ArrayList;
import java.util.List;

public class ListaIncidencia {

    private final List<Incidencia> lista;

    public ListaIncidencia() {
        this.lista = new ArrayList<>();
    }

    public void agregarIncidencia(Incidencia incidencia) {
        lista.add(incidencia);
    }

    public List<Incidencia> getLista() {
        return new ArrayList<>(lista); // devuelve copia para proteger la lista original
    }


}
