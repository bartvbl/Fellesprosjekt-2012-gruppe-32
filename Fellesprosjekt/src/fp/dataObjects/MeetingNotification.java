package fp.dataObjects;

public class MeetingNotification {
	public final Notification notification;
	public final Meeting meeting;

	public MeetingNotification(Meeting meeting, Notification notification) {
		this.meeting = meeting;
		this.notification = notification;
	}
}
