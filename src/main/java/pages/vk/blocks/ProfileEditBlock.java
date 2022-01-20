package pages.vk.blocks;

import io.qameta.atlas.webdriver.extension.FindBy;
import pages.html_elements.Button;
import pages.html_elements.DropDown;
import pages.html_elements.Link;
import ru.lanit.at.pages.annotations.Title;
import ru.lanit.at.pages.annotations.WithName;
import ru.lanit.at.pages.block.AbstractBlockElement;

@Title("Блок редактировани профиля")
public interface ProfileEditBlock extends AbstractBlockElement, Link.WithLink, DropDown.WithDropDown, Button.WithButton {

    @WithName("Кнопка сохранения")
    @FindBy("//button[text()='Сохранить']")
    Button saveButton();

    interface WithProfileEditBlock extends AbstractBlockElement {
        @FindBy("//div[@id='pedit_general']")
        ProfileEditBlock profileActionsBlock();
    }
}
