package com.mmplus.bestprice.service;

import com.mmplus.bestprice.entity.Role;
import com.mmplus.bestprice.repository.RoleRepository;

import java.util.List;
import java.util.Optional;

public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Optional<Role> getRoleById(Long id){
        return roleRepository.findById(id);
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }
}
