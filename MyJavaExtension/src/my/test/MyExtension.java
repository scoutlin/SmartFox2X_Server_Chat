/**
 * 
 */
package my.test;

import com.smartfoxserver.v2.core.SFSEventType;
import com.smartfoxserver.v2.extensions.SFSExtension;

/**
 * @author UX303
 *
 */
public class MyExtension extends SFSExtension
{
	/**
	 *  {@inheritDoc}  
	 */
	public void init()
	{
		//TODO Auto-generated method stub
		//Log

		this.addEventHandler(SFSEventType.USER_LOGIN, LoginEventHandler.class);
		this.addRequestHandler("UserMsg", UserMsgHandler.class);
		
		trace("FUCK!!");
		
		
		
	}
	
	/**
	 *  {@inheritDoc}
	 */
	public void destroy()
	{
		//TODO Auto-generated method stub
		super.destroy();
	}
}
