package com.google.appinventor.client.editor.simple.components;

import com.google.appinventor.client.editor.simple.SimpleEditor;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.SimplePanel;

public class MockGalleryViewer extends MockVisibleComponent {

    private final Image largeImage = new Image(images.galleryviewerbig());

    /**
     * Component type name.
     */
    public static final String TYPE = "GalleryViewer";

    /**
     * Creates a new MockGalleryViewer component.
     *
     * @param editor  editor of source file the component belongs to
     */
    public MockGalleryViewer(SimpleEditor editor) {
        super(editor, TYPE, images.galleryviewer());

        // Initialize mock GalleryViewer UI
        SimplePanel myWidget = new SimplePanel();
        myWidget.setStylePrimaryName("ode-SimpleMockContainer");
        myWidget.addStyleDependentName("centerContents");
        myWidget.setWidget(largeImage);
        initComponent(myWidget);
    }

    @Override
    public int getPreferredWidth() {
        return largeImage.getHeight();
    }

    //overwrite and make the length to fill parent
    @Override
    int getWidthHint() {
        int widthHint = super.getWidthHint();
        if (widthHint == LENGTH_PREFERRED) {
            widthHint = LENGTH_FILL_PARENT;
        }
        return widthHint;
    }


}
