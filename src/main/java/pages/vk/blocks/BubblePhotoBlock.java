package pages.vk.blocks;

import io.qameta.atlas.webdriver.extension.FindBy;
import pages.html_elements.Button;
import pages.html_elements.Image;
import ru.lanit.at.pages.annotations.Title;
import ru.lanit.at.pages.annotations.WithName;
import ru.lanit.at.pages.block.AbstractBlockElement;

@Title("Элемент выбора фотографии")
public interface BubblePhotoBlock extends AbstractBlockElement, Button.WithButton, Image.WithImage {

    @WithName("Кнопка выбора фотографии")
    @FindBy(".//span[text()='Обновить фотографию']")
    Button actionButton();

    @WithName("Фотография")
    @FindBy(".//img[@class='page_avatar_img']")
    Image photo();

    interface WithBubblePhotoBlock extends AbstractBlockElement {
        @FindBy("//div[@class='owner_photo_bubble']")
        BubblePhotoBlock bubblePhotoBlock();
    }
}
