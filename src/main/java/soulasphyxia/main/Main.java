package soulasphyxia.main;
import com.fasterxml.jackson.core.type.TypeReference;
import soulasphyxia.utils.FileResourcesUtils;
import soulasphyxia.utils.HighScoreReader;
import soulasphyxia.utils.HighScoreRecord;
import soulasphyxia.utils.ResourcesLoader;

import java.awt.*;
import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Objects;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException, FontFormatException, URISyntaxException {
        new Game();
    }
}