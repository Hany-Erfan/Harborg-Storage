package de.tuhh.diss.harborstorage;

import de.tuhh.diss.harborstorage.sim.StorageException;
import de.tuhh.diss.io.*;

public class HarborStorageApp {

private static HarborStorageManagement hsm;

public static void main (String[] args) {
hsm = new HarborStorageManagement();
int d = 1;
SimpleIO.println("");
SimpleIO.print("Harbor Storage Management\n");
while (d != 0){
d = displayMenu();
if (d == 1){
displayStoreMenu();
}
else if (d == 2){
if (hsm.getPackets().length>0){
displayRetrieveMenu();
}
else{
SimpleIO.println("no packets available");
}
}
else if (d != 0){
SimpleIO.println("That is not possible");
}
}
SimpleIO.println("program end");
hsm.shutdown();
}

public static int displayMenu(){
// This method displays the main Menu
SimpleIO.println("Options Available");
SimpleIO.println("0: Exit");
SimpleIO.println("1: Store Packet");
SimpleIO.println("2: Retrieve Packet");
SimpleIO.print("Option number: ");
int Choice = SimpleIO.readInt();
SimpleIO.println("");
return Choice;
}

public static void displayStoreMenu(){
// This method displays the Store Packet menu
SimpleIO.println("Storing Packet");
SimpleIO.print("Description: ");
String myDescription = SimpleIO.readString();
SimpleIO.print("Width: ");
int myWidth = SimpleIO.readInt();
SimpleIO.print("Height: ");
int myHeight = SimpleIO.readInt();
SimpleIO.print("Depth: ");
int myDepth = SimpleIO.readInt();
SimpleIO.print("Weight: ");
int myWeight = SimpleIO.readInt();
SimpleIO.println(" packet \"" + myDescription + "\" of size " + myWidth + "x" + myHeight + "x" + myDepth + " and weight " + myWeight + ".");
SimpleIO.print("Shall we store the packet? (y/n): ");
String myResponse = SimpleIO.readString();
if (myResponse.equals("y")){
try{
int myID = hsm.storePacket(myWidth, myHeight, myDepth, myDescription, myWeight);
SimpleIO.println("Packet Stored in Rack. The ID is " + myID);
}
catch(StorageException e){
SimpleIO.println("Error: Cannot Find Slot for Packet");
}
}
SimpleIO.println("");
}

public static void displayRetrieveMenu(){
// This method displays the Retrieve Packet Menu
SimpleIO.println("Available Packets:");
displayPackets();
SimpleIO.println("*** Enter Description of Packet to be retrieved (0 = Abort) ***");
String myDescription = SimpleIO.readString();
if  (!myDescription.equals("0")){
try{
hsm.retrievePacket(myDescription);
SimpleIO.println("Packet Retrieved\n");

}
catch(StorageException e){
SimpleIO.println("Error: Cannot Find Packet with Given Description");
}
}

}

public static void displayPackets(){
// This method displays all currently stored packets
Packet[] myPackets = hsm.getPackets();
for (int i=0;i<=myPackets.length-1;i++){
	if(myPackets[i]!=null){
SimpleIO.println(myPackets[i].getId() + ": Packet \"" + myPackets[i].getDescription() + "\" Size: " + myPackets[i].getWidth() + "x" + myPackets[i].getWidth() + "x" + myPackets[i].getWidth() + " Weight: " + myPackets[i].getWeight());
}
else {SimpleIO.println("no packet");
SimpleIO.println("");
}
}
}
}

