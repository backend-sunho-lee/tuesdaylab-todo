package com.tuesdaylab.todo.controller;

import com.tuesdaylab.todo.dto.TodoDTO;
import com.tuesdaylab.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/todos")
public class ApiController {

    private final TodoService todoService;

    @GetMapping
    public List<TodoDTO> getTodos() {
        return this.todoService.getTodos();
    }

    @GetMapping(value = "{todoId}")
    public TodoDTO getTodo(@PathVariable("todoId") Long todoId) {
        return this.todoService.getTodo(todoId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TodoDTO saveTodo(@RequestBody @Valid TodoDTO todoDTO, HttpServletResponse response) {
        TodoDTO result = this.todoService.saveTodo(todoDTO);
        response.setHeader(HttpHeaders.LOCATION, "/todos/" + result.getId());
        return result;
    }

    @DeleteMapping(value = "{todoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTodo(@PathVariable("todoId") Long todoId) {
        this.todoService.deleteTodo(todoId);
    }
}


//    public ApiController(TodoService todoService) {
//        this.todoService.saveTodo(todoService);
//    }

//    @GetMapping(value = "{todoId}")
//    public TodoDTO getTodo(@PathVariable("todoId") Long todoId) {
////        Todo todo = new Todo();
////        todo.setId();
////        todo.setTitle();
////        todo.setIsDone();
//
//        return TodoDTO.builder()
//                .id(todoId)
//                .title("title")
//                .isDone(false)
//                .build();
//
//    }
