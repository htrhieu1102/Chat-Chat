package chatchat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import chatchat.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{
    Role findByName(String name);

}
