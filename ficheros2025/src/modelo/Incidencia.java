package modelo;
import java.time.LocalDate;
import java.time.LocalTime;


public class Incidencia {
        private LocalDate fecha;
        private LocalTime hora;
        private String excepcion;
        private String usuario;

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

        public void setFecha(LocalDate fecha) {
                this.fecha = fecha;
        }

        public void setHora(LocalTime hora) {
                this.hora = hora;
        }

        public void setExcepcion(String excepcion) {
                this.excepcion = excepcion;
        }

        public void setUsuario(String usuario) {
                this.usuario = usuario;
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
