package com.apress.todo.validator;

import com.apress.todo.domain.ToDo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.Errors;

import org.springframework.validation.Validator;

public class ToDoValidator implements Validator {
  private static Logger log = LoggerFactory.getLogger(ToDoValidator.class);
  @Override
  public boolean supports(Class<?> clazz) {
    return clazz.isAssignableFrom(ToDo.class);
  }
  @Override
  public void validate(Object target, Errors errors) {
    ToDo toDo = (ToDo)target;
    if (toDo == null) {
      errors.reject(null, "ToDo cannot be null");
    }else {
      if (toDo.getDescription() == null || toDo.getDescription().isEmpty()) {
        errors.rejectValue("description", null, "description cannot be null or empty");
      } else {
        log.info(toDo.getDescription());
      }
    }
  }
}
