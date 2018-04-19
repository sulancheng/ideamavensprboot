package com.light.springboot.jpa;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
@NoRepositoryBean
public interface BaseRepository<T,PK extends Serializable> extends JpaRepository<T, PK>{

}
