package co.com.javeriana.soap.integracion.transporteAereoSOAPService;

import java.io.IOException;
import java.text.ParseException;
import java.util.Collection;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;

import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;
import org.transporteaereo.demo.CancelarReserva;
import org.transporteaereo.demo.CancelarReservaResponse;
import org.transporteaereo.demo.ObtenerReserva;
import org.transporteaereo.demo.ObtenerReservaResponse;
import org.transporteaereo.demo.RealizarReserva;
import org.transporteaereo.demo.RealizarReservaResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iamericanairlines.services.Reserva;
import com.iamericanairlines.services.Response;
import com.iamericanairlines.services.ServicioWebService;

@Component
public class SoapServiceAmericanAir {

	private static final String URL_SOAP_SERVICE = "http://localhost:7002/IAmericanAirlines";

	public void cancelarReserva(final Exchange exchange) throws DatatypeConfigurationException, InterruptedException {
		CancelarReserva datos = exchange.getIn().getBody(CancelarReserva.class);
		ServicioWebService ws = new ServicioWebService();
		Response resp = ws.getIAmericanAirlinesPort().cancelarReserva(datos.getIdReserva());
		CancelarReservaResponse response = new CancelarReservaResponse();
		response.setCodigo(resp.getCodigo());
		response.setEstado(resp.getEstado());
		response.setMensaje(resp.getMensaje());
		exchange.getOut().setBody(response);
	}

	public void obtenerReserva(final Exchange exchange)
			throws DatatypeConfigurationException, InterruptedException, ParseException, IOException {
		ObtenerReserva datos = exchange.getIn().getBody(ObtenerReserva.class);
		ServicioWebService ws = new ServicioWebService();
		Reserva resp = ws.getIAmericanAirlinesPort().consultarReserva(datos.getIdReserva());
		ObtenerReservaResponse response = new ObtenerReservaResponse();
		response.setIdReserva(resp.getIdReserva());
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = mapper.writeValueAsString(resp.getVuelo());
		response.setVuelo(mapper.readValue(jsonInString, org.transporteaereo.demo.Vuelo.class));
		jsonInString = mapper.writeValueAsString(resp.getPasajeros());
		response.getPasajeros().addAll((Collection<? extends org.transporteaereo.demo.Persona>) mapper.readValue(
				jsonInString,
				mapper.getTypeFactory().constructCollectionType(List.class, org.transporteaereo.demo.Persona.class)));
		exchange.getOut().setBody(response);
	}

	public void realizarReserva(final Exchange exchange)
			throws DatatypeConfigurationException, InterruptedException, ParseException, IOException {
		RealizarReserva datos = exchange.getIn().getBody(RealizarReserva.class);
		ObjectMapper mapper = new ObjectMapper();
		ServicioWebService ws = new ServicioWebService();
		Reserva reserva = new Reserva();
		reserva.setIdReserva(datos.getIdReserva());
		String jsonInString = mapper.writeValueAsString(datos.getVuelo());
		reserva.setVuelo(mapper.readValue(jsonInString, com.iamericanairlines.services.Vuelo.class));
		jsonInString = mapper.writeValueAsString(datos.getPasajeros());
		reserva.getPasajeros()
				.addAll((Collection<? extends com.iamericanairlines.services.Persona>) mapper.readValue(jsonInString,
						mapper.getTypeFactory().constructCollectionType(List.class,
								com.iamericanairlines.services.Persona.class)));
		Response resp = ws.getIAmericanAirlinesPort().realizarReserva(reserva);
		RealizarReservaResponse response = new RealizarReservaResponse();
		response.setCodigo(resp.getCodigo());
		response.setEstado(resp.getEstado());
		response.setMensaje(resp.getMensaje());
		exchange.getOut().setBody(response);
	}

}
