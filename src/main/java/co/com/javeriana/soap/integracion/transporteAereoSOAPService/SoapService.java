package co.com.javeriana.soap.integracion.transporteAereoSOAPService;

import java.io.IOException;
import java.text.ParseException;

import javax.xml.datatype.DatatypeConfigurationException;

import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;
import org.transporteaereo.demo.CancelarReserva;
import org.transporteaereo.demo.ObtenerReserva;
import org.transporteaereo.demo.RealizarReserva;

@Component
public class SoapService {

	public void cancelarReserva(final Exchange exchange) throws DatatypeConfigurationException, InterruptedException {
		CancelarReserva datos = exchange.getIn().getBody(CancelarReserva.class);
		if(datos.getAgencia().equalsIgnoreCase("avianca")){
			
		}else {
			
		}
	}
	
	public void obtenerReserva(final Exchange exchange)
			throws DatatypeConfigurationException, InterruptedException, ParseException, IOException {
		ObtenerReserva datos = exchange.getIn().getBody(ObtenerReserva.class);
	}
	
	public void realizarReserva(final Exchange exchange)
			throws DatatypeConfigurationException, InterruptedException, ParseException, IOException {
		RealizarReserva datos = exchange.getIn().getBody(RealizarReserva.class);
	}
}
