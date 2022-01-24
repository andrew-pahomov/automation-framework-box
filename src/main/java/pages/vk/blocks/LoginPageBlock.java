package pages.vk.blocks;

import io.qameta.atlas.webdriver.extension.FindBy;
import pages.html_elements.Button;
import pages.html_elements.Input;
import ru.lanit.at.pages.annotations.Title;
import ru.lanit.at.pages.annotations.WithName;
import ru.lanit.at.pages.block.AbstractBlockElement;

@Title("Блок логина")
public interface LoginPageBlock extends AbstractBlockElement,
        Input.WithInput, Button.WithButton {

    default void ввести_логин(String data) {
        input_element("Телефон или email").sendKeys(data);
    }

    default void ввести_пароль(String data) {
        input_element("Пароль").sendKeys(data);
    }

    @WithName("Поле ввода логина")
    @FindBy("//input[@id='index_email']")
    Input loginField();

    @WithName("Поле ввода пароля")
    @FindBy("//input[@id='index_pass']")
    Input passwordField();

    @WithName("Кнопка логина")
    @FindBy("descendant::button[@id='index_login_button']")
    Button loginButton();

    interface WithLoginPageBlock extends AbstractBlockElement {
        @FindBy("descendant::form[@id='index_login_form']")
        LoginPageBlock loginBlock();
    }
}
