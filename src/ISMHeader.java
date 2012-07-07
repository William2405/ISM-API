package com.hachisoftware.ism;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class ISMHeader extends Chunk {

	private int ismFrameRate, ismVideoWidth, ismVideoHeight;
	
	public ISMHeader(int frameRate, int videoWidth, int videoHeight)
	{
		this.ismFrameRate = frameRate;
		this.ismVideoWidth = videoWidth;
		this.ismVideoHeight = videoHeight;
		this.chuckID = "MHDR";
	}

	@Override
	public void writeChunk(DataOutputStream data) throws IOException {
		data.writeInt(ismFrameRate);
		data.writeInt(ismVideoWidth);
		data.writeInt(ismVideoHeight);
	}

	@Override
	public void readChunk(DataInputStream data) throws IOException {
		this.ismFrameRate = data.readInt();
		this.ismVideoWidth = data.readInt();
		this.ismVideoHeight = data.readInt();
	}

	public int getIsmFrameRate() {
		return ismFrameRate;
	}

	public int getIsmVideoWidth() {
		return ismVideoWidth;
	}

	public int getIsmVideoHeight() {
		return ismVideoHeight;
	}

}
