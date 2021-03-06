package com.mmplus.bestprice.service;

import com.mmplus.bestprice.entity.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {
    Optional<Role> getRoleById(Long id);
    List<Role> getAllRoles();
}
