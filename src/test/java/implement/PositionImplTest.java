package implement;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.rmi.RemoteException;

import static org.junit.jupiter.api.Assertions.*;

class PositionImplTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void listPosition() throws RemoteException {
        PositionDAO positionDAO = new PositionImpl();
        assertEquals(6, positionDAO.listPosition("position", 10000, 100000).size());
    }


}