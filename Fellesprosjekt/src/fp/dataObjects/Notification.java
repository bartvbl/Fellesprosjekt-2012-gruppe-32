package fp.dataObjects;

public class Notification {
	
	public final int userID;
	public final int meetingID;
	public final NotificationStatus notificationStatus;
	public final NotificationType notificationType;
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
	
	public Notification(int userID, int meetingID, NotificationStatus notificationStatus, NotificationType notificationType){
		this.userID = userID;
		this.meetingID = meetingID;
		this.notificationStatus = notificationStatus;
		this.notificationType = notificationType;
	}
	
	
}
