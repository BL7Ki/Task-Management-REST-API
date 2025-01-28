package TaskManagement.src.repositories;

import TaskManagement.src.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TaskRepository extends JpaRepository<Task, Long> {}
