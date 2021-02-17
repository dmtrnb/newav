package org.example.newav.repository;

import org.example.newav.repository.entity.Ad;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdRepository extends CrudRepository<Ad, Long>, JpaSpecificationExecutor<Ad> {
}
