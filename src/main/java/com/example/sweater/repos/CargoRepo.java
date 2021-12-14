package com.example.sweater.repos;

import com.example.sweater.domain.Cargo;
import com.example.sweater.domain.Company;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CargoRepo extends CrudRepository<Cargo, Long> {

    List<Cargo> findByUser_Id(long user_id);
    Cargo findById(long id);
    Cargo findByDelivery_Id(long id);
}
