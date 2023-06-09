package ma.eheio.hr_association.repository;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;


    @Configuration
    @ConfigurationProperties(prefix = "ma.eheio")
    @Data
    public class CustomProperties {

        private String apiUrl;
}
