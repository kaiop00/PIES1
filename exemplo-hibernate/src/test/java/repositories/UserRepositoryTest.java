package repositories;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.ufc.pies.model.User;
import br.ufc.pies.repositories.UserRepository;

public class UserRepositoryTest {

	@Test
	public void testShouldFindUserById() {
		int id = 1;
		UserRepository userRepository = new UserRepository();
		User user = userRepository.findById(id);
		
		assertEquals(id, user.getId());
	}
}
