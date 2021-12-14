package com.example.sweater.repos;

import com.example.sweater.domain.Company;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Stream;

public interface CompanyRepo extends CrudRepository<Company, Long> {

    Company findByUser_Id(long user_id);

    @Transactional
    @Modifying
    @Query("update Company company set company.name=:names where company.id =:company_id")
    void updateCompanyName(@Param(value = "company_id") long company_id, @Param("names") String names);

    List<Company> findAll();

    Company findById(long id);
}
