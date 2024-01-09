package com.openclassrooms.paymybuddy;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PaymybuddyApplication.class)
@ActiveProfiles("test")
public abstract class AbstractConfigurationTest {

}
