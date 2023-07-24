package soulasphyxia.ui;
import soulasphyxia.utils.ResourcesLoader;

import java.awt.*;
import java.io.*;
import java.util.List;

public class Fonts {
    final GraphicsEnvironment GE = GraphicsEnvironment.getLocalGraphicsEnvironment();
    final List<String> AVAILABLE_FONT_FAMILY_NAMES = List.of(GE.getAvailableFontFamilyNames());
    private final ResourcesLoader rl = new ResourcesLoader();
    public void initializeFonts() throws IOException, FontFormatException {

        Font font = Font.createFont(Font.TRUETYPE_FONT,rl.getFontResource("digital_counter.ttf"));
        if (!AVAILABLE_FONT_FAMILY_NAMES.contains(font.getFontName())){
                GE.registerFont(font);
        }

    }

}
