package com.company.api;

import com.company.dto.request.CompanyRequest;
import com.company.dto.response.CompanyResponse;
import com.company.model.Company;
import com.company.service.CompanyService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/companies")
public class CompanyApi {

    private final CompanyService companyService;

    @GetMapping
    @PermitAll
    public List<Company> getCompanies() {
        return companyService.getCompany();
    }

    @PostMapping("/saveCompany")
    @PreAuthorize("hasAuthority('ADMIN')")
    @Operation(summary = "save Company")
    public CompanyResponse createCompany(@RequestBody CompanyRequest companyRequest) {
        return companyService.create(companyRequest);
    }

    @PutMapping("/update/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    @Operation(summary = "update Company")
    public CompanyResponse updateCompany(@PathVariable("id") Long id, @RequestBody CompanyRequest companyRequest) {
        return companyService.update(id, companyRequest);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    @Operation(summary = "delete Company")
    public void deleteCompanyId(@PathVariable("id") Long id) {
        companyService.delete(id);
    }

    @GetMapping("/getId/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    @Operation(summary = "getById Company")
    public Optional<Company> getCompanyByID(@PathVariable("id") Long id) {
        return companyService.findById(id);
    }
}
