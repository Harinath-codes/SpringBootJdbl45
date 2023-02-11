package com.example.thfeb.demoimageapiexmaple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ImageController {

	
	//@Autowired
	BeanConfigFile beanConfigFile;
	
	Config2 obj2;
	
	//Childclass obj;
	
//	@Autowired
////@Qualifier("getTemplate2")
//	RestTemplate obj;
	
	//syntax for constructor injection
	@Autowired
	public ImageController(BeanConfigFile beanConfig) {
		this.beanConfigFile = beanConfig;
		
	}
	
	
	
	public ImageController(Config2 config ) {
		this.obj2 = config;
		
	}
	
//	psvm {
//		
//		
//	}
	
	
	
	// q1. we have to create an to api get image
	// input - size param - length and breath
	// output - it should return the image in postman or google chrome

	@GetMapping(value = "/getImage",produces=MediaType.IMAGE_PNG_VALUE)
	public byte[] displayImage(@RequestParam("id") int id, @RequestParam(value="length",required=false, defaultValue = "200") int length,
			@RequestParam(value= "breadth", required=false, defaultValue = "200") int breadth) {

		// https://picsum.photos/id/237/200/300

		
		String url = "https://picsum.photos/id/" + id + "/" + length + "/" + breadth;

		//RestTemplate restTemplate = new RestTemplate();
		RestTemplate restTemplate = beanConfigFile.getTemplate();
		byte[] imageResponse = restTemplate.getForObject(url, byte[].class);

		return imageResponse;

	}

}
