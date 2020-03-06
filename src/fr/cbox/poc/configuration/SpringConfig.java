package fr.cbox.poc.configuration;


import java.nio.charset.StandardCharsets;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;

import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.ssl.TrustStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc // active les annotations Spring MVC commen @Controller
@Configuration // indique que cette classe est une fichier de configuration pour obtenir des beans
@ComponentScan(basePackages = "fr.cbox.poc") // indique quels sont les packages à scanner pour récupérer les Controller, Service, Repositories, Beans
@EnableScheduling
public class SpringConfig implements WebMvcConfigurer{
	
	private static final boolean IS_DEVELOPMENT = true;
	/**
	 * Utilisation d'un resttemplate injecté partout dans l'application
	 * @throws KeyStoreException 
	 * @throws NoSuchAlgorithmException 
	 * @throws KeyManagementException 
	 */
	@Bean
	public RestTemplate restTemplate() throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
		
		if (IS_DEVELOPMENT) {
			
			
			TrustStrategy acceptingTrustStrategy = new TrustStrategy() {
				
				@Override
				public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
					return true;
				}
			};
			 
		    SSLContext sslContext = SSLContexts.custom()
		                    		.loadTrustMaterial(null, acceptingTrustStrategy)
		                    		.build();
		 
		    SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext);
		 
		    CloseableHttpClient httpClient = HttpClients.custom()
		                    .setSSLSocketFactory(csf)
		                    .build();
		 
		    HttpComponentsClientHttpRequestFactory requestFactory =
		                    new HttpComponentsClientHttpRequestFactory();
		 
		    requestFactory.setHttpClient(httpClient);
		    RestTemplate restTemplate = new RestTemplate(requestFactory);
		    restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(StandardCharsets.UTF_8));
		    return restTemplate;		
			
		} else {		
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(StandardCharsets.UTF_8));
		return restTemplate;
		}
	}

}
