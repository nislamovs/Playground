
import java.net.InetAddress;
import java.net.UnknownHostException;

public class NsLookup {

    public static void main(String[] args) throws Exception {
//        for(int n = 0; n < args.length; n++) {
//            System.out.println("Arg. no " + n + ": " + args[n]);
//        }

        String host = args[0];

        try {

            InetAddress inetHost = InetAddress.getByName(host);
            String hostName = inetHost.getHostName();
            System.out.println("The host name was: " + hostName);
            System.out.println("The hosts IP address is: " + inetHost.getHostAddress());

        } catch(UnknownHostException ex) {
            System.out.println("Unrecognized host");
        }

        System.out.println("Done!!!");
    }
}