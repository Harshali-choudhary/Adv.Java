package com.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.Railway;

@Repository
public interface RailwayRepo extends JpaRepository<Railway, Long>{

	//public Railway Add(Railway railway) ;

}
