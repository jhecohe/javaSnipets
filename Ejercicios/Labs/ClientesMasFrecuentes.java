package Labs;

import java.time.LocalDate;

/**
* ClientesMasFrecuentes
*/
public class ClientesMasFrecuentes {


    class Cliente {
        String Id;
        Long importe;
        LocalDate fecha;

        public Cliente(String id, Long importe, LocalDate fecha){
            this.Id = id;
            this.importe = importe;
        }

		public String getId() {
			return Id;
		}
		public void setId(String id) {
			Id = id;
		}
		public Long getImporte() {
			return importe;
		}
		public void setImporte(Long importe) {
			this.importe = importe;
		}
		public LocalDate getfecha() {
			return fecha;
		}
		public void setfecha(LocalDate fecha) {
			this.fecha = fecha;
		}

    }
}
