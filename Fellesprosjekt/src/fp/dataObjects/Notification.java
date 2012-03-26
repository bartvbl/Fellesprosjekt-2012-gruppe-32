package fp.dataObjects;

public class Notification {
	
	public final int userID;
	public final int meetingID;
	public final NotificationStatus aM;
	public final NotificationType nT;
	public enum NotificationStatus{
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
	public enum NotificationType{
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
	
	public Notification(int userID, int meetingID, NotificationStatus aM, NotificationType nT){
		this.userID = userID;
		this.meetingID = meetingID;
		this.aM = aM;
		this.nT = nT;
	}
	
	
}
