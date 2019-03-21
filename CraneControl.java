package de.tuhh.diss.harborstorage;

import de.tuhh.diss.harborstorage.sim.PhysicalCrane;
import de.tuhh.diss.harborstorage.sim.StorageElement;

public class CraneControl {
	
	public PhysicalCrane Crane;
	private int loadX;
	private int loadY;
	
	public CraneControl(PhysicalCrane cr){
		
		this.Crane=cr;
		 loadX=Crane.getLoadingPosX();
		 loadY=Crane.getLoadingPosY();
	}
	
	
	
	public void storePacket(int x, int y, StorageElement packet) {
		
			
		
		
		//Crane goes to Loading Position and loads packet
		
		moveToX(loadX);
		moveToY(loadY);
		
		Crane.loadElement(packet);
		
		//Crane goes to Storage Slot and stores packet
		
		moveToX(x);
		moveToY(y);
		Crane.storeElement();
		
	}
	
	public StorageElement retrievePacket(int x, int y) {
		
		
		
		//Crane goes to Storage Slot and retrieves packet

		moveToX(x);
		moveToY(y);
		Crane.retrieveElement();
		
		//Crane goes to Loading Position and unloads packet
		moveToX(loadX);
		moveToY(loadY);
		
		return Crane.unloadElement();
		 
	}
	public void moveToX(int x){
		
		while(x!=Crane.getPositionX()){
			if(x>Crane.getPositionX())
			Crane.forward();
			else
				Crane.backward();
			
		}
		Crane.stopX();
		
	}
public void moveToY(int y){
		
		while(y!=Crane.getPositionY()){
			if(y>Crane.getPositionY())
			Crane.up();
			else
				Crane.down();
			
		}
		Crane.stopY();
		
	}
	
	public void shutdown() {
		
		Crane.shutdown();
	}
}
