package remote;

import org.apache.commons.lang3.StringUtils;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class MyRemoteService extends UnicastRemoteObject implements MyRemote {

    protected MyRemoteService() throws RemoteException {
        super();
    }

    @Override
    public String hello(String name) {
        return "null" + name;
    }

    public static void main(String[] args) throws RemoteException, AlreadyBoundException, MalformedURLException {
        Registry registry = LocateRegistry.createRegistry(8888);

        MyRemote myRemote = new MyRemoteService();
        registry.bind("MyRemote", myRemote);
    }
}
