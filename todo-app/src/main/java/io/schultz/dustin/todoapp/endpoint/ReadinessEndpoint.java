package io.schultz.dustin.todoapp.endpoint;

import jdk.jfr.Enabled;

//import org.apache.commons.io.IOUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

@Component
@Endpoint(id = "readiness")
    public class ReadinessEndpoint {

    private String ready ="down";

    @ReadOperation
    public String /*byte[]*/ getReady() throws IOException {
        InputStream in = getClass().getClassLoader()
                .getResourceAsStream( ready+ ".jpg");
        return ready; // IOUtils.toByteArray(in);
    }


    @EventListener(ApplicationReadyEvent.class)
    public void setReady(){
        Random random = new Random();
        boolean n = random.nextBoolean();
        boolean m = random.nextBoolean();
        ready = (n ? "down" : "up") + "\n"+(m ? "down" : "up");
    }




}
