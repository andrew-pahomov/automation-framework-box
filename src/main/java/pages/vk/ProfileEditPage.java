package pages.vk;

import io.qameta.atlas.webdriver.extension.FindBy;
import pages.html_elements.Input;
import pages.html_elements.Link;
import pages.vk.blocks.ListBlock;
import pages.vk.blocks.ListBlockByName;
import pages.vk.blocks.ProfileEditBlock;
import ru.lanit.at.pages.AbstractPage;
import ru.lanit.at.pages.annotations.Title;
import ru.lanit.at.pages.annotations.WithName;

@Title("Страница редактирования профиля")
public interface ProfileEditPage extends AbstractPage, Link.WithLink, ProfileEditBlock.WithProfileEditBlock,
        ListBlockByName.WithListBlockByName, ListBlock.WithDayListBlock {

    @WithName("Поле ввода имени")
    @FindBy("//input[@id='pedit_first_name']")
    Input nameField();

    @WithName("Поле ввода фамилии")
    @FindBy("//input[@id='pedit_first_name']")
    Input lastNameField();

}
