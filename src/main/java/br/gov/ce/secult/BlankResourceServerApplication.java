package br.gov.ce.secult;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ScopedProxyMode;

@ComponentScan(scopedProxy = ScopedProxyMode.INTERFACES)
@SpringBootApplication
public class BlankResourceServerApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(BlankResourceServerApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(BlankResourceServerApplication.class);
	}
}
