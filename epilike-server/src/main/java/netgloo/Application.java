package netgloo;

import javax.servlet.Servlet;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.server.TServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import eu.epitech.epilike.thrift.EpiLikeService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

    @Bean
    public TProtocolFactory tProtocolFactory() {
        //We will use binary protocol, but it's possible to use JSON and few others as well
        return new TBinaryProtocol.Factory();
    }
    
    @Bean
    public Servlet epilike(TProtocolFactory protocolFactory, EpiLikeServiceImpl handler) {
        return new TServlet(new EpiLikeService.Processor<EpiLikeServiceImpl>(handler), protocolFactory);
    }

}
