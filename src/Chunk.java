package com.hachisoftware.ism;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public abstract class Chunk {

	public String chuckID;
	
	public Chunk() {
	}

	public abstract void writeChunk(DataOutputStream data) throws IOException;
	public abstract void readChunk(DataInputStream data) throws IOException;
	
}
