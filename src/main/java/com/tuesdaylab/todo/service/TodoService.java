package com.tuesdaylab.todo.service;

import com.tuesdaylab.todo.domain.Todo;
import com.tuesdaylab.todo.dto.TodoDTO;
import com.tuesdaylab.todo.repository.TodoRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class TodoService {
//    private final DataSource dataSource;
    private final TodoRepository todoRepository;

    public List<TodoDTO> getTodos() {
        return this.todoRepository.findAll().stream()
                .map(todo -> TodoDTO.from(todo))
                .collect(Collectors.toList());
    }

    public TodoDTO getTodo(Long todoId) {
        Optional<Todo> todoResult = this.todoRepository.findById(todoId);

        return todoResult.map(todo -> TodoDTO.from(todo))
                .orElseThrow(() -> new RuntimeException("Not Found"));
    }

    @Transactional
    public TodoDTO saveTodo(TodoDTO todoDTO) {
        Todo todo = Todo.from(todoDTO);
        this.todoRepository.save(todo);
        return TodoDTO.from(todo);
    }

    @Transactional
    public void deleteTodo(Long todoId) {
        this.todoRepository.deleteById(todoId);
    }
}


//    public TodoDTO saveTodo(TodoDTO todoDTO) {
//        Todo todo = new Todo();
//        todo.setTitle(todoDTO.getTitle());
//        todo.setIsDone(todoDTO.getIsDone());
//        this.todoRepository.save(todo);
//
//        todoDTO.setId(todo.getId());
//        return todoDTO;
//    }

// 영속성 컨택스트
// 달라지지 않고 같은게 유지된다는..
// request당 context 하나가 할당
// 실제로 save를 했지만 DB에 저장된건 아니다

// 하나의 서비스에서 repo를 여러개 쓴다 -> 그럼 파일 구조는? 우리는 repo 기준으로 나누자했는데

// hibernate: ORM 구현체

// DELETE Response
// 바로실행했으면 204
// 비동기 처리하는 경우 202

// REQ, RES 만들어서

// annotation
// Throwable: Java Exception 최상위 객체, 모든 Exception은 이걸 다 상속받아
