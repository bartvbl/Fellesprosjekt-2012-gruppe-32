package fp.messageParsers;

public enum MessageType {
	addMeeting, 
	removeMeeting, 
	updateMeeting, 
	getMeeting, 
	getUser, 
	addFavouriteMeeting, 
	addFavouriteUser,
	getMeetingsInWeek,
	inviteClient, 
	connectionRequestAccepted, 
	loginRequest, 
	loginRequestAccepted, 
	loginRequestRejected, 
	meetingNotification, 
	registerNotificationResponse,
	searchUser,
	searchMeetingRoom
}
