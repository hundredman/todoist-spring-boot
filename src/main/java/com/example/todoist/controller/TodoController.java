package com.example.todoist.controller;

import com.example.todoist.model.Todo;
import com.example.todoist.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping
    public String getTodos(Model model) {
        model.addAttribute("todos", todoService.getAllTodos());
        return "todo-list";  // todo-list.html로 렌더링
    }

    @PostMapping
    public String createTodo(@RequestParam String title) {
        todoService.createTodo(title);
        return "redirect:/todos";
    }

    @GetMapping("/{id}/edit")
    public String editTodoForm(@PathVariable Long id, Model model) {
        Todo todo = todoService.getTodoById(id);  // 수정할 할 일을 가져옴
        model.addAttribute("todo", todo);  // 수정할 할 일을 모델에 추가
        return "todo-edit";  // todo-edit.html 수정 폼으로 이동
    }

    @PostMapping("/{id}/edit")
    public String updateTodo(@PathVariable Long id, @RequestParam String title) {
        todoService.updateTodo(id, title);  // 수정된 할 일 정보 저장
        return "redirect:/todos";  // 할 일 목록으로 리다이렉트
    }

    @PostMapping("/{id}/toggle")
    public String toggleTodo(@PathVariable Long id) {
        todoService.toggleTodoCompletion(id);
        return "redirect:/todos";
    }

    @PostMapping("/{id}/delete")
    public String deleteTodo(@PathVariable Long id) {
        todoService.deleteTodoById(id);
        return "redirect:/todos";
    }
}
