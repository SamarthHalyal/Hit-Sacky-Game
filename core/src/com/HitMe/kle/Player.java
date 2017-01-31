package com.HitMe.kle;

import com.nilunder.bdx.Bdx;
import com.nilunder.bdx.GameObject;
import com.nilunder.bdx.Scene;

import javax.vecmath.Vector3f;

/**
 * Created by samarthhalyal on 25/01/17.
 */
public class Player extends GameObject {
    public boolean canThrowBottles;

    public void init(){
        Bdx.scenes.add(0, new Scene("Tail"));
        Bdx.scenes.add(new Scene("Head"));
        canThrowBottles = false;
    }

    public void main(){
        if(canThrowBottles && Bdx.mouse.btnHit("left") && (noBottlesOnTheScreen())){
            GameObject bottle = scene.add("Bottle");
            bottle.position(scene.camera.position());
            Vector3f v = Bdx.mouse.rayDirection();
            v.z += 0.2;
            v.length(15);
            bottle.velocity(v);
            Bdx.sounds.get("whoosh").play();
        }
    }
    public boolean noBottlesOnTheScreen(){
        return scene.objects.get("Bottle") == null;
    }
}
