package com.tuesdaylab.todo.dto;

import com.tuesdaylab.todo.domain.Todo;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class TodoDTO {

    public TodoDTO() {
    }

    private Long id;

    @NotBlank
    private String title;

    @NotNull
    private Boolean isDone;

    public static TodoDTO from(Todo todo) {
        TodoDTO todoDTO = new TodoDTO();
        todoDTO.setId(todo.getId());
        todoDTO.setTitle(todo.getTitle());
        todoDTO.setIsDone(todo.getIsDone());
        return todoDTO;
    }
}

// jpa 영속성 컨텍스트
// https://cocomo.tistory.com/334

// detached =

// STS, auto reload 가능
