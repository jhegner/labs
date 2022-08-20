package br.com.jhegnerlabs.dynamodb.config;

import br.com.jhegnerlabs.dynamodb.repository.EmpresaRepository;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.amazonaws.regions.Regions.US_EAST_1;

@Configuration
@EnableDynamoDBRepositories(basePackageClasses = EmpresaRepository.class)
public class DynamoDBConfig {

    //    @Value("${dynamodb.endpoint}")
    private final String awsDynamoDbEndpoint = "https://dynamodb.us-east-1.amazonaws.com";

    @Bean
    public EndpointConfiguration endpointConfiguration() {
        return new EndpointConfiguration(this.awsDynamoDbEndpoint, US_EAST_1.getName());
    }

    @Bean
    public AmazonDynamoDB amazonDynamoDB(EndpointConfiguration ec) {
        return AmazonDynamoDBClientBuilder.standard().withEndpointConfiguration(ec)
                .withCredentials(new ProfileCredentialsProvider("default")).build();
    }

//    @Bean
//    public DynamoDBMapperConfig beanDynamoDBMapperConfig() {
//        return DynamoDBMapperConfig.DEFAULT;
//    }
//
//    @Bean
//    public DynamoDBMapper beanDynamoDBMapper(AmazonDynamoDB amazonDynamoDB, DynamoDBMapperConfig config) {
//        return new DynamoDBMapper(amazonDynamoDB, config);
//    }
}
