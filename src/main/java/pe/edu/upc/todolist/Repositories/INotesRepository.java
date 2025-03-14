package pe.edu.upc.todolist.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.todolist.Entities.Notes;

public interface INotesRepository extends JpaRepository<Notes, Integer> {
}
