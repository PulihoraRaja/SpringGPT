package com.LowellGpt.ExamApp.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OpenAIService {

	@Value("${openai.api-key}")
	private String apiKey;

	@Value("${openai.model-number}")
	private String modelNumber;

	private final String apiUrl = "https://api.openai.com/v1/chat/completions";

	public String queryChatGPT(String prompt) {
		HttpHeaders headers = new HttpHeaders();
		headers.setBearerAuth(apiKey);
		headers.setContentType(MediaType.APPLICATION_JSON);

		String requestBody = "{\"model\":\"" + modelNumber
				+ "\",\"messages\":[{\"role\":\"user\",\"content\":\"" + prompt
				+ "\"}]}";

		System.out.println(requestBody);

		HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

		ResponseEntity<String> responseEntity = new RestTemplate().exchange(apiUrl, HttpMethod.POST, requestEntity,
				String.class);

		return responseEntity.getBody();
	}
}