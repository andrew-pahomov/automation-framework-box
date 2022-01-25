package pages.vk.blocks;

import io.qameta.atlas.webdriver.extension.FindBy;
import pages.html_elements.Button;
import pages.html_elements.Input;
import ru.lanit.at.pages.annotations.Title;
import ru.lanit.at.pages.annotations.WithName;
import ru.lanit.at.pages.block.AbstractBlockElement;

@Title("Блок сохранения фотографии")
public interface OwnerAvatarContentBlock extends AbstractBlockElement, Button.WithButton {

    @WithName("Кнопка сохранения")
    @FindBy(".//button")
    Button saveButton();

    interface WithOwnerAvatarContentBlock extends AbstractBlockElement {
        @FindBy(".//div[@class='OwnerAvatarEditor__content']")
        OwnerAvatarContentBlock ownerAvatarContentBlock();
    }
}
