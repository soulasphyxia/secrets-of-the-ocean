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
        final List<FileInputStream> fonts = List.of(
                new FileInputStream(rl.getResource("fonts/digital_counter.ttf").getFile())
        );

        for(FileInputStream font_file : fonts) {
            Font font = Font.createFont(Font.TRUETYPE_FONT,font_file);
            if (!AVAILABLE_FONT_FAMILY_NAMES.contains(font.getFontName())){
                GE.registerFont(font);
            }
        }
    }

}
