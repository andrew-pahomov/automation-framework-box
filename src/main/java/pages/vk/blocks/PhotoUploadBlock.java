package pages.vk.blocks;

import io.qameta.atlas.webdriver.extension.FindBy;
import pages.html_elements.Button;
import pages.html_elements.Input;
import ru.lanit.at.pages.annotations.Title;
import ru.lanit.at.pages.annotations.WithName;
import ru.lanit.at.pages.block.AbstractBlockElement;

@Title("Блок загрузки фотографии")
public interface PhotoUploadBlock extends AbstractBlockElement, Button.WithButton, Input.WithInput {

    @WithName("Кнопка загрузки фотографии")
    @FindBy(".//button")
    Button makeChoiceButton();

    @WithName("Инпут загрузки фотографии")
    @FindBy(".//input[@type='file']")
    Input makeChoiceInput();

    interface WithPhotoUploadBlock extends AbstractBlockElement {
        @FindBy(".//div[@class='OwnerAvatarEditor__form']")
        PhotoUploadBlock photoUploadBlock();
    }
}
