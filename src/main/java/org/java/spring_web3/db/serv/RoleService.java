package org.java.spring_web3.db.serv;

import java.util.List;
import java.util.Optional;

import org.java.spring_web3.db.pojo.Role;
import org.java.spring_web3.db.repo.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleRepo roleRepo;

    public List<Role> getAllRoles() {

        return roleRepo.findAll();
    }

    public Optional<Role> getRoleById(int id) {

        return roleRepo.findById(id);
    }

    public void save(Role role) {

        roleRepo.save(role);
    }

    public void delete(Role role) {

        roleRepo.delete(role);
    }
}
