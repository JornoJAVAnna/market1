package said.team.lead.market.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import said.team.lead.market.models.User;
import said.team.lead.market.services.UsersService;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UsersService usersService;

    @Autowired
    public UserController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return usersService.findAll();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable int id) {
        return usersService.findOne(id);
    }

    @PostMapping("/create")
    public void createUser(@RequestBody User user) {
        usersService.save(user);
    }

    @PutMapping("/{id}")
    public void updatedUser(@PathVariable int id, @RequestBody User updatedUser) {
        usersService.update(id, updatedUser);
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        usersService.delete(id);
    }

}
