package com.company.api;

import com.company.dto.request.CompanyRequest;
import com.company.dto.response.CompanyResponse;
import com.company.model.Company;
import com.company.repository.CompanyRepository;
import com.company.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/companies")
public class CompanyApi {

    private final CompanyService companyService;

    @GetMapping
    public List<Company> getCompanies() {
        return companyService.getCompany();
    }

    @PostMapping("/saveCompany")
    public CompanyResponse createCompany(@RequestBody CompanyRequest companyRequest) {
        return companyService.create(companyRequest);
    }

    @PutMapping("/update/{id}")
    public CompanyResponse updateCompany(@PathVariable("id") Long id, @RequestBody CompanyRequest companyRequest) {
        return companyService.update(id, companyRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCompanyId(@PathVariable("id") Long id) {
        companyService.delete(id);
    }

    @GetMapping("/getId/{id}")
    public Optional<Company> getCompanyByID(@PathVariable("id") Long id) {
        return companyService.findById(id);
    }
}
