package com.hachisoftware.ism;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ChunkOutputStream extends OutputStream {

	private DataOutputStream out;
	
	public ChunkOutputStream(OutputStream out) throws IOException {
		this.out = new DataOutputStream(out);
		out.flush();
	}
	
	@Override
	public void close() throws IOException {
		flush();
		out.close();
	}

	@Override
	public void flush() throws IOException {
		out.flush();
	}

	@Override
	public void write(int b) throws IOException {
		out.write(b);
		flush();
	}
	
	public void write(Chunk obj) throws IOException {
		out.writeUTF(obj.chuckID);
		flush();
		obj.writeChunk(out);
		flush();
	}

}
