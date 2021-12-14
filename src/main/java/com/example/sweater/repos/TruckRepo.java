package com.example.sweater.repos;

import com.example.sweater.domain.Company;
import com.example.sweater.domain.Truck;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TruckRepo extends CrudRepository<Truck, Long> {
    List<Truck> findByCompany_Id(long company_id);

    Truck findById(long id);
}
