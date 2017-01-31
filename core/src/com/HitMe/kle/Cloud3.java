package com.HitMe.kle;

import com.nilunder.bdx.GameObject;
import com.nilunder.bdx.utils.Random;

import javax.vecmath.Vector3f;

/**
 * Created by samarthhalyal on 26/01/17.
 */
public class Cloud3 extends GameObject {
    private Vector3f bl;
    private Vector3f tr;

    public void init(){
        bl = scene.objects.get("BL").position();
        tr = scene.objects.get("TR").position();
    }

    public void main(){
        if(position().z > tr.z){
            position(bl.x + Random.random() * (tr.x-bl.x),Random.random(),bl.z);
        }
        move(0,0,0.01f);
    }
}
