package ru.netology.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CardListPage {
    private SelenideElement depositButton = $("[data-test-id=action-deposit]");
    private SelenideElement field1=$(withText("баланс"));
    private SelenideElement depositButton2 = $$("[data-test-id=action-deposit]").last();
    private SelenideElement field2=$$(withText("баланс")).last();
    private SelenideElement reloadButton = $("[data-test-id=action-reload]");
}
