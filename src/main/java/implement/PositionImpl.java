package implement;

import entities.Position;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 * @description
 * @author: nktng,
 * @date:17/04/2024,
 */
public class PositionImpl extends UnicastRemoteObject implements PositionDAO{
    private static final long serialVersionUID = 1L;
    private EntityManager em;
    public PositionImpl() throws RemoteException {
        em = Persistence.createEntityManagerFactory("SQLDB").createEntityManager();
    }

    @Override
    public List<Position> listPosition(String name, double salaryFrom, double salaryTo) throws RemoteException {
        return em.createNamedQuery("Position.FIND_BY_NAME_AND_SALARY", Position.class)
                .setParameter("name", name)
                .setParameter("salaryFrom", salaryFrom)
                .setParameter("salaryTo", salaryTo)
                .getResultList();
    }
}
