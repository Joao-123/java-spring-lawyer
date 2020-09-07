package com.lawyer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

/**
 * Interface.
 */
@NoRepositoryBean
public interface RepositoryGeneric<T> extends JpaRepository<T, Integer> {

}