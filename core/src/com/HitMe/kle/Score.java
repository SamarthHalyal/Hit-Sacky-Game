package com.HitMe.kle;

import com.nilunder.bdx.Bdx;
import com.nilunder.bdx.Scene;
import com.nilunder.bdx.Text;

/**
 * Created by samarthhalyal on 26/01/17.
 */
public class Score extends Text {
    private Sacky sacky;
    public int score;
    private Scene mainScene;
    private Platform platform;

    public void init() {
        Scene mainScene = Bdx.scenes.get("Main");
        sacky = (Sacky) mainScene.objects.get("Sacky");
        platform = (Platform) mainScene.objects.get("Platform");
    }

    public void main() {
        if (sacky.hit("Bottle")) {
            ++score;
            new Score1();
            text(String.format("%03d", score));
        }
        if (platform.hit("Bottle")) {
            score = 0;
            text(String.format("%03d", score));
        }
    }
}
