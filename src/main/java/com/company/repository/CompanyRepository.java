package com.company.repository;

import com.company.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    @Override
    List<Company> findAll();

    @Override
    <S extends Company> S save(S entity);

    @Override
    Optional<Company> findById(Long aLong);

    @Override
    void deleteById(Long aLong);
}
