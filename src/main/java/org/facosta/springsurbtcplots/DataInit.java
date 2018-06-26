package org.facosta.springsurbtcplots;

import org.facosta.springsurbtcplots.models.entity.Role;
import org.facosta.springsurbtcplots.models.entity.SupportedIndicators;
import org.facosta.springsurbtcplots.models.entity.UserModel;
import org.facosta.springsurbtcplots.repository.SupportedIndicatorsRepository;
import org.facosta.springsurbtcplots.repository.UserIndicatorRepository;
import org.facosta.springsurbtcplots.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DataInit
{
    private UserRepository userRepository;
    private SupportedIndicatorsRepository supportedIndicatorsRepository;
    private UserIndicatorRepository userIndicatorRepository;
    private PasswordEncoder passwordEncoder;
    private boolean generate_data;
    private boolean delete_data;


    @Autowired
    public DataInit(UserRepository userRepository, PasswordEncoder passwordEncoder,
                    SupportedIndicatorsRepository indicatorRepository,
                    UserIndicatorRepository userIndicatorRepository,
                    @Value("${mongodb.init-strategy}") String generate_ddl)
    {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.supportedIndicatorsRepository = indicatorRepository;
        this.userIndicatorRepository = userIndicatorRepository;

        String[] create_if = new String[]{"create", "delete-create"};
        this.generate_data = Arrays.asList(create_if).contains(generate_ddl);
        this.delete_data = generate_ddl.equals("delete-create");
    }

    @EventListener(ApplicationReadyEvent.class)
    public void run() throws Exception
    {
        if (delete_data)
        {
            userRepository.deleteAll();
            supportedIndicatorsRepository.deleteAll();
            userIndicatorRepository.deleteAll();
        }
        if (generate_data)
        {
            List<SupportedIndicators> supportedIndicatorsList;
            SupportedIndicators ema, rsi, macd, bollinger;
            ema = new SupportedIndicators("ema",
                                          new String[]{"period"});

            rsi = new SupportedIndicators("rsi",
                                          new String[]{"period"});

            macd = new SupportedIndicators("macd",
                                           new String[]{"period", "longPeriod",
                                                   "shortPeriod", "signalPeriod"});

            bollinger = new SupportedIndicators("BollingerBand",
                                                new String[]{"period", "standardDeviation"});

            supportedIndicatorsList = new ArrayList<>(Arrays.asList(ema, rsi, macd, bollinger));
            supportedIndicatorsRepository.saveAll(supportedIndicatorsList);

            /* =========== Admin user registration ==================*/
            Role admin = new Role("ROLE_ADMIN");
            Role user_role = new Role("ROLE_USER");

            String pass = "ThisPassShouldBeHard";
            UserModel userModel = new UserModel("admin",
                                                passwordEncoder.encode(pass));

            userModel.getRoles().add(admin);
            userModel.getRoles().add(user_role);
            userRepository.save(userModel);

            /* ============= Random user registration =============*/

            userModel = new UserModel("user",
                                      passwordEncoder.encode("123456"));

            userModel.getRoles().add(user_role);
            userRepository.save(userModel);
        }
    }
}
