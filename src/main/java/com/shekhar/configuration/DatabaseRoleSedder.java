package com.shekhar.configuration;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.shekhar.domain.entities.Role;
import com.shekhar.domain.repository.Users_roleRepository;

import static com.shekhar.domain.app.util.constants.ValidationErrorMessages.ROOT_ADMIN;
import static com.shekhar.domain.app.util.constants.ValidationErrorMessages.ROLE_ADMIN;
import static com.shekhar.domain.app.util.constants.ValidationErrorMessages.ROLE_MODERATOR;
import static com.shekhar.domain.app.util.constants.ValidationErrorMessages.ROLE_USER;

@Component
public class DatabaseRoleSedder {

	private Users_roleRepository users_roleRepository;

	@Autowired
	public DatabaseRoleSedder(Users_roleRepository users_roleRepository) {
		this.users_roleRepository = users_roleRepository;
	}

	@PostConstruct
	@Lazy
	public void seed() {
		if (users_roleRepository.count() == 0) {
			System.out.println("Instanciate Before Bean");

			Role rootAdmin = new Role();
			rootAdmin.setAuthority(ROOT_ADMIN);

			Role roleAdmin = new Role();
			roleAdmin.setAuthority(ROLE_ADMIN);

			Role roleModrtor = new Role();
			roleModrtor.setAuthority(ROLE_MODERATOR);

			Role roleUser = new Role();
			roleUser.setAuthority(ROLE_USER);

			this.users_roleRepository.save(rootAdmin);
			this.users_roleRepository.save(roleAdmin);
			this.users_roleRepository.save(roleModrtor);
			this.users_roleRepository.save(roleUser);
		}
	}

}
