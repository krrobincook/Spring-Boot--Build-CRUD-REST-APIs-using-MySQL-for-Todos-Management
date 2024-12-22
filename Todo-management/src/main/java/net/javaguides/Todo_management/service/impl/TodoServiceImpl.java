package net.javaguides.Todo_management.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.Todo_management.dto.TodoDto;
import net.javaguides.Todo_management.entity.Todo;
import net.javaguides.Todo_management.exception.ResourceNotFoundException;
import net.javaguides.Todo_management.repository.TodoRepository;
import net.javaguides.Todo_management.service.TodoService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {
    private TodoRepository todoRepository;


    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public TodoDto addTodo(TodoDto todoDto) {
        // Convert TodoDto into Todo Jpa entity
        Todo todo = new Todo();
        todo.setTitle(todoDto.getTitle());
        todo.setDescription(todoDto.getDescription());
        todo.setCompleted(todoDto.isCompleted());
        // Todo Jpa entity
        Todo savedTodo = todoRepository.save(todo);

        // Convert savedTodo Jpa entity object into TodoDto object
        TodoDto savedTodoDto = new TodoDto();
        savedTodoDto.setId(savedTodo.getId());
        savedTodoDto.setDescription(savedTodo.getDescription());
        savedTodoDto.setTitle(savedTodo.getTitle());
        savedTodoDto.setCompleted(savedTodo.isCompleted());
        //TodoDto savedTodoDto = modelMapper.map(savedTodo, TodoDto.class);
        return savedTodoDto;
    }

    @Override
    public TodoDto getTodo(Long id) {
        Todo todo = todoRepository.findById(id)
                 .orElseThrow(()-> new ResourceNotFoundException("Todo not found with id:"+id));
        TodoDto todoDto = new TodoDto();
        todoDto.setId(todo.getId());
        todoDto.setTitle(todo.getTitle());
        todoDto.setDescription(todo.getDescription());
        todoDto.setCompleted(todo.isCompleted());
        return todoDto;
    }

    @Override
    public List<TodoDto> getAllTodos() {
        List<Todo> todos = todoRepository.findAll();

        List<TodoDto> todoDtos = new ArrayList<>();
        for(Todo todo : todos){
            TodoDto todoDto = new TodoDto();
            todoDto.setId(todo.getId());
            todoDto.setTitle(todo.getTitle());
            todoDto.setDescription(todo.getDescription());
            todoDto.setCompleted(todo.isCompleted());
            todoDtos.add(todoDto);
        }
        return todoDtos;
    }

}
