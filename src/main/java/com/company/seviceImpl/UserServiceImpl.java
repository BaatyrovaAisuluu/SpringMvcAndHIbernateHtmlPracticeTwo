package com.company.seviceImpl;

import com.company.dto.request.admin.AdminRequest;
import com.company.dto.request.admin.AdminResponse;
import com.company.mapper.edit.AdminEditMapper;
import com.company.mapper.view.AdminViewMapper;
import com.company.model.User;
import com.company.repository.UserRepository;
import com.company.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
  private final UserRepository userRepository;
  private final AdminViewMapper adminViewMapper;
  private final AdminEditMapper adminEditMapper;
  private final PasswordEncoder passwordEncoder;

    @Override
    public AdminResponse saveUser(AdminRequest user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return adminViewMapper.viewUser(userRepository.
                save(adminEditMapper.create(user)));

    }


}
