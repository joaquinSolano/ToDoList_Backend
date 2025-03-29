package pe.edu.upc.todolist.ServiceImplements;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.todolist.Entities.Users;
import pe.edu.upc.todolist.Repositories.IUserRepository;
import pe.edu.upc.todolist.ServiceInterfaces.IUserService;

import java.util.List;

@Service
public class UserServiceImplement implements IUserService {
    @Autowired
    private IUserRepository uR;

    @Override
    public void insert(Users usuario) {
        System.out.println("Usuario a guardar: " + usuario);
        uR.save(usuario);
    }

    @Override
    public List<Users> list() {
        return uR.findAll();
    }

    @Override
    public void delete(Long idUsuario) {
        uR.deleteById(idUsuario);
    }

    @Override
    public Users listarId(Long idUsuario) {
        return uR.findById(idUsuario).orElse(new Users());
    }

    // Inserta el usuario, obtiene el id generado y agrega el rol "USER" para ese usuario.
    @Override
    @Transactional
    public void insertUserAndRole(Users usuario) {
        // Guarda el usuario y recupera la entidad guardada con su id autogenerado
        Users savedUser = uR.save(usuario);
        // Inserta el rol en la tabla roles asociado al id del usuario recién guardado.
        uR.insRol("USER", savedUser.getId());
    }


}
