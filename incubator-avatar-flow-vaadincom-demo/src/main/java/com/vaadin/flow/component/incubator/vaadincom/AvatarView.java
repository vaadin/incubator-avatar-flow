package com.vaadin.flow.component.incubator.vaadincom;

/*
 * #%L
 * Vaadin IncubatorAvatar Example for Vaadin 10
 * %%
 * Copyright (C) 2017 - 2018 Vaadin Ltd
 * %%
 * This program is available under Commercial Vaadin Add-On License 3.0
 * (CVALv3).
 *
 * See the file license.html distributed with this software for more
 * information about licensing.
 *
 * You should have received a copy of the CVALv3 along with this program.
 * If not, see <http://vaadin.com/license/cval-3>.
 * #L%
 */


import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.incubator.Avatar;
import com.vaadin.flow.component.incubator.TooltipAlignment;
import com.vaadin.flow.component.incubator.TooltipPosition;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.demo.DemoView;
import com.vaadin.flow.router.Route;

/**
 * Server-side component Example for the <code>incubator-avatar</code> element.
 *
 * @author Vaadin Ltd
 */
@Route("avatar")
public class AvatarView extends DemoView {

    public final String IMG_URL = "https://mbtskoudsalg.com/images/pacman-blue-ghost-png-2.png";
    public final String USR_IMAGE_PATH = "src/main/resources/images/user.png";

    @Override
    protected void initView() {
        exampleAvatarImageURL();
        exampleAvatarImagePath();
        dynamicNameChange();
        exampleAvatarAbbreviationToolTip();
        enableDisableToolip();
        exampleAvatarAbbreviationToolTipClickButton();
    }

    private void exampleAvatarImageURL(){
        Avatar avatar = new Avatar("Diego");
        avatar.setImage(IMG_URL);

        addCard("Avatar - Image from URL", avatar);
    }

    private void exampleAvatarImagePath(){
        Avatar avatar = new Avatar();
        avatar.setImage(USR_IMAGE_PATH,"image/png");

        addCard("Avatar - Image from resources", avatar);
    }

    private void exampleAvatarAbbreviationToolTip(){
        Avatar avatar = new Avatar("John Smith");
        avatar.setTooltipPosition(TooltipPosition.RIGHT);
        avatar.setTooltipAlignment(TooltipAlignment.BOTTOM);
        addCard("Avatar - Abbreviations and tooltip", avatar);
    }

    private void dynamicNameChange(){
        Avatar avatar = new Avatar("Sophia Wilson");

        TextField nameTF = new TextField("Avatar's name");
        nameTF.setValue(avatar.getName());
        nameTF.setValueChangeMode(ValueChangeMode.EAGER);

        nameTF.addValueChangeListener(event -> {
            avatar.setName(event.getValue());
        });

        addCard("Avatar - Change in name", avatar,nameTF);
    }

    private void enableDisableToolip(){
        Avatar avatar = new Avatar("Sophia Wilson");

        Button actionButton = new Button("enable/disable", event -> {
            avatar.setToolTipEnabled(!avatar.isToolTipEnabled());
        });

        addCard("Avatar - Disabling and enabling tooltip", avatar, actionButton);
    }

    private void exampleAvatarAbbreviationToolTipClickButton(){
        Avatar avatar = new Avatar();
        avatar.setName("Click on the avatar!");
        avatar.setTooltipPosition(TooltipPosition.BOTTOM);
        avatar.setTooltipAlignment(TooltipAlignment.RIGHT);

        avatar.addClickListener(clickEvent -> {
            Notification notification = new Notification(
                    "You clicked on the avatar", 3000);
            notification.open();
        });

        addCard("Avatar - Click listener", avatar);
    }
}
