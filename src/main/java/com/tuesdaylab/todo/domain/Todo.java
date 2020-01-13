package com.tuesdaylab.todo.domain;

import com.tuesdaylab.todo.dto.TodoDTO;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Entity
@DynamicUpdate
@ToString
public class Todo {
    public Todo() {
    }

    private Todo(Long id, String title, Boolean isDone) {
        this.id = id;
        this.title = title;
        this.isDone = isDone;
    }

    public static Todo from(TodoDTO todoDto) {
        return new Todo(todoDto.getId(), todoDto.getTitle(), todoDto.getIsDone());
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Setter
    @NotBlank
    private String title;

    @NotNull
    private Boolean isDone;
}