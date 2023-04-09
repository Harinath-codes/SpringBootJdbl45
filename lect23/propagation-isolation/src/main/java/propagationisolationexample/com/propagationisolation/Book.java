package propagationisolationexample.com.propagationisolation;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Entity
@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	public String name;
	public String authorName;
	public Date publishedDate;
	public int cost;
	public String publisherName;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//jdk - is a core compoent of java
	//provide all the tool to compile , debug, exctute for java program
	//jre and jvm to excute the java prog
	
	
	//JVM 
	//when we exctutes a java program jvm is responsible for converting byte to machine specif code 
	//jvm is also called interpreter - as it excutes the program line by line 
	//it performs loading linking and intilization of java program
	//jvm calls the main method 
	
	
	//jre
	//provides run time env
	//jre is req only who want to run the java app
	// it has jvm and other class lib
	
	
	
	
	//Jit 
	//it is part of jvm 
	//it compiles simialr type of byte code at the same time and reduces overall time taken for compilation of the byte code to machine code
	
	
	
	
	
	
	
	
	
	
	
	
	
	



}
