package com.vaadin.flow.component.incubator;

/*
 * #%L
 * Vaadin IncubatorAvatar for Vaadin 10
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

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.DomEvent;
import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.shared.Registration;

/**
 * Server-side component for the <code>incubator-avatar</code> element.
 * <p>
 * Note:
 *  If the name is specified, the abbreviation takes the initials of the name.
 *  I.e. John Smith(name) JS(abbreviation).
 *
 *
 * @author Vaadin Ltd
 */
@Tag("incubator-avatar")
@HtmlImport("bower_components/incubator-avatar/src/incubator-avatar.html")
public class Avatar extends Component implements HasStyle {

    /**
     * Click event on the component.
     */
    @DomEvent("click")
    public static class ClickEvent extends ComponentEvent<Avatar> {

        public ClickEvent(Avatar source, boolean fromClient) {
            super(source, fromClient);
        }
    }

    // client-side component property constants
    private final String NAME_PROPERTY = "name";
    private final String IMAGE_PROPERTY = "image";
    private final String ABBR_PROPERTY = "abbr";
    private final String TOOLTIP_POSITION_PROPERTY = "tooltipPosition";
    private final String TOOLTIP_ALIGN_PROPERTY = "tooltipAlign";
    private final String NO_TOOLTIP_PROPERTY = "noTooltip";
    private final String WITH_IMAGE = "withImage";

    /**
     * Default constructor. The tooltip is enable by default.
     * <p>
     * The tooltip will not appear if the avatar's name is empty.
     */
    public Avatar() {
        setToolTipEnabled(true);
    }

    /**
     * Sets an Avatar, initializing its name.
     * <p>
     * The tooltip is enabled by default.
     * The tooltip will not appear if the avatar's name is empty.
     *
     * @param name avatar's name
     *
     * @see #setName(String)
     */
    public Avatar(String name) {
        this();
        setName(name);
    }

    /**
     * Sets an Avatar, initializing its name and setting the tooltip's position.
     * <p>
     * The tooltip is enabled by default.
     * The tooltip will not appear if the avatar's name is empty.
     *
     * @param name avatar's name
     * @param tooltipPosition The position of the tooltip {@link TooltipPosition}
     */
    public Avatar(String name, TooltipPosition tooltipPosition) {
        this(name);
        setTooltipPosition(tooltipPosition);
    }

    /**
     * Sets an Avatar, initializing its name, setting the tooltip's position and
     * alignment.
     * <p>
     * The tooltip is enabled by default.
     * The tooltip will not appear if the avatar's name is empty.
     *
     * @param name avatar's name
     * @param tooltipPosition The position of the tooltip {@link TooltipPosition}
     * @param tooltipAlignment The alignment of the tooltip {@link TooltipAlignment}
     */
    public Avatar(String name, TooltipPosition tooltipPosition, TooltipAlignment tooltipAlignment) {
        this(name,tooltipPosition);
        setTooltipAlignment(tooltipAlignment);
    }

    /**
     * Sets the avatar's name.
     *
     * @param name avatar's name
     */
    public void setName(String name) {
        getElement().setProperty(NAME_PROPERTY, name);
    }

    /**
     * Gets the avatar's name.
     * <p>
     * This property is not synchronized automatically from the client side, so
     * the returned value may not be the same as in client side.
     *
     * @return name avatar's name
     */
    public String getName() {
        return getElement().getProperty(NAME_PROPERTY, "");
    }

    /**
     * Sets the avatar's image from a url.
     *
     * @param imageUrl url of the image
     */
    public void setImage(String imageUrl) {
        getElement().setProperty(IMAGE_PROPERTY, imageUrl);
    }

    /**
     * Sets the avatar's image from a image path.
     * <p>
     * It opens the image, reads the bytes and encodes them to base64.
     * After that the image is converted to data URI.
     *
     * @param imagePath path of the image
     * @param contentType MIME type
     */
    public void setImage(String imagePath, String contentType){
        try {
            setImage(getBytesFromFile(imagePath),contentType);
        } catch (IOException e) {
            throw new RuntimeException("It was not possible to set the image from the path: " + imagePath);
        }
    }

    /**
     * Sets the avatar's image from an array of bytes.
     * <p>
     * It encodes the bytes to base64.
     * After that the image is converted to data URI.
     *
     * @param bytes image's bytes
     * @param contentType MIME type
     */
    public void setImage(byte[] bytes, String contentType) {
        String encodedImg = Base64.getEncoder().encodeToString(bytes);
        setImage("data:" + contentType + ";base64," + encodedImg);
    }

    /**
     * Gets the avatar's image.
     * <p>
     * This property is not synchronized automatically from the client side, so
     * the returned value may not be the same as in client side.
     *
     * @return img string representation of the image
     */
    public String getImage() {
        return getElement().getProperty(IMAGE_PROPERTY, "");
    }

    /**
     * Sets the abbreviations of the avatar.
     * <p>
     * This method does not have effect if the avatar's name is already specified.
     * The avatar's abbreviations is take from the name.
     * 
     * @param abbr avatar's abbreviation
     */
    public void setAbbreviation(String abbr) {
        getElement().setProperty(ABBR_PROPERTY, abbr);
    }

    /**
     * Gets the abbreviations of the avatar's name.
     * <p>
     * This property is not synchronized automatically from the client side, so
     * the returned value may not be the same as in client side.
     *
     * @return abbr avatar's abbreviation
     */
    public String getAbbreviation() {
        return getElement().getProperty(ABBR_PROPERTY);
    }

    /**
     * Checks if the avatar's tooltip is enabled.
     * <p>
     * This property is not synchronized automatically from the client side, so
     * the returned value may not be the same as in client side.
     *
     * @return <code>true</code> if avatar's tooltip is enabled
     *         <code>false</code> otherwise
     */
    public boolean isToolTipEnabled() {
        return !getElement().getProperty(NO_TOOLTIP_PROPERTY, false);
    }

    /**
     * Enables or disables the avatar's tooltip.
     *
     * @param enabled enable or disable
     */
    public void setToolTipEnabled(boolean enabled) {
        getElement().setProperty(NO_TOOLTIP_PROPERTY, !enabled);
    }

    /**
     * Checks if the avatar has an image.
     *
     * <p>
     * This property is not synchronized automatically from the client side, so
     * the returned value may not be the same as in client side.
     *
     * @return  <code>true</code> the avatar has an image
     *          <code>false</code>, otherwise
     */
    public boolean hasImage() {
        return getElement().getProperty(WITH_IMAGE, false);
    }

    /**
     * Sets the position of the tooltip.
     *
     * @param position The position of the tooltip {@link TooltipPosition}
     */
    public void setTooltipPosition(TooltipPosition position) {
        setTooltipPosition(position.getPositionText());
    }

    /**
     * Gets the position of the tooltip.
     * <p>
     * This property is not synchronized automatically from the client side, so
     * the returned value may not be the same as in client side.
     *
     * @return position The position of the tooltip {@link TooltipPosition}
     **/
    public TooltipPosition getTooltipPosition() {
        return TooltipPosition.getPosition(getTooltipPositionText());
    }

    /**
     * Sets the alignment of the tooltip.
     *
     * @param alignment The alignment of the tooltip {@link TooltipAlignment}
     */
    public void setTooltipAlignment(TooltipAlignment alignment) {
        setTooltipAlignment(alignment.getAlignmentText());
    }

    /**
     * Gets the alignment of the tooltip.
     * <p>
     * This property is not synchronized automatically from the client side, so
     * the returned value may not be the same as in client side.
     *
     * @return alignment The alignment of the tooltip {@link TooltipAlignment}
     **/
    public TooltipAlignment getTooltipAlignment() {
        return TooltipAlignment.getAlignment(getTooltipAlignmentText());
    }

    /**
     * Adds a listener for {@code ClickEvent}.
     *
     * @param listener the listener
     * @return a {@link Registration} for removing the event listener
     */
    public Registration addClickListener(ComponentEventListener<ClickEvent> listener) {
        return addListener(ClickEvent.class, listener);
    }

    /**
     * Sets the position of the tooltip.
     *
     * @param position "top","right","left" or "bottom"
     */
    private void setTooltipPosition(String position) {
        getElement().setProperty(TOOLTIP_POSITION_PROPERTY, position);
    }

    /**
     * Gets the position of the tooltip.
     * <p>
     * This property is not synchronized automatically from the client side, so
     * the returned value may not be the same as in client side.
     *
     * @return position "top","right","left" or "bottom"
     */
    private String getTooltipPositionText() {
        return getElement().getProperty(TOOLTIP_POSITION_PROPERTY);
    }

    /**
     * Sets the alignment of the tooltip.
     *
     * @param alignment alignment "top","right","left","bottom" or "center"
     */
    private void setTooltipAlignment(String alignment) {
        getElement().setProperty(TOOLTIP_ALIGN_PROPERTY, alignment);
    }

    /**
     * Gets the alignment of the tooltip.
     * <p>
     * This property is not synchronized automatically from the client side, so
     * the returned value may not be the same as in client side.
     *
     * @return alignment "top","right","left","bottom" or "center"
     */
    private String getTooltipAlignmentText() {
        return getElement().getProperty(TOOLTIP_ALIGN_PROPERTY);
    }

    private byte[] getBytesFromFile(String imagePath) throws IOException {
        File file = new File(imagePath);
        return Files.readAllBytes(file.toPath());
    }
}