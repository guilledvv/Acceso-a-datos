package modelo;
import java.time.LocalDate;
import java.time.LocalTime;


public class Incidencia {
        private final LocalDate fecha;
        private final LocalTime hora;
        private final String excepcion;
        private final String usuario;

        public Incidencia(LocalDate fecha, LocalTime hora, String excepcion, String usuario) {
                this.fecha = fecha;
                this.hora = hora;
                this.excepcion = excepcion;
                this.usuario = usuario;
        }

        public LocalDate getFecha() {
                return fecha;
        }

        public LocalTime getHora() {
                return hora;
        }

        public String getExcepcion() {
                return excepcion;
        }

        public String getUsuario() {
                return usuario;
        }


        @Override
        public String toString() {
                return "Incidencia{" +
                        "fecha=" + fecha +
                        ", hora=" + hora +
                        ", excepcion='" + excepcion + '\'' +
                        ", usuario='" + usuario + '\'' +
                        '}';
        }
}
