package com.example.crud.democrud;



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

	
	@Autowired
	BeanConfigFile beanConfigFile;
	
	Config2 obj2;
	
	
	int valueOne=21;
	
	@Value("${jdbl.lect.lectnum}")
	int valueTwo;
	
	//Childclass obj;
	
//	@Autowired
////@Qualifier("getTemplate2")
//	RestTemplate obj;
	
	//syntax for constructor injection
	@Autowired
	public ImageController(BeanConfigFile beanConfig,@Value("${jdbl.lect.lectnum}") int num ) {
		this.beanConfigFile = beanConfig;
		System.out.println("value of the 333 " +  this.valueTwo);//0
		
		this.valueOne = num;
		System.out.println("value of the 777 " +  this.valueOne);//21
		
	}
	//Constructor injection why is it better 
	//Java always create the constructor first 
	//then it goes and inject and initialise all the property or fields
	// so the this.valueTwo in above constructor is 0 becoz by the time it prints the line in constructor 
	// the value is not injected from app properties file so its zero
	//this.valueOne since it required by constructor so java will inject the value for use in constructor 
	
	// which makes it better
	
	public ImageController(Config2 config ) {
		this.obj2 = config;
		
	}
	//@Autowired
	public ImageController( ) {
		System.out.println("value of the bean 888 " + this.beanConfigFile);
		
	}

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
	
	@GetMapping("/image/get")
	public String getEmpName() {
		System.out.println("output 999: " +  this.valueTwo);//21
		System.out.println("output 991: " +  this.valueOne);//21
		
		return "My name is Kirti";
		
	}
	
	
	
	
	

}
