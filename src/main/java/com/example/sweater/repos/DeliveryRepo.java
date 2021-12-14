package com.example.sweater.repos;

import com.example.sweater.domain.Cargo;
import com.example.sweater.domain.Delivery;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;

public interface DeliveryRepo extends CrudRepository<Delivery, Long> {

    Delivery findByCargo_Id(long cargo_id);
    List<Delivery> findAllByUser_Id(long id);
    List<Delivery> findAllByCompany_Id(long id);
    Delivery findById(long id);
}
