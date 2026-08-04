package com.zosh.service.impl;

import com.zosh.configrations.JwtProvider;
import com.zosh.domain.UserRole;
import com.zosh.exception.UserException;
import com.zosh.modal.User;
import com.zosh.repository.PasswordResetTokenRepository;
import com.zosh.repository.UserRepository;
import com.zosh.repository.BranchRepository;
import com.zosh.repository.StoreRepository;
import com.zosh.service.UserService;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final StoreRepository storeRepository;
    private final BranchRepository branchRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;
    private final PasswordResetTokenRepository passwordResetTokenRepository;


    // Constructor Injection (Replacement of @RequiredArgsConstructor)
    public UserServiceImpl(
            UserRepository userRepository,
            StoreRepository storeRepository,
            BranchRepository branchRepository,
            PasswordEncoder passwordEncoder,
            JwtProvider jwtProvider,
            PasswordResetTokenRepository passwordResetTokenRepository
    ) {
        this.userRepository = userRepository;
        this.storeRepository = storeRepository;
        this.branchRepository = branchRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtProvider = jwtProvider;
        this.passwordResetTokenRepository = passwordResetTokenRepository;
    }


    @Override
    public User getUserByEmail(String email) throws UserException {

        User user = userRepository.findByEmail(email);

        if (user == null) {
            throw new UserException(
                    "User not found with email: " + email
            );
        }

        return user;
    }


    @Override
    public User getUserFromJwtToken(String jwt) throws UserException {

        String email = jwtProvider.getEmailFromJwtToken(jwt);

        User user = userRepository.findByEmail(email);

        if (user == null) {
            throw new UserException(
                    "user not exist with email " + email
            );
        }

        return user;
    }


    @Override
    public User getUserById(Long id) throws UserException {

        return userRepository.findById(id)
                .orElse(null);
    }


    @Override
    public Set<User> getUserByRole(UserRole role) throws UserException {

        return userRepository.findByRole(role);
    }


    @Override
    public User getCurrentUser() {

        String email = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();


        User user = userRepository.findByEmail(email);


        if (user == null) {
            throw new EntityNotFoundException(
                    "User not found"
            );
        }

        return user;
    }


    @Override
    public List<User> getUsers() throws UserException {

        return userRepository.findAll();
    }

}