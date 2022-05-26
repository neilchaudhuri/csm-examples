package com.example.csmexamples;

import io.dekorate.kubernetes.annotation.ImagePullPolicy;
import io.dekorate.kubernetes.annotation.Port;
import io.dekorate.openshift.annotation.OpenshiftApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenshiftApplication(
        name = "hello-world-fwless-openshift",
        ports = @Port(name = "web", containerPort = 8080),
        expose = true,
        imagePullPolicy = ImagePullPolicy.Always
)
public class CsmExamplesApplication {

    public static void main(String[] args) {
        SpringApplication.run(CsmExamplesApplication.class, args);
    }

}
