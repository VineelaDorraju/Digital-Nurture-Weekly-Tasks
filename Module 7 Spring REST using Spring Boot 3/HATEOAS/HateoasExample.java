package com.vineela.concepts.hateoas;

import org.springframework.hateoas.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/api/v1/hateoas/users")
public class HateoasExample {

    static class User {
        public Long id; public String name;
        User(Long id, String name){ this.id=id; this.name=name; }
    }

    @GetMapping("/{id}")
    public EntityModel<User> one(@PathVariable Long id){
        User u = new User(id, "User-"+id);
        return EntityModel.of(u,
                linkTo(methodOn(HateoasExample.class).one(id)).withSelfRel(),
                linkTo(methodOn(HateoasExample.class).all()).withRel("users")
        );
    }

    @GetMapping
    public CollectionModel<EntityModel<User>> all(){
        List<User> users = List.of(new User(1L,"A"), new User(2L,"B"));
        List<EntityModel<User>> models = users.stream().map(u ->
                EntityModel.of(u,
                        linkTo(methodOn(HateoasExample.class).one(u.id)).withSelfRel())
        ).toList();

        return CollectionModel.of(models,
                linkTo(methodOn(HateoasExample.class).all()).withSelfRel());
    }
}
