package dtwg.mptc.ecommerce.user.config;

import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KeycloakAdminClientConfig {
    @Bean
    public Keycloak keycloak() {
        return KeycloakBuilder.builder()
                .serverUrl("https://sso.dtwg.dev")
                .grantType(OAuth2Constants.CLIENT_CREDENTIALS)
                .clientId("ecommerce-admin-client")
                .clientSecret("tuElCa1LKefpIqE5arsNXOaZpOrIyFdH")
                .realm("ecommerce")
                .build();
    }

}
