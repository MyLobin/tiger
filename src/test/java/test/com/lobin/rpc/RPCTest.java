package test.com.lobin.rpc;

import com.lobin.rpc.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.net.InetSocketAddress;

public class RPCTest {
    private static final Logger logger = LogManager.getLogger(RPCTest.class);

    @Value("${logging.config}")
    private String logPath;
    @Value("${server.port}")
    private String port;
 
    public static void main(String[] args) throws IOException {
        System.out.println(new RPCTest().logPath);
        System.out.println(new RPCTest().port);
        new Thread(new Runnable() {
            public void run() {
                try {
                    Server serviceServer = new ServiceCenter(8088);
                    serviceServer.register(HelloService.class, HelloServiceImpl.class);
                    serviceServer.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        HelloService service = RPCClient.getRemoteProxyObj(HelloService.class, new InetSocketAddress("localhost", 8088));
        System.out.println(service.sayHi("test"));
        logger.error("error--");
    }
}