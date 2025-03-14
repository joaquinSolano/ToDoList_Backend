package pe.edu.upc.todolist.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.todolist.Entities.Role;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Long> {
}
