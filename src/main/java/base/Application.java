/*package base;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

*//**
 * startup class
 * 
 *//*
@SpringBootApplication
@EnableTransactionManagement
@ServletComponentScan
public class Application {
	*//**
	 * 文件上传大小配置
	 * 
	 * @return
	 *//*
	@Bean
	public MultipartConfigElement multipartConfigElement() {
		MultipartConfigFactory factory = new MultipartConfigFactory();
		// 单个文件最大
		factory.setMaxFileSize("10240KB"); // KB,MB
		// / 设置总上传数据总大小
		factory.setMaxRequestSize("10240KB");
		return factory.createMultipartConfig();
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
*/