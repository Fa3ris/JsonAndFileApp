package fr.cbox.poc.service;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

import javax.annotation.PostConstruct;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import fr.cbox.poc.model.HeaderFooterResponse;

@Service
public class JsonHeaderFooterService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	private static final String HEADER_FOOTER_URL = "https://exploit-portail-colis-sdev.apps.paas.dev.net-courrier.extra.laposte.fr/laposte_c8_ws/sendHtml";
	
	private static final String HEADER_FOOTER_FILE_PATH = "header_footer.json";
	
	@PostConstruct
	public void getHeaderAndFooter() throws IOException {
		
		
		
		System.out.println("J'appelle cette méthode après être initialisé");
		
		System.out.println("le répertoire de travail est " + System.getProperty("user.dir"));
		
		HeaderFooterResponse response = restTemplate.getForObject(HEADER_FOOTER_URL, HeaderFooterResponse.class);
		
		System.out.println(response);
		
		/*
		try(OutputStreamWriter writer = new OutputStreamWriter(
				new FileOutputStream(HEADER_FOOTER_FILE_PATH), 
				StandardCharsets.UTF_8)) {
			writer.write(respStr);
		}
		*/
		
	}

}
