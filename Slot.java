package de.tuhh.diss.harborstorage;

import de.tuhh.diss.harborstorage.sim.StoragePlace;

public class Slot implements StoragePlace {
	StoragePlace MystoragePlace;
	private int slotnumber;
	private int posX;
	private int posY;
	private int W;
	private int H;
	private int D;
	private int loadC;
	private Packet contPack;
	


	
public Slot(StoragePlace elements){
	slotnumber=elements.getNumber();
	posX=elements.getPositionX();
	posY=elements.getPositionY();
	W=elements.getWidth();
	H=elements.getHeight();
	D=elements.getDepth();
	loadC=elements.getLoadCapacity();
	
	
	
}
            
	

	public int getNumber() {
		return slotnumber; // TODO: Replace this with your own code. 
	}

	public int getWidth() {
		return W; // TODO: Replace this with your own code. 
	}

	public int getHeight() {
		return H; // TODO: Replace this with your own code. 
	}
	
	public int getDepth() {
		return D; // TODO: Replace this with your own code. 
	}
	public int getLoadCapacity() {
		return loadC; // TODO: Replace this with your own code. 
	}
	public int getPositionX() {
		return posX; // TODO: Replace this with your own code. 
	}
	
	public int getPositionY() {
		return posY; // TODO: Replace this with your own code. 
	}
	public void SetId(int id){
		slotnumber=id;
	}
	public Packet getContainedPacket(){
		return contPack;
	}
	
	public void setContainedPacket(Packet newPacket){
		contPack=newPacket;
	}
	
}


