package net.javaguides.Todo_management.service;

import net.javaguides.Todo_management.TodoManagementApplication;
import net.javaguides.Todo_management.dto.TodoDto;

import java.util.List;

public interface TodoService {
    TodoDto addTodo(TodoDto todoDto);

    TodoDto getTodo(Long id);

    List<TodoDto> getAllTodos();
}
