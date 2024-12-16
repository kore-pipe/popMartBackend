package org.koer.com;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
@Slf4j
@EnableWebMvc
@EnableKnife4j
public class PopMartBackendApplication {

	public static void main(String[] args) throws UnknownHostException {

		ConfigurableApplicationContext application = SpringApplication.run(PopMartBackendApplication.class, args);
		Environment env = application.getEnvironment();
		log.info("\n----------------------------------------------------------\n\t" +
						"Application '{}' is running! Access URLs:\n\t" +
						"Local: \t\thttp://localhost:{}\n\t" +
						"External: \thttp://{}:{}\n\t" +
						"Doc: \thttp://{}:{}/doc.html\n" +
						"\t---Staff Mailbox started successfully\n" +
						"\t---启动成功---\n" +
						"----------------------------------------------------------",
				env.getProperty("spring.application.name"),
				env.getProperty("server.port"),
				InetAddress.getLocalHost().getHostAddress(),
				env.getProperty("server.port"),
				InetAddress.getLocalHost().getHostAddress(),
				env.getProperty("server.port"),
				env.getProperty("server.servlet.context-path"));


	}

}
