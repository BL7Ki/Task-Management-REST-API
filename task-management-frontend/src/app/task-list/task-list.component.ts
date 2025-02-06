import { Component, OnInit } from '@angular/core';
import { TaskService } from '../services/task.service';
import { Task } from '../models/task.model';

@Component({
  selector: 'app-task-list',
  templateUrl: './task-list.component.html',
  styleUrls: ['./task-list.component.css']
})
export class TaskListComponent implements OnInit {

  tasks: Task[] = [];
  isLoading: boolean = true;
  errorMessage: string | null = null;

  constructor(private taskService: TaskService) { }

  ngOnInit(): void {
    console.log('TaskListComponent inicializado.');
    this.loadTasks();
  }

  loadTasks(): void {
    console.log('Iniciando carregamento de tarefas...');
    this.isLoading = true;
    this.errorMessage = null;

    this.taskService.getTasks().subscribe({
      next: (data) => {
        console.log('Tarefas carregadas com sucesso:', data);
        this.tasks = data;
        this.isLoading = false;
      },
      error: (err) => {
        console.error('Erro ao carregar tarefas:', err);
        this.errorMessage = 'Ocorreu um erro ao carregar as tarefas.';
        this.isLoading = false;
      },
      complete: () => console.log('Requisição de tarefas finalizada.')
    });
  }
}
