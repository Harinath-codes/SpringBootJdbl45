package com.ecom.store;

import com.ecom.store.model.Product;
import com.ecom.store.model.User;
import com.ecom.store.repository.ProductRepository;
import com.ecom.store.repository.UserRespository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication
public class StoreApplication  implements CommandLineRunner {

    public static void main(String[] args) {
            SpringApplication.run(StoreApplication.class, args);
        }
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("http://localhost:4200").allowedMethods("GET","POST","OPTIONS","PUT","DELETE");
            }
        };
    }
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRespository userRespository;


    @Override
    public void run(String... args) throws Exception {

        User user = new User("xyz","uvw","123");
        userRespository.save(user);


        Product product = new Product("Headphones","Listen to music!",199.50,"image1.png");
        Product save = productRepository.save(product);

        product = new Product("Phone","Connect with People!",999,"image2.png");
        productRepository.save(product);


        product = new Product("Pencils","Draw things of your choice!",129.50,"image3.png");
         productRepository.save(product);

         product = new Product("Earphones","Listen to good music!",304,"image4.png");
         save = productRepository.save(product);

         product = new Product("Shoes","Good shoes take you good places!",349.50,"image5.png");
         save = productRepository.save(product);

         product = new Product("Bagpack","Carry your belongings!",309,"image6.png");
         save = productRepository.save(product);


        //System.out.println(save.getID());

    }
}
