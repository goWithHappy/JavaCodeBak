package com.ihad.test;


import org.junit.Test;

import processing.core.PApplet;

public class Ceshi extends PApplet{
	public void setup(){
		size(200,200);
		stroke(155,0,0);
	}
	@Test
	public void draw(){
		line(mouseX, mouseY, width/2, height/2);
	}
}
