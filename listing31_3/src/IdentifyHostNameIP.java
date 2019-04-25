
//IMPORTS
import java.net.*;
import java.net.InetAddress;

/**
 *
 * @author kp0885055
 */
public class IdentifyHostNameIP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            try {
                InetAddress address = InetAddress.getByName(args[i]);
                System.out.println("Host Name: " + address.getHostName());
                System.out.println("IP Address: " + address.getHostAddress());
            } catch (UnknownHostException ex) {
                System.err.println("Unknown Host or IP address " + args[i]);
            }
        }
    }

}
