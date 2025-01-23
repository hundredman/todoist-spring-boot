package com.example.todoist.service;

import com.example.todoist.model.Todo;
import com.example.todoist.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public void createTodo(String title) {
        Todo todo = new Todo();
        todo.setTitle(title);
        todo.setCompleted(false);
        todoRepository.save(todo);
    }

    public Todo getTodoById(Long id) {
        return todoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("할 일을 찾을 수 없습니다."));
    }

    public void updateTodo(Long id, String title) {
        Todo todo = getTodoById(id);  // 수정할 할 일을 가져옴
        todo.setTitle(title);  // 새로운 제목으로 수정
        todoRepository.save(todo);  // 변경된 할 일 저장
    }

    public void toggleTodoCompletion(Long id) {
        Todo todo = getTodoById(id);
        todo.setCompleted(!todo.isCompleted());
        todoRepository.save(todo);
    }

    public void deleteTodoById(Long id) {
        Todo todo = getTodoById(id);
        todoRepository.delete(todo);
    }

    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }
}
