package org.edgegamers.picklez.storage;

import lombok.Getter;
import org.mineacademy.fo.settings.YamlConfig;

@Getter
public class Points extends YamlConfig {

    private int clanPoints;
    private int contributors;

    public Points(String clanName) {
        loadConfiguration("points.yml", "clans/" + clanName + ".yml");
    }

    @Override
    protected void onLoadFinish() {
        clanPoints = getInteger("Points");
        contributors = getInteger("Contributors");
    }

    public int getPoints() {
        return getInteger("Points");
    }

    public void addPoints(int points) {
        save("Points", (getPoints() + points));
    }

    public void setPoints(int points) {
        save("Points", points);
    }

    public String getName() {
        return getFileName();
    }
}
