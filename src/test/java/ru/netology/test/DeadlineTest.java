package ru.netology.test;
import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.SQL.SqlData;
import ru.netology.data.DataHelper;
import ru.netology.page.LoginPage;

import static com.codeborne.selenide.Selenide.open;

public class DeadlineTest {
        DataHelper.UserData user = new DataHelper().getUserFirst();

        @BeforeEach
        void setUp() {
        open("http://localhost:9999"); }

        @AfterAll
        static void clean() {
        SqlData.cleanDefaultData();
        }

        @Test
        void shouldBeValidAuthorization() {
                SqlData.createUser(user);

                new LoginPage().validLogin(user.getLogin(), user.getPassword()).validVerify(SqlData.getVerificationCode(user.getId()));
        }

        @Test
        void shouldBlockUserAfterInvalidPassword() {
        SqlData.createUser(user);

        new LoginPage()
                .invalidLogin(user.getLogin())
                .clearFields()
                .invalidLogin(user.getLogin())
                .clearFields()
                .invalidLogin(user.getLogin())
                .clearFields();

        String status = SqlData.getUserStatus(user.getId());

        Assertions.assertEquals("active", status);
        }
}