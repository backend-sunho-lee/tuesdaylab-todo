package com.tuesdaylab.todo.repository;

import com.tuesdaylab.todo.domain.Todo;
import com.tuesdaylab.todo.dto.TodoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
}

// proxy로 인터페이스 동작하도록
// spring data jpa != jpa(Java Persistence API)
// 추상화 레벨

// JPQL =sqlalchemy 같은거
// SQL 종류마다 함수명이 달라서 커스텀해야 한다.
// https://dololak.tistory.com/465


//@Repository
//public class TodoRepository {
//
//    private List<Todo> todos = new ArrayList<>();
//
//    public List<Todo> findAll() {
//        return this.todos;
//    }
//
//    public Optional<Todo> findById(Long id) {
//        return this.todos.stream()
//                .filter((todo) -> todo.getId().equals(id))
//                .findFirst();
//    }
//
//    public Todo save(Todo todo) {
//        int index = this.todos.size() + 1;
//        todo.setId(Long.valueOf(index));
//        this.todos.add(todo);
//        return todo;
//    }
//}
