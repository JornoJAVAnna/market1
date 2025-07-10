package said.team.lead.market.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import said.team.lead.market.services.UsersService;

@RestController
public class PeopleController {

    private final UsersService usersService;

    @Autowired
    public PeopleController(UsersService usersService) {
        this.usersService = usersService;
    }
}
