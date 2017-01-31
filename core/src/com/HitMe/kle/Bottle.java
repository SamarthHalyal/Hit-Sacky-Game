package com.HitMe.kle;

import com.nilunder.bdx.Bdx;
import com.nilunder.bdx.GameObject;

/**
 * Created by samarthhalyal on 25/01/17.
 */
public class Bottle extends GameObject {
    public void main(){
        if(hit("Platform") || position().z < 0 || hit("Sacky")){
            end();
        }
        else{
            children.get("G_Bottle").orientation(scene.camera.orientation());
        }
    }
}
