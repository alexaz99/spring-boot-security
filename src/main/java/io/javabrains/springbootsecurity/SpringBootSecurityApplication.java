package io.javabrains.springbootsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 4 main Concepts
 -------------------------------------
 - Five Spring Security Concepts - Authentication vs authorization
 -------------------------------------------------------------
 1. Authentication is the process of identifying the user of the application.
	 2 types
	 knowledge based, enter user/pass
	 possession based, send text to phone, computer, card, access token, batch card. The idea is to identify if you are in possession of something that the real user should be in possession of. It's harder to still that
	 Now a lot of systems use the combination of above and it's called Multi Factor Authentication. 2 factor authentication.
 2. Authorization
 3. Principal is the person you identified during the process of authentication. A Principal is the Spring concept, and is currently logged in user that spring knows after successful login.
 4. Granted authority is the ability to access different parts of the system or perform different operations (activity or actions). It's a bunch of permissions that allow access to resources. Usually authorities have  fine-grain permissions.
 5. Roles is a group of authorities that are usually assigned together.
	 role_store_clerk,
	 role_store_manager,
	 role_store_admin
	 Roles are coarse-grained permission
	 Both terms Authority and Roles are used interchangeably.
	 Application can have multiple AuthenticationProviders. Each one will authenticate with a specific authentication mechanism. After that it takes the user Principal and associates it with a User Session Filter. This is the reason you don’t have to authenticate with every request.


 * 1. Authentication
 * 		input is credentials
 * 		output is Principal
 * 2. Autorization
 * 3. Principal is information about login user.
 * 4. Granted Access
 * 5. Roles
 */
@SpringBootApplication
public class SpringBootSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecurityApplication.class, args);
	}

}
