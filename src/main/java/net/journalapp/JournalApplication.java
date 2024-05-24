package net.journalapp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Arrays;

@SpringBootApplication
@EnableTransactionManagement
@Slf4j
public class JournalApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(JournalApplication.class, args);
		Environment env = ctx.getEnvironment();
		log.info("Environment Profiles {}", Arrays.stream(env.getActiveProfiles()).toArray()[1]);
	}

	@Bean
	public PlatformTransactionManager getTxnManager(MongoDatabaseFactory dbFactory){
		return new MongoTransactionManager(dbFactory);
	}
}
