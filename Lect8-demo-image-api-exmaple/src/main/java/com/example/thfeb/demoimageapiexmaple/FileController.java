package com.example.thfeb.demoimageapiexmaple;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class FileController {

	@GetMapping(value = "/getFile", produces = MediaType.IMAGE_PNG_VALUE)
	public byte[] displayFileContent(@RequestParam("id") int id) {

		byte[] imageResponse = null;

		RestTemplate restTemplate = new RestTemplate();

		return imageResponse;

	}
}
