package com.sperone.crash.logic.objects;

public enum ObjectChar {
	PLAYER('P'), BLOCK('B');
	
	private final char c;
	
	private ObjectChar(char c) {
		this.c = c;
	}
	
	public char toChar() {
		return c;
	}
}
