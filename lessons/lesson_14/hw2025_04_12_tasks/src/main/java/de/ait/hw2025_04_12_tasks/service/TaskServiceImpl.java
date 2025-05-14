package de.ait.hw2025_04_12_tasks.service;

import de.ait.hw2025_04_12_tasks.dto.TaskResponseDto;
import de.ait.hw2025_04_12_tasks.mappers.TaskMapper;
import de.ait.hw2025_04_12_tasks.model.Task;
import de.ait.hw2025_04_12_tasks.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository repository;
    private final TaskMapper mapper;

    public TaskServiceImpl(@Qualifier("taskRepositoryMapImpl") TaskRepository repository, TaskMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }
//
//    @Override
//    public List<TaskResponseDto> getAllTasks() {
//        List<Task> taskList = repository.findAll();
//       return taskList.stream()
////                .map(t -> new TaskResponseDto(t.getId(), t.getDescription(), t.getPriority()))
//               .map(TaskServiceImpl::getTaskResponseDto)
//                .toList();
//    }


@Override
public List<TaskResponseDto> getAllTasks() {
    return mapper.toResponseDtoList(repository.findAll());
}


//    @Override
//    public List<TaskResponseDto> getAllTasks() {
//        List<Task> taskList = repository.findAll();
//        return taskList.stream()
//                .map(t -> mapper.toResponseDto(t))
//                .toList();
//    }

    public static TaskResponseDto getTaskResponseDto(Task t) {
        return new TaskResponseDto(t.getId(), t.getDescription(), t.getPriority());
    }
}
