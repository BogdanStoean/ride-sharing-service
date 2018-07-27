package ro.esolutions.ridesharingservice;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class RideSharingServiceApplication {

	public static void main(String[] args) {
//		SpringApplication.run(RideSharingServiceApplication.class, args);

//		SpringApplication application = new SpringApplication(RideSharingServiceApplication.class);
//        application.setBannerMode(Banner.Mode.OFF);
//        application.run(args);

		SpringApplicationBuilder applicationBuilder = new SpringApplicationBuilder()
				.bannerMode(Banner.Mode.CONSOLE)
//				.registerShutdownHook(true)
				.sources(RideSharingServiceApplication.class);
		applicationBuilder.run(args);
	}

}
