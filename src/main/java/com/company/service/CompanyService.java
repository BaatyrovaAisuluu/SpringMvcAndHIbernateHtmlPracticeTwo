package com.company.service;

import com.company.dto.request.CompanyRequest;
import com.company.dto.response.CompanyResponse;
import com.company.model.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyService {

    List<Company> getCompany();

    CompanyResponse create(CompanyRequest companyRequest);

    CompanyResponse update(Long id, CompanyRequest companyRequest);

    void delete(Long id);

    Company getCompanyById(Long id);

    Optional<Company> findById(Long id);
}
