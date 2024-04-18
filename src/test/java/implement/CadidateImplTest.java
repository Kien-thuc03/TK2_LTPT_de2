package implement;

import entities.Candidate;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.rmi.RemoteException;
import java.util.Map;

class CadidateImplTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void listCandidateByCompanies() throws RemoteException {
        CadidateDAO cadidateDAO = new CadidateImpl();
        Map<Candidate, Long> map = cadidateDAO.listCandidateByCompanies();
        map.entrySet().forEach(entry -> {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        });
    }

    @Test
    void listCandidateWithLongestWorking() throws RemoteException {
        CadidateDAO cadidateDAO = new CadidateImpl();
        Map<Candidate, Long> map = cadidateDAO.listCandidateWithLongestWorking();
        map.entrySet().forEach(entry -> {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        });
    }
}