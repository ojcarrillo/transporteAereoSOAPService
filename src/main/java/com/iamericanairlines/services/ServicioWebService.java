package com.iamericanairlines.services;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.2.4
 * 2018-05-15T12:08:05.330-05:00
 * Generated source version: 3.2.4
 *
 */
@WebServiceClient(name = "ServicioWebService",
                  wsdlLocation = "file:/src/main/resources/wsdlexterno/IAmericanAirlines.wsdl",
                  targetNamespace = "http://services.IAmericanAirlines.com/")
public class ServicioWebService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://services.IAmericanAirlines.com/", "ServicioWebService");
    public final static QName IAmericanAirlinesPort = new QName("http://services.IAmericanAirlines.com/", "IAmericanAirlinesPort");
    static {
        URL url = null;
        try {
            url = new URL("file:/src/main/resources/wsdlexterno/IAmericanAirlines.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(ServicioWebService.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "file:/src/main/resources/wsdlexterno/IAmericanAirlines.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public ServicioWebService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public ServicioWebService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ServicioWebService() {
        super(WSDL_LOCATION, SERVICE);
    }

    public ServicioWebService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public ServicioWebService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public ServicioWebService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns IAmericanAirlines
     */
    @WebEndpoint(name = "IAmericanAirlinesPort")
    public IAmericanAirlines getIAmericanAirlinesPort() {
        return super.getPort(IAmericanAirlinesPort, IAmericanAirlines.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns IAmericanAirlines
     */
    @WebEndpoint(name = "IAmericanAirlinesPort")
    public IAmericanAirlines getIAmericanAirlinesPort(WebServiceFeature... features) {
        return super.getPort(IAmericanAirlinesPort, IAmericanAirlines.class, features);
    }

}