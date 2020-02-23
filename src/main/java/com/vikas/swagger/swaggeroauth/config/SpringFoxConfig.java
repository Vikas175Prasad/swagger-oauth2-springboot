package com.vikas.swagger.swaggeroauth.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;

import springfox.documentation.builders.AuthorizationCodeGrantBuilder;
import springfox.documentation.builders.OAuthBuilder; 
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.GrantType;
import springfox.documentation.service.OAuth;
import springfox.documentation.service.ResourceOwnerPasswordCredentialsGrant;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.service.TokenEndpoint;
import springfox.documentation.service.TokenRequestEndpoint;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.ApiKeyVehicle;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SpringFoxConfig {
//
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.vikas.swagger.swaggeroauth.controller"))
				.paths(PathSelectors.ant("/addEmployee"))
				.build().securitySchemes(Arrays.asList(securitySchema()))
				.securityContexts(Arrays.asList(securityContext()));
	}
//	
//	 @Bean
//	    public Docket api() {
//
//	        List<ResponseMessage> list = new java.util.ArrayList<>();
//	        list.add(new ResponseMessageBuilder().code(500).message("500 message")
//	                .responseModel(new ModelRef("Result")).build());
//	        list.add(new ResponseMessageBuilder().code(401).message("Unauthorized")
//	                .responseModel(new ModelRef("Result")).build());
//	        list.add(new ResponseMessageBuilder().code(406).message("Not Acceptable")
//	                .responseModel(new ModelRef("Result")).build());
//
//	        return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.vikas.swagger.swaggeroauth.controller"))
//	                .paths(PathSelectors.any()).build().securitySchemes(Collections.singletonList(securitySchema()))
//	                .securityContexts(Collections.singletonList(securityContext())).pathMapping("/")
//	                .useDefaultResponseMessages(false).globalResponseMessage(RequestMethod.GET, list)
//	                .globalResponseMessage(RequestMethod.POST, list);
//
//
//
//	    }
//
//	@Bean
//	public SecurityConfiguration security() {
//		return SecurityConfigurationBuilder.builder().clientId("mobile").clientSecret("pin").scopeSeparator(" ")
//				.useBasicAuthenticationWithAccessCodeGrant(true).build();
//	}
	 
	 @SuppressWarnings("deprecation")
	@Bean
	    public SecurityConfiguration securityInfo() {
	      //  return new SecurityConfiguration("mobile", "pin", "", "", "", ApiKeyVehicle.HEADER, "", " ");
		 return new SecurityConfiguration("mobile", "pin", null, null, "", ApiKeyVehicle.HEADER,"Authorization",": Bearer");
	    }


//	private SecurityScheme securityScheme() {
//		GrantType grantType = new AuthorizationCodeGrantBuilder()
//				.tokenEndpoint(new TokenEndpoint("http://localhost:8091/oauth" + "/token", "oauthtoken"))
//				.tokenRequestEndpoint(
//						new TokenRequestEndpoint("http://localhost:8091/oauth" + "/authorize", "mobile", "pin"))
//				.build();
//
//		SecurityScheme oauth = new OAuthBuilder().name("spring_oauth").grantTypes(Arrays.asList(grantType))
//				.scopes(Arrays.asList(scopes())).build();
//		return oauth;
//	}
	
	
	
	 private OAuth securitySchema() {

	        List<AuthorizationScope> authorizationScopeList = new ArrayList<>();
	        authorizationScopeList.add(new AuthorizationScope("READ WRITE", "read all"));
//	        authorizationScopeList.add(new AuthorizationScope("trust", "trust all"));
//	        authorizationScopeList.add(new AuthorizationScope("write", "access all"));

	        List<GrantType> grantTypes = new ArrayList<>();
	        GrantType creGrant = new ResourceOwnerPasswordCredentialsGrant("http://localhost:8091"+"/oauth/token");

	        grantTypes.add(creGrant);

	        return new OAuth("oauth2schema", authorizationScopeList, grantTypes);

	    }

//	private AuthorizationScope[] scopes() {
//		AuthorizationScope[] scopes = { new AuthorizationScope("READ WRITE", "for read operations"),
//				new AuthorizationScope("write", "for write operations") };
//		return scopes;
//	}

//	private SecurityContext securityContext() {
//		return SecurityContext.builder()
//				.securityReferences(Arrays.asList(new SecurityReference("spring_oauth", scopes())))
//				.forPaths(PathSelectors.regex("/*")).build();
//	}
	 
	 
	 private SecurityContext securityContext() {
	        return SecurityContext.builder().securityReferences(defaultAuth()).forPaths(PathSelectors.regex("/*"))
	                .build();
	    }

	 
	  private List<SecurityReference> defaultAuth() {

	        final AuthorizationScope[] authorizationScopes = new AuthorizationScope[3];
	        authorizationScopes[0] = new AuthorizationScope("READ WRITE", "read all");
//	        authorizationScopes[1] = new AuthorizationScope("trust", "trust all");
//	        authorizationScopes[2] = new AuthorizationScope("write", "write all");

	        return Collections.singletonList(new SecurityReference("oauth2schema", authorizationScopes));
	    }
}
