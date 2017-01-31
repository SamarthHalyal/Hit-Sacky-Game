package com.HitMe.kle;

import com.nilunder.bdx.*;
import com.nilunder.bdx.components.SpriteAnim;
import com.nilunder.bdx.utils.Random;

import javax.vecmath.Vector3f;

public class Sacky extends GameObject{
    private int platformHitcount = 0;
    public SpriteAnim sprite;

    public void init(){
        sprite = new SpriteAnim(children.get("G_Sacky"),32,32);
        sprite.add("jump",0,new int[]{0,1,2,3});
        sprite.add("normal", 0, new int[]{4,5,6,7});
        components.add(sprite);
    }

    public void main(){
        children.get("G_Sacky").orientation(scene.camera.orientation());
        sprite.speed = 0.1f + velocity().length()/3;
        if(hit("Bottle")){
            Jump(Random.direction());
            touchingObjects.get("Bottle").end();
            platformHitcount=0;
            sprite.play("jump");
            Bdx.sounds.get("gulp").play();
        }
        if(platformHitcount >= 2){
            sprite.play("normal");
        }
        if(hit("Platform"))
        {
            ++platformHitcount;
        }
        if(hit("Platform") && platformHitcount <= 3){
            Bdx.sounds.get("thud").play();
        }
    }

    private void Jump(Vector3f direction) {
        Vector3f force = direction;
        force.z = 0;
        force.length(100);
        force.z = 200;
        applyForce(force);
    }
}