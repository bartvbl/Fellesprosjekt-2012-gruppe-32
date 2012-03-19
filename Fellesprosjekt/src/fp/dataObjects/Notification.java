package fp.dataObjects;

public class Notification {
	
	public final int userID;
	public final int meetingID;
	public final acceptedMeeting aM;
	public final notificationType nT;
	public enum acceptedMeeting{
		Yes {
		public String toString(){
			return "Yes";
			}
		},
		No {
			public String toString(){
				return "No";
			}
		}
	};
	public enum notificationType{
		newMeeting{
			public String toString(){ 
				return "newMeeting";
			}
		}, 
		meetingUpdated{
			public String toString(){
				return "meetingUpdated";
			}
		}, 
		meetingCancelled{
			public String toString(){
				return "meetingCancelled";
			}
		}
	};
	
	public Notification(int userID, int meetingID, acceptedMeeting aM, notificationType nT){
		this.userID = userID;
		this.meetingID = meetingID;
		this.aM = aM;
		this.nT = nT;
	}
	
	
}
