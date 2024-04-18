package implement;

import entities.Position;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface PositionDAO extends Remote {
    public List<Position> listPosition(String name, double salaryFrom, double salaryTo) throws RemoteException;
}
