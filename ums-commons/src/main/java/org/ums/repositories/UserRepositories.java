package org.ums.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.ums.entities.Users;

@Repository
public interface UserRepositories  extends JpaRepository<Users, String>{
}
