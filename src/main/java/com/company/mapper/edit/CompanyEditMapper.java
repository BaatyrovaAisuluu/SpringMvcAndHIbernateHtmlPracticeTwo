package com.company.mapper.edit;

import com.company.dto.request.CompanyRequest;
import com.company.model.Company;
import org.springframework.stereotype.Component;

@Component
public class CompanyEditMapper {
    public Company create(CompanyRequest companyRequest) {
        if (companyRequest == null) {
            return null;
        }
        Company company = new Company();
        company.setCompanyName(companyRequest.getCompanyName());
        company.setLocatedCountry(companyRequest.getLocatedCountry());
        return company;
    }

    public void Update(Company company, CompanyRequest companyRequest) {
        company.setCompanyName(companyRequest.getCompanyName());
        company.setLocatedCountry(companyRequest.getLocatedCountry());

    }
}
