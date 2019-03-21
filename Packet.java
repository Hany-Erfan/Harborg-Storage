package de.tuhh.diss.harborstorage;

import de.tuhh.diss.harborstorage.sim.StorageElement;

public class Packet implements StorageElement{
	//StorageElement MyStorageElement;
	private int identNr;
	private int W;
	private int H;
	private int D;
	private String Descri;
	private int Weight;
	private Slot Locat;
	
	public Packet(int width, int height,int  depth,String description,int weight){
		W=width;
		H=height;
		D=depth;
		Descri=description;
		Weight=weight;
		
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

	public int getId() {
		return identNr; // TODO: Replace this with your own code. 
	}
	
	public String getDescription() {
		return Descri; // TODO: Replace this with your own code. 
	}
	public int getWeight() {
		return Weight; // TODO: Replace this with your own code. 
	}
	public Slot getLocation(){
		return Locat;
		
	}
	public void setLocation(Slot newLocation){
		Locat=newLocation;
		
	}
}
