package sv.edu.udb.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sv.edu.udb.controller.request.UsuarioRequest;
import sv.edu.udb.model.Usuario;
import sv.edu.udb.repository.UsuarioRepository;
import sv.edu.udb.service.mapper.UsuarioMapper;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository usuarioRepo;
    private final UsuarioMapper usuarioMapper;

    public List<Usuario> findAll() {
        return usuarioRepo.findAll();
    }

    public Usuario findById(Long id) {
        return usuarioRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado; id: " + id));
    }

    public Usuario save(UsuarioRequest usuarioRequest) {
        return usuarioRepo.save(usuarioMapper.toUsuario(usuarioRequest));
    }

    public Usuario update(Long id, UsuarioRequest usuarioRequest) {
        final Usuario oldUsuario = findById(id);
        final Usuario newUsuario = usuarioMapper.toUsuario(usuarioRequest);

        oldUsuario.setUsername(newUsuario.getUsername());
        oldUsuario.setPassword(newUsuario.getPassword());
        oldUsuario.setRol(newUsuario.getRol());
        oldUsuario.setCorreo(newUsuario.getCorreo());
        oldUsuario.setTelefono(newUsuario.getTelefono());

        return usuarioRepo.save(oldUsuario);
    }

    public void delete(Long id) {
        usuarioRepo.deleteById(id);
    }
}
