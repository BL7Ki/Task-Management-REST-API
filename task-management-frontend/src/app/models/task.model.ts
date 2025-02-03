export interface Task {
    id: number;
    title: string;
    description: string;
    status: 'PENDING' | 'IN_PROGRESS' | 'COMPLETED'; // Enum simulando os status possíveis
    createdAt: string;
    updatedAt: string;
  }
  