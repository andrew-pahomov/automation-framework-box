package pages.vk;

import pages.vk.blocks.ListBlock;
import pages.vk.blocks.LoginPageBlock;
import ru.lanit.at.pages.AbstractPage;
import ru.lanit.at.pages.annotations.Title;

@Title("Страница логина Vk")
public interface LoginPage extends AbstractPage, LoginPageBlock.WithLoginPageBlock, ListBlock.WithDayListBlock {

}
