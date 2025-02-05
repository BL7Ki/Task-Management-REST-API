export interface Task {
  id?: number;  // Opcional, pois ao criar uma nova tarefa, pode não ter ID ainda
  title: string;
  description: string;
  status: string;  // Antes era um ENUM, agora é string para refletir o DTO do backend
}
