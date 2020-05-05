package com.master4.repositories;

import com.master4.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role,Short> {
    @Query("select u.listRole from User u where u.email=:email")
    public List<Role> getRolesByEmail (@Param("email") String email);
}
