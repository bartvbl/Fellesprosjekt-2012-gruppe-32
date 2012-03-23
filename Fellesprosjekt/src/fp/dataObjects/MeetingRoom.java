package fp.dataObjects;

public class MeetingRoom {
	
	public final int roomID;
	public final int roomSize;
	public final String name;
	
	public MeetingRoom(int roomID, int roomSize, String name){
		this.roomID = roomID;
		this.roomSize = roomSize;
		this.name = name;
	}
	
	public String toString(){
		return "roomID: " + roomID + ", roomSize: " + roomSize + "roomName: " + name;
	}

}
