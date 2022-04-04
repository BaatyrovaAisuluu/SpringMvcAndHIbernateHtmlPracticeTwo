package com.company.seviceImpl;

import com.company.dto.request.CompanyRequest;
import com.company.dto.response.CompanyResponse;
import com.company.mapper.edit.CompanyEditMapper;
import com.company.mapper.view.CompanyViewMapper;
import com.company.model.Company;
import com.company.repository.CompanyRepository;
import com.company.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    private final CompanyEditMapper companyEditMapper;
    private final CompanyViewMapper companyViewMapper;

    @Override
    public List<Company> getCompany() {
        List<Company> companies = companyRepository.findAll();
        return companies;
    }

    @Override
    public CompanyResponse create(CompanyRequest companyRequest) {
        return companyViewMapper.viewCompany(companyRepository.save
                (companyEditMapper.create(companyRequest)));
    }

    @Override
    public CompanyResponse update(Long id, CompanyRequest companyRequest) {
        Company company = companyRepository.findById(id).get();
        companyEditMapper.Update(company, companyRequest);
        return companyViewMapper.viewCompany(companyRepository.save(company));
    }

    @Override
    public void delete(Long id) {
        companyRepository.deleteById(id);

    }

    @Override
    public Company getCompanyById(Long id) {
        return companyRepository.getById(id);
    }

    @Override
    public Optional<Company> findById(Long id) {
       return companyRepository.findById(id);
    }
}
