import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Task } from '../models/task.model';
import { tap } from 'rxjs/operators'; // Importa tap para depuração

@Injectable({
  providedIn: 'root'
})
export class TaskService {

  private apiUrl = 'http://localhost:8080/tasks';  // URL do backend

  constructor(private http: HttpClient) { }

  getTasks(): Observable<Task[]> {
    return this.http.get<Task[]>(this.apiUrl).pipe(
      tap(data => console.log('Tasks recebidas:', data)) // Log para depuração
    );
  }

  addTask(task: Task): Observable<Task> {
    console.log('Adicionando task:', task);
    return this.http.post<Task>(this.apiUrl, task).pipe(
      tap(newTask => console.log('Task adicionada:', newTask))
    );
  }

  updateTask(task: Task): Observable<Task> {
    console.log('Atualizando task:', task);
    return this.http.put<Task>(`${this.apiUrl}/${task.id}`, task).pipe(
      tap(updatedTask => console.log('Task atualizada:', updatedTask))
    );
  }

  deleteTask(id: number): Observable<void> {
    console.log('Deletando task com ID:', id);
    return this.http.delete<void>(`${this.apiUrl}/${id}`).pipe(
      tap(() => console.log(`Task ${id} deletada com sucesso!`))
    );
  }
}
