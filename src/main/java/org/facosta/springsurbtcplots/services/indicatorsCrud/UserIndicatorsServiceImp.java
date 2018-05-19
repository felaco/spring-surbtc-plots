package org.facosta.springsurbtcplots.services.indicatorsCrud;

import org.facosta.springsurbtcplots.commands.IndicatorCommand;
import org.facosta.springsurbtcplots.commands.UserCommand;
import org.facosta.springsurbtcplots.commands.converter.UserCommandConverter;
import org.facosta.springsurbtcplots.models.entity.IndicatorWrapper;
import org.facosta.springsurbtcplots.models.entity.UserModel;
import org.facosta.springsurbtcplots.repository.IndicatorWrapperRepository;
import org.facosta.springsurbtcplots.repository.UserRepository;
import org.facosta.springsurbtcplots.services.indicatorsCrud.interfaces.UserIndicatorsService;
import org.facosta.springsurbtcplots.utils.indicatorUtilities.IndicatorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserIndicatorsServiceImp implements UserIndicatorsService
{
    private UserRepository userRepository;
    private IndicatorWrapperRepository indicatorWrapperRepository;

    @Autowired
    public UserIndicatorsServiceImp(UserRepository userRepository, IndicatorWrapperRepository indicatorWrapperRepository)
    {
        this.userRepository = userRepository;
        this.indicatorWrapperRepository = indicatorWrapperRepository;
    }

    @Override
    public UserCommand findUserByName(String name)
    {
        UserModel userModel = userRepository.findByUsername(name);
        return UserCommandConverter.fromUserModel(userModel);
    }

    @Override
    public IndicatorCommand insertDefaultIndicator(String userName, String indicatorName)
    {
        IndicatorWrapper indicatorWrapper = IndicatorFactory.buildIndicator(indicatorName);
        UserModel currentUser = userRepository.findByUsername(userName);
        currentUser.getIndicatorWrappers().add(indicatorWrapper);

        indicatorWrapper.setUser(currentUser);
        indicatorWrapperRepository.save(indicatorWrapper);

        IndicatorCommand indicatorCommand;
        indicatorCommand = UserCommandConverter.indicatorWrapper2IndicatorCommand(indicatorWrapper);
        indicatorCommand.setIndex(currentUser.getIndicatorWrappers().size() - 1);

        return indicatorCommand;
    }
}
