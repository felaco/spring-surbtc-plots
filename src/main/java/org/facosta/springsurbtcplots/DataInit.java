package org.facosta.springsurbtcplots;

import org.facosta.springsurbtcplots.models.entity.Indicator;
import org.facosta.springsurbtcplots.models.entity.Role;
import org.facosta.springsurbtcplots.models.entity.UserModel;
import org.facosta.springsurbtcplots.repository.IndicatorRepository;
import org.facosta.springsurbtcplots.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DataInit
{
    private UserRepository userRepository;
    private IndicatorRepository indicatorRepository;
    private PasswordEncoder passwordEncoder;
    private boolean generate_data;

    @Autowired
    public DataInit(UserRepository userRepository, PasswordEncoder passwordEncoder,
                    IndicatorRepository indicatorRepository,
                    @Value("${spring.jpa.hibernate.ddl-auto}") String generate_ddl)
    {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.indicatorRepository = indicatorRepository;

        String[] create_if = new String[]{"create", "create-drop"};
        this.generate_data = Arrays.asList(create_if).contains(generate_ddl);
    }

    @EventListener(ApplicationReadyEvent.class)
    @Transactional
    public void run() throws Exception
    {
        if(generate_data)
        {
            List<Indicator> indicatorList = new ArrayList<>();
            indicatorList.add(new Indicator("rsi", 1));
            indicatorList.add(new Indicator("ema", 1));
            indicatorList.add(new Indicator("macd", 4));
            indicatorList.add(new Indicator("bollingerBand", 2));
            indicatorRepository.saveAll(indicatorList);

            /* =========== Admin user registration ==================*/
            Role admin = new Role("ROLE_ADMIN");
            Role user_role = new Role("ROLE_USER");
            String pass = "ThisPassShouldBeHard";
            UserModel userModel = new UserModel("admin",
                                                passwordEncoder.encode(pass));

            userModel.getRoles().add(admin);
            userModel.getRoles().add(user_role);
            userRepository.save(userModel);

            userModel = new UserModel("user",
                                      passwordEncoder.encode("123456"));

            userModel.getRoles().add(user_role);
            userRepository.save(userModel);
        }
    }
}
