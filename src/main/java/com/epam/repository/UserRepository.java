package com.epam.repository;

import com.epam.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "user", path = "user")
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    List<User> findByLastName(@Param("name") String name);
//
//    @RestResource(path = "v2")
//    List<User> lastNameV2(@Param("name") String name);

    @Query("SELECT u FROM user u WHERE LOWER(u.firstName) = LOWER(:firstName)")
    @RestResource(path = "find")
    public List<User> find(@Param("firstName") String firstName);

    @Override
    @RestResource(exported = false)
    void deleteAll();
}
