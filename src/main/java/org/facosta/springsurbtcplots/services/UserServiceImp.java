package org.facosta.springsurbtcplots.services;

import lombok.extern.slf4j.Slf4j;
import org.facosta.springsurbtcplots.dto.UserRegisterDto;
import org.facosta.springsurbtcplots.models.entity.Role;
import org.facosta.springsurbtcplots.models.entity.UserIndicator;
import org.facosta.springsurbtcplots.models.entity.UserModel;
import org.facosta.springsurbtcplots.repository.UserIndicatorRepository;
import org.facosta.springsurbtcplots.repository.UserRepository;
import org.facosta.springsurbtcplots.services.Interfaces.UserFeaturesService;
import org.facosta.springsurbtcplots.services.Interfaces.UserIndicatorService;
import org.facosta.springsurbtcplots.services.Interfaces.UserRegistrationService;
import org.facosta.springsurbtcplots.utils.errors.UserExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
public class UserServiceImp implements UserFeaturesService, UserRegistrationService
{
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private UserIndicatorRepository userIndicatorRepository;

    @Autowired
    public UserServiceImp(UserRepository userRepository, PasswordEncoder passwordEncoder, UserIndicatorRepository userIndicatorRepository)
    {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userIndicatorRepository = userIndicatorRepository;
    }

    @Override
    public UserModel findByUsername(String username)
    {
        return userRepository.findByUsername(username);
    }

    @Override
    public UserModel saveUser(UserModel newUser)
    {
        return userRepository.save(newUser);
    }

    @Override
    public UserModel saveUser(String username, String notEncodedPassword, String... roles)
    {
        UserModel user = new UserModel(username, passwordEncoder.encode(notEncodedPassword));
        List<Role> roleList = Arrays.stream(roles)
                                    .map(Role::new)
                                    .collect(Collectors.toList());

        user.setRoles(roleList);
        return saveUser(user);
    }

    @Override
    public UserIndicator save(UserIndicator userIndicator)
    {
        return userIndicatorRepository.save(userIndicator);
    }

    @Override
    public UserIndicator findUserIndicatorById(String id)
    {
        return userIndicatorRepository.findById(id)
                                      .orElse(new UserIndicator());
    }

    @Override
    public void deleteUserById(String id)
    {
        userIndicatorRepository.deleteById(id);
    }

    @Override
    public void deleteThese(List<UserIndicator> userIndicatorList)
    {
        userIndicatorRepository.deleteAll(userIndicatorList);
    }

    @Override
    public Map deleteIndicator(String username, String indicatorId)
    {
        Map<String, String> response = new HashMap<>();
        UserModel user = findByUsername(username);

        if (user == null)
        {
            log.info("Error: The user : " + username + " does not exist");
            response.put("Error", "The user: " + username + " does not exist");
            return response;
        }

        List<UserIndicator> indicators = user.getUserIndicators();
        boolean isIndicatorDeleted = false;

        for (UserIndicator indicator : indicators)
            if (indicator.getId().equals(indicatorId))
            {
                isIndicatorDeleted = true;
                indicators.remove(indicator);
                break;
            }

        if (!isIndicatorDeleted)
        {
            log.info("Error: Indicator " + indicatorId + " does not exist");
            response.put("Error", "The indicator with id " + indicatorId + "could not be retrieved");
            return response;
        }

        saveUser(user);
        userIndicatorRepository.deleteById(indicatorId);

        response.put("Status", "Indicator deleted successfully");
        return response;
    }

    @Override
    public boolean registerNewUser(UserRegisterDto user)
    {
        UserModel userModel = findByUsername(user.getUsername());
        if (userModel != null)
            return false;

        saveUser(user.getUsername(), user.getPassword(), "ROLE_USER");
        return true;
    }
}
