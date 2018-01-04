package com.lobin;




import org.apache.log4j.xml.DOMConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Lobin
 */
@SpringBootApplication
public class Tiger {
    static {
        DOMConfigurator.configure("classpath:log4j2.xml");

    }
    private static Logger logger= LoggerFactory.getLogger(Tiger.class);
    public static void main(String[] args) {
        logger.error("-------start----------");
        SpringApplication.run(Tiger.class,args);

    }
}
