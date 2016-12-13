package calculator;

public class CalcOperationsImplProxy implements calculator.CalcOperationsImpl {
  private String _endpoint = null;
  private calculator.CalcOperationsImpl calcOperationsImpl = null;
  
  public CalcOperationsImplProxy() {
    _initCalcOperationsImplProxy();
  }
  
  public CalcOperationsImplProxy(String endpoint) {
    _endpoint = endpoint;
    _initCalcOperationsImplProxy();
  }
  
  private void _initCalcOperationsImplProxy() {
    try {
      calcOperationsImpl = (new calculator.CalcOperationsImplServiceLocator()).getCalcOperationsImpl();
      if (calcOperationsImpl != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)calcOperationsImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)calcOperationsImpl)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (calcOperationsImpl != null)
      ((javax.xml.rpc.Stub)calcOperationsImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public calculator.CalcOperationsImpl getCalcOperationsImpl() {
    if (calcOperationsImpl == null)
      _initCalcOperationsImplProxy();
    return calcOperationsImpl;
  }
  
  public float add(float num1, float num2) throws java.rmi.RemoteException{
    if (calcOperationsImpl == null)
      _initCalcOperationsImplProxy();
    return calcOperationsImpl.add(num1, num2);
  }
  
  public float divide(float num1, float num2) throws java.rmi.RemoteException{
    if (calcOperationsImpl == null)
      _initCalcOperationsImplProxy();
    return calcOperationsImpl.divide(num1, num2);
  }
  
  public float multiply(float num1, float num2) throws java.rmi.RemoteException{
    if (calcOperationsImpl == null)
      _initCalcOperationsImplProxy();
    return calcOperationsImpl.multiply(num1, num2);
  }
  
  public float substract(float num1, float num2) throws java.rmi.RemoteException{
    if (calcOperationsImpl == null)
      _initCalcOperationsImplProxy();
    return calcOperationsImpl.substract(num1, num2);
  }
  
  
}