package fp.dataObjects;

public class MeetingRoom {
	
	public final int roomID;
	public final int roomSize;
	
	public MeetingRoom(int roomID, int roomSize){
		this.roomID = roomID;
		this.roomSize = roomSize;
	}
	
	public String toString(){
		return "roomID: " + roomID + ", roomSize: " + roomSize;
	}

}
