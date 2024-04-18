package server;

import implement.CadidateDAO;
import implement.CadidateImpl;
import implement.PositionDAO;
import implement.PositionImpl;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.rmi.registry.LocateRegistry;

/**
 * @description
 * @author: nktng,
 * @date:17/04/2024,
 */
public class Server {
    private static final String URL = "rmi://FIL:8611/";

    public static void main(String[] args) {
        try {
            Context context = new InitialContext();

            CadidateDAO cadidateDAO = new CadidateImpl();

            PositionDAO positionDAO = new PositionImpl();

            LocateRegistry.createRegistry(8611);

            context.bind(URL + "cadidateDAO", cadidateDAO);
            context.bind(URL + "positionDAO", positionDAO);

            System.out.println("Server is running...");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
