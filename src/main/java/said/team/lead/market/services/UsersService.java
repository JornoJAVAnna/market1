package said.team.lead.market.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import said.team.lead.market.models.User;
import said.team.lead.market.repositories.UsersRepository;

import java.util.List;

@Service
public class UsersService {

    private final UsersRepository usersRepository;

    @Autowired
    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public List<User> findAll() {
        return usersRepository.findAll();
    }

    public User findOne(int id) {
        return usersRepository.findById(id).orElse(null);
    }

    public void save(User user) {
        usersRepository.save(user);
    }

    public void update(int id, User updatedUser) {
        updatedUser.setId(id);
        usersRepository.save(updatedUser);
    }

    public void delete(int id) {
        usersRepository.deleteById(id);
    }
}
