package com.sanity.nil.service;

import com.sanity.nil.dto.mapper.UserRequestMapper;
import com.sanity.nil.dto.request.LoginRequest;
import com.sanity.nil.dto.request.UserRequest;
import com.sanity.nil.dto.response.CommandResponse;
import com.sanity.nil.dto.response.JwtResponse;
import com.sanity.nil.exception.ElementAlreadyExistsException;
import com.sanity.nil.model.Role;
import com.sanity.nil.model.RoleType;
import com.sanity.nil.model.User;
import com.sanity.nil.repository.UserRepository;
import com.sanity.nil.security.JwtUtils;
import com.sanity.nil.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static com.sanity.nil.common.Constants.ALREADY_EXISTS_USER;
import static com.sanity.nil.common.Constants.CREATED_USER;

/**
 * Service used for Authentication related operations
 */
@Slf4j(topic = "AuthService")
@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final UserRequestMapper userRequestMapper;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder encoder;
    private final JwtUtils jwtUtils;

    /**
     * Authenticates users by their credentials
     *
     * @param request
     * @return JwtResponse
     */
    public JwtResponse login(LoginRequest request) {
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername().trim(), request.getPassword().trim()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        final UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        final List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .toList();
        return JwtResponse.builder().token(jwt).id(userDetails.getId()).username(userDetails.getUsername()).roles(roles).build();
    }

    /**
     * Registers users using their credentials and user info
     *
     * @param request
     * @return id of the registered user
     */
    public CommandResponse signup(UserRequest request) {
        if (userRepository.existsByUsernameIgnoreCase(request.getUsername().trim()))
            throw new ElementAlreadyExistsException(ALREADY_EXISTS_USER);

        final User user = userRequestMapper.toEntity(request);
        user.setPassword(encoder.encode(request.getPassword().trim()));
        // add default role to the user
        user.setRoles(new HashSet<>(Arrays.asList(new Role(1L, RoleType.ROLE_USER))));
        userRepository.save(user);
        log.info(CREATED_USER);
        return CommandResponse.builder().id(user.getId()).build();
    }
}
