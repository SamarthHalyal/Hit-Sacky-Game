package com.HitMe.kle.inst;

import com.badlogic.gdx.utils.JsonValue;
import com.nilunder.bdx.Instantiator;import com.nilunder.bdx.GameObject;
import com.HitMe.kle.*;
public class iTail extends Instantiator {

	public GameObject newObject(JsonValue gobj){
		String name = gobj.name;

		if (gobj.get("class").asString().equals("Cloud3"))
			return new com.HitMe.kle.Cloud3();
		if (gobj.get("class").asString().equals("Cloud1"))
			return new com.HitMe.kle.Cloud1();
		if (gobj.get("class").asString().equals("Cloud"))
			return new com.HitMe.kle.Cloud();
		if (gobj.get("class").asString().equals("Cloud2"))
			return new com.HitMe.kle.Cloud2();

		return super.newObject(gobj);
	}
	
}
