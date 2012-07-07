package com.hachisoftware.ism;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ChunkInputStream extends InputStream {

	private DataInputStream in;
	
	public ChunkInputStream(InputStream in) {
		this.in = new DataInputStream(in);
	}
	
	@Override
	public int read() throws IOException {
		return in.read();
	}

	@Override
	public void close() throws IOException {
		in.close();
	}
	
	public Chunk readChunk(Chunk type) throws IOException {
		
		StringBuilder id = new StringBuilder();
		id.append(in.readChar());
		id.append(in.readChar());
		id.append(in.readChar());
		id.append(in.readChar());
		
		if(!type.chuckID.equalsIgnoreCase(id.toString()))
			throw new IOException("Can't cast Chunk '" + type.chuckID + "' to '" + id + "'");
		
		type.readChunk(in);
		
		return type;
	}
}
