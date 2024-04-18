package implement;

import entities.Candidate;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;

public interface CadidateDAO extends Remote {
    public Map<Candidate,Long> listCandidateByCompanies() throws RemoteException;
    public Map<Candidate, Long> listCandidateWithLongestWorking() throws RemoteException;
}
