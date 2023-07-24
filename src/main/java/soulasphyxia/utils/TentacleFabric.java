package soulasphyxia.utils;

import soulasphyxia.objects.Tentacle;

import java.util.ArrayList;
import java.util.List;

public class TentacleFabric {

    public static Tentacle getFirstSecondTentacle() {
        return new Tentacle(new ArrayList<>(List.of(
                new PositionFrame(1000,1000,"empty_frame.png"),
                new PositionFrame(160,123, "tentacle_1_1.png"),
                new PositionFrame(93,123,"tentacle_1_2.png"),
                new PositionFrame(58,105,"tentacle_1_3.png"),
                new PositionFrame(93,123,"tentacle_1_2.png"),
                new PositionFrame(160,123, "tentacle_1_1.png"),
                new PositionFrame(1000,1000,"empty_frame.png"),
                new PositionFrame(160,123, "tentacle_1_1.png"),
                new PositionFrame(123,108,"tentacle_1_4.png"),
                new PositionFrame(99,124,"tentacle_1_5.png"),
                new PositionFrame(103,127,"tentacle_1_6.png"),
                new PositionFrame(99,124,"tentacle_1_5.png"),
                new PositionFrame(123,108,"tentacle_1_4.png"),
                new PositionFrame(160,123, "tentacle_1_1.png"),
                new PositionFrame(1000,1000,"empty_frame.png")
        )));
    }

    public static Tentacle getFirstTentacle() {
        return new Tentacle(new ArrayList<>(List.of(
                new PositionFrame(1000,1000,"empty_frame.png"),
                new PositionFrame(160,123, "tentacle_1_1.png"),
                new PositionFrame(93,123,"tentacle_1_2.png"),
                new PositionFrame(58,105,"tentacle_1_3.png")
        )));
    }

    public static Tentacle getSecondTentacle() {
        return new Tentacle(new ArrayList<>(List.of(
                new PositionFrame(1000,1000,"empty_frame.png"),
                new PositionFrame(160,123, "tentacle_1_1.png"),
                new PositionFrame(123,108,"tentacle_1_4.png"),
                new PositionFrame(99,124,"tentacle_1_5.png"),
                new PositionFrame(103,127,"tentacle_1_6.png")
        )));
    }
    public static Tentacle getThirdTentacle() {
        return new Tentacle(new ArrayList<>(List.of(
                new PositionFrame(1000,1000,"empty_frame.png"),
                new PositionFrame(231,155, "tentacle_2_1.png"),
                new PositionFrame(231,159,"tentacle_2_2.png"),
                new PositionFrame(231,165,"tentacle_2_3.png"),
                new PositionFrame(231,170,"tentacle_2_4.png"),
                new PositionFrame(231,172,"tentacle_2_5.png")

        )));
    }
    public static Tentacle getFourthTentacle() {
        return new Tentacle(new ArrayList<>(List.of(
                new PositionFrame(1000,1000,"empty_frame.png"),
                new PositionFrame(315,212, "tentacle_3_1.png"),
                new PositionFrame(315,213,"tentacle_3_2.png"),
                new PositionFrame(315,213,"tentacle_3_3.png"),
                new PositionFrame(315,213,"tentacle_3_4.png")

        )));
    }
    public static Tentacle getFifthTentacle() {
        return new Tentacle(new ArrayList<>(List.of(
                new PositionFrame(1000,1000,"empty_frame.png"),
                new PositionFrame(444,243, "tentacle_4_1.png"),
                new PositionFrame(444,243,"tentacle_4_2.png"),
                new PositionFrame(444,243,"tentacle_4_3.png")
        )));
    }

    public static List<Tentacle> getTentacles() {
        return List.of(getFirstSecondTentacle(),getThirdTentacle(),getFourthTentacle(),getFifthTentacle());
    }
}
