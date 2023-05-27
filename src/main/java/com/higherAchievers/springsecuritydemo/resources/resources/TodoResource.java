package com.higherAchievers.springsecuritydemo.resources.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoResource {

    private Logger logger = LoggerFactory.getLogger(getClass());

    public static final List<Todo> TODO_LIST = List.of(
            new Todo("higherAchievers", "Learn AWS"),
            new Todo("higherAchievers", "Get AWS certified"));

    @GetMapping("/todos")
    public List<Todo> retrieveAllTodos(){
        return TODO_LIST;
    }

    @GetMapping("/users/{userName}/todos")
    public Todo retrieveTodosForASpecific(@PathVariable String userName){
        return TODO_LIST.get(0);
    }

    @PostMapping("/users/{userName}/todos")
    public void createTodosForASpecific(@PathVariable String userName, @RequestBody Todo todo){
        logger.info("Create {} for {}", todo, userName);
    }




}

record Todo (String userName, String description) {}


