package de.tuhh.diss.harborstorage;

import de.tuhh.diss.harborstorage.sim.HighBayStorage;
import de.tuhh.diss.harborstorage.sim.PhysicalCrane;
import de.tuhh.diss.harborstorage.sim.PhysicalHarborStorage;
import de.tuhh.diss.harborstorage.sim.StorageException;
//import de.tuhh.diss.harborstorage.sim.StoragePlace;

public class HarborStorageManagement implements HighBayStorage {
	private PhysicalHarborStorage myHarbor;
	
	private Packet[]packets;
	private Slot[]slots ;
	boolean []empty ;
	private Packet myPacket;
	
	
	
 
	private PhysicalCrane myCrane;
	private CraneControl MyCraneControl;
	
	
	
	public HarborStorageManagement(){
		this.myHarbor=new PhysicalHarborStorage();
		this.myCrane=myHarbor.getCrane();
		this.MyCraneControl=new CraneControl(myCrane);
		slots =new Slot[myHarbor.getStoragePlacesAsArray().length];
	    packets=new Packet[slots.length];
		empty = new boolean[slots.length];
		for(int j=0;j<slots.length;j++){
			slots[j]=new Slot(myHarbor.getStoragePlacesAsArray()[j]);
			empty[j]=true;
					
	}
		
		
		                                                                                 
	}

	
	public int storePacket(int width, int height, int depth, String description, int weight)throws StorageException{
		
		myPacket=new Packet( width, height,  depth,description, weight);
		Slot SuitableSlotFound=findSuitableSlot(myPacket);
		if (SuitableSlotFound==null){
			throw new StorageException("Package doesnt fit in any of the available slots");
			
		}else{
		int SuitableSlotId=SuitableSlotFound.getNumber();
		myPacket.setLocation(SuitableSlotFound);
		packets[SuitableSlotFound.getNumber()]=myPacket;		
		MyCraneControl.storePacket(SuitableSlotFound.getPositionX(),SuitableSlotFound.getPositionY(), myPacket);
		slots[SuitableSlotId].setContainedPacket(myPacket);
		empty[SuitableSlotId]=false;
		 return SuitableSlotId;
		 }
	}
	
	public void retrievePacket(String description) throws StorageException {
		for(int i=0;i<packets.length;i++){
			if(packets[i]!=null){
			if(packets[i].getDescription().equals(description)){
				
				
				MyCraneControl.retrievePacket(packets[i].getLocation().getPositionX(),packets[i].getLocation().getPositionY());
				packets[i]=null;
				slots[i].setContainedPacket(null);
				empty[i]=true;
				
			}
			else{
				throw new StorageException("Desired Packet is not Available in Storage");
			}
			}
			else System.out.println("no packets stored here");
		}

	}
	
	
	public Packet[] getPackets() {
		return packets; // TODO: Replace this with your own code. 
	}
	public Slot findSuitableSlot(Packet p){
		
		
		double difference;
		double mindifference=slots[0].getLoadCapacity()-p.getWeight();
		boolean firstslot=true;
		int id=-1;
		
		for(int i=0;i<slots.length;i++){
		
	if(empty[i]==true){
		if (slots[i].getWidth()>=p.getWidth()){
			if(slots[i].getHeight()>=p.getHeight()){
				if(slots[i].getDepth()>=p.getDepth()){
					if(slots[i].getLoadCapacity()>=p.getWeight()){
						difference=slots[i].getLoadCapacity()-p.getWeight();
						if (mindifference<0&&firstslot==true ){
							mindifference*=-1;
							firstslot=false;
							
						}
						else if(mindifference<0&&firstslot==false){
							mindifference*=-1;
							System.out.println("package not suitable for slot...finding another please wait..");
						}
					
						else if(difference<=mindifference){
						
							mindifference=difference;
							 id=i;
						}
												}
						
						
						
											
	
		
		}
			}
		}
	}
		}
		if (id==-1){
			return null;
		}
		else slots[id].SetId(id);
			return slots[id];
	}
		 
		
		

		
	
	public void shutdown() {
		MyCraneControl.shutdown();
	
	}
	
}
