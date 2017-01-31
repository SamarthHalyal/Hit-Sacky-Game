package com.HitMe.kle.inst;

import com.badlogic.gdx.utils.JsonValue;
import com.nilunder.bdx.Instantiator;import com.nilunder.bdx.GameObject;
import com.HitMe.kle.*;
public class iMain extends Instantiator {

	public GameObject newObject(JsonValue gobj){
		String name = gobj.name;

		if (gobj.get("class").asString().equals("Player"))
			return new com.HitMe.kle.Player();
		if (gobj.get("class").asString().equals("Crux"))
			return new com.HitMe.kle.Crux();
		if (gobj.get("class").asString().equals("Bottle"))
			return new com.HitMe.kle.Bottle();
		if (gobj.get("class").asString().equals("Sacky"))
			return new com.HitMe.kle.Sacky();
		if (gobj.get("class").asString().equals("Platform"))
			return new com.HitMe.kle.Platform();

		return super.newObject(gobj);
	}
	
}
