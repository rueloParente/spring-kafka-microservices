package com.rueloparente.library_service.persistence.spring;

import com.rueloparente.library_service.persistence.repository_persistence_data.BookDataModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDBContext extends JpaRepository<BookDataModel, Integer>{

}
