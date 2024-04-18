package implement;

import entities.Candidate;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CadidateImpl extends UnicastRemoteObject implements CadidateDAO {
    private static final long serialVersionUID = 1L;
    private EntityManager em;

    public CadidateImpl() throws RemoteException {
        em = Persistence.createEntityManagerFactory("SQLDB").createEntityManager();
    }

    @Override
    public Map<Candidate,Long> listCandidateByCompanies() throws RemoteException {
        List<Object[]> results = em.createQuery(
                "SELECT c.id, COUNT(DISTINCT e.companyName) " +
                        "FROM Candidate c JOIN c.experiences e " +
                        "GROUP BY c.id",
                Object[].class)
                .getResultList();
        Map<Candidate, Long> map = new HashMap<>();
        for (Object[] result : results) {
            Candidate candidate = em.find(Candidate.class, result[0]);
            map.put(candidate, (Long) result[1]);
        }
        return map;
    }

//    @Override
//    public Map<Candidate,Long> listCandidateWithLongestWorking() throws RemoteException {
//        List<Object[]> results = em.createQuery(
//                "SELECT c, MAX(e.toDate - e.fromDate) " +
//                        "FROM Candidate c JOIN c.experiences e " +
//                        "GROUP BY c.id",
//                Object[].class)
//                .getResultList();
//        Map<Candidate, Long> map = new HashMap<>();
//        for (Object[] result : results) {
//            Candidate candidate = em.find(Candidate.class, result[0]);
//            map.put(candidate, (Long) result[1]);
//        }
//        return map;
//    }
@Override
public Map<Candidate,Long> listCandidateWithLongestWorking() throws RemoteException {
    List<Object[]> results = em.createQuery(
            "SELECT c.id, MAX(e.toDate - e.fromDate) " +
                    "FROM Candidate c JOIN c.experiences e " +
                    "GROUP BY c.id",
            Object[].class)
            .getResultList();
    Map<Candidate, Long> map = new HashMap<>();
    for (Object[] result : results) {
        Candidate candidate = em.find(Candidate.class, result[0]);
        Duration duration = (Duration) result[1];
        map.put(candidate, duration.toDays());
    }
    return map;
}
}