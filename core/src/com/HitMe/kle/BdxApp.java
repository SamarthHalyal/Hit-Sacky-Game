package com.HitMe.kle;

import java.util.*;

import com.badlogic.gdx.*;

import com.nilunder.bdx.*;

public class BdxApp implements ApplicationListener {


	@Override
	public void create(){
		Bdx.init();

		Scene.instantiators = new HashMap<String, Instantiator>();
		Scene.instantiators.put("Head", new com.HitMe.kle.inst.iHead());
		Scene.instantiators.put("Main", new com.HitMe.kle.inst.iMain());
		Scene.instantiators.put("Tail", new com.HitMe.kle.inst.iTail());

		Bdx.scenes.add(new Scene("Main"));
		Bdx.firstScene = "Main";
	}

	@Override
	public void dispose(){
		Bdx.dispose();
	}

	@Override
	public void render(){
		Bdx.main();
	}

	@Override
	public void resize(int width, int height){
		Bdx.resize(width, height);
	}

	@Override
	public void pause(){
	}

	@Override
	public void resume(){
	}
}
