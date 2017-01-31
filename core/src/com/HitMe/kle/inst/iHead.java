package com.HitMe.kle.inst;

import com.badlogic.gdx.utils.JsonValue;
import com.nilunder.bdx.Instantiator;import com.nilunder.bdx.GameObject;
import com.HitMe.kle.*;
public class iHead extends Instantiator {

	public GameObject newObject(JsonValue gobj){
		String name = gobj.name;

		if (gobj.get("class").asString().equals("Score1"))
			return new com.HitMe.kle.Score1();
		if (gobj.get("class").asString().equals("Head"))
			return new com.HitMe.kle.Head();
		if (gobj.get("class").asString().equals("Score"))
			return new com.HitMe.kle.Score();

		return super.newObject(gobj);
	}
	
}
