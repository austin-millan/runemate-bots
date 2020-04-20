package com.Matsumotorise.bots.Template.oop;

import com.Matsumotorise.bots.Template.oop.Tasks.Chop;
import com.Matsumotorise.bots.Template.oop.Tasks.Drop;
import com.runemate.game.api.script.framework.task.TaskBot;

public class Main extends TaskBot {

	@Override
	public void onStart(String... args) {
		System.out.println("Start OOP");
		setLoopDelay(200, 450);
		add(new Chop(), new Drop());
	}

}
