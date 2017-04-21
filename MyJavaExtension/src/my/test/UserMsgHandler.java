package my.test;

import com.smartfoxserver.v2.entities.Room;
import com.smartfoxserver.v2.entities.User;
import com.smartfoxserver.v2.entities.data.ISFSObject;
import com.smartfoxserver.v2.entities.data.SFSObject;
import com.smartfoxserver.v2.extensions.BaseClientRequestHandler;

public class UserMsgHandler extends BaseClientRequestHandler {

	private static String allMsg = "";
	
	@Override
	public void handleClientRequest(User player, ISFSObject arg1) {
		// TODO Auto-generated method stub

		String userMsg = arg1.getText("UserMsg");

		trace("~" + userMsg + "~");
		
		Room room = player.getLastJoinedRoom();
		
		if(userMsg.matches("S"))
		{

			trace("!!!!!!!!!!!!!!!!!! TURE !!!!!!!!!!!!!!!!!!!!!!");
			
			
			UserMsgHandler.allMsg = "";
				
			ISFSObject mISFSObject = new SFSObject();
			
			mISFSObject.putText("UserMsg", UserMsgHandler.allMsg);
			
			MyExtension myExtension = (MyExtension)getParentExtension();
			//Send to single
			myExtension.send("UserMsg", mISFSObject, player);
			//Send to allPlayer
			myExtension.send("UserMsg", mISFSObject, room.getUserList());
			trace("From Client: " + userMsg);
		}
		else
		{
			trace("!!!!!!!!!!!!!!!!!! FALSE !!!!!!!!!!!!!!!!!!!!!!");
			
			UserMsgHandler.allMsg += player.getName() + ": " + userMsg + "\n";
			
			ISFSObject mISFSObject = new SFSObject();
			
			mISFSObject.putText("UserMsg", allMsg);
			
			MyExtension myExtension = (MyExtension)getParentExtension();
			//Send to single
			myExtension.send("UserMsg", mISFSObject, player);
			//Send to allPlayer
			myExtension.send("UserMsg", mISFSObject, room.getUserList());
			trace("From Client: " + userMsg);
		}
		
	}
}
