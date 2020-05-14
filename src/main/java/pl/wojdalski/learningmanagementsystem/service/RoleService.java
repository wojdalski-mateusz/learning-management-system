package pl.wojdalski.learningmanagementsystem.service;


import org.springframework.stereotype.Service;
import pl.wojdalski.learningmanagementsystem.model.Role;
import pl.wojdalski.learningmanagementsystem.repository.RoleRepository;


@Service
public class RoleService {

    private RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role findByRoleName(String name) {
        return roleRepository.findByRoleName(name);
    }
}
