package org.example.newav.repository;

import org.example.newav.repository.entity.Ad;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdRepository extends PagingAndSortingRepository<Ad, Long>, JpaSpecificationExecutor<Ad> {
}
