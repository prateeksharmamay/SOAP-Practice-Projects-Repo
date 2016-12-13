/**
 * JDBCConnectorServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package service;

public class JDBCConnectorServiceLocator extends org.apache.axis.client.Service implements service.JDBCConnectorService {

    public JDBCConnectorServiceLocator() {
    }


    public JDBCConnectorServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public JDBCConnectorServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for JDBCConnector
    private java.lang.String JDBCConnector_address = "http://localhost:8085/Lab-3_Ebay_soap_srvice/services/JDBCConnector";

    public java.lang.String getJDBCConnectorAddress() {
        return JDBCConnector_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String JDBCConnectorWSDDServiceName = "JDBCConnector";

    public java.lang.String getJDBCConnectorWSDDServiceName() {
        return JDBCConnectorWSDDServiceName;
    }

    public void setJDBCConnectorWSDDServiceName(java.lang.String name) {
        JDBCConnectorWSDDServiceName = name;
    }

    public service.JDBCConnector getJDBCConnector() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(JDBCConnector_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getJDBCConnector(endpoint);
    }

    public service.JDBCConnector getJDBCConnector(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            service.JDBCConnectorSoapBindingStub _stub = new service.JDBCConnectorSoapBindingStub(portAddress, this);
            _stub.setPortName(getJDBCConnectorWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setJDBCConnectorEndpointAddress(java.lang.String address) {
        JDBCConnector_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (service.JDBCConnector.class.isAssignableFrom(serviceEndpointInterface)) {
                service.JDBCConnectorSoapBindingStub _stub = new service.JDBCConnectorSoapBindingStub(new java.net.URL(JDBCConnector_address), this);
                _stub.setPortName(getJDBCConnectorWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("JDBCConnector".equals(inputPortName)) {
            return getJDBCConnector();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://service", "JDBCConnectorService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://service", "JDBCConnector"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("JDBCConnector".equals(portName)) {
            setJDBCConnectorEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
