package com.company.mapper.view;

import com.company.dto.response.CompanyResponse;
import com.company.model.Company;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CompanyViewMapper {

    public CompanyResponse viewCompany(Company company) {
        if (company == null) {
            return null;
        }
        CompanyResponse companyResponse = new CompanyResponse();
        if (companyResponse != null) {
            companyResponse.setId(String.valueOf(company.getId()));
        }
        companyResponse.setCompanyName(company.getCompanyName());
        companyResponse.setLocatedCountry(company.getLocatedCountry());
        return companyResponse;


    }

    public List<CompanyResponse> viewCompanies(List<Company> companies) {
        List<CompanyResponse> companyResponses = new ArrayList<>();
        for (Company c : companies
        ) {
            companyResponses.add(viewCompany(c));
        }
        return companyResponses;
    }
}
