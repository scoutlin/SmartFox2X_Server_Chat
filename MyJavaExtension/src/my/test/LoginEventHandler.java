package my.test;

import com.smartfoxserver.v2.core.ISFSEvent;
import com.smartfoxserver.v2.core.SFSEventParam;
import com.smartfoxserver.v2.exceptions.SFSException;
import com.smartfoxserver.v2.exceptions.SFSLoginException;
import com.smartfoxserver.v2.extensions.BaseServerEventHandler;

public class LoginEventHandler extends BaseServerEventHandler {

	@Override
	public void handleServerEvent(ISFSEvent event) throws SFSException {
		// TODO Auto-generated method stub
		String name = (String) event.getParameter(SFSEventParam.LOGIN_NAME);
        
        if (name.equals("Gonzo") || name.equals("Kermit"))
            throw new SFSLoginException("Gonzo and Kermit are not allowed in this Zone!");
	}
	
	

}
