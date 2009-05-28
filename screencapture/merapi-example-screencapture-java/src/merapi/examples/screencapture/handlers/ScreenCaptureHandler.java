////////////////////////////////////////////////////////////////////////////////
//
//  This program is free software; you can redistribute it and/or modify 
//  it under the terms of the GNU General Public License as published by the 
//  Free Software Foundation; either version 3 of the License, or (at your 
//  option) any later version.
//
//  This program is distributed in the hope that it will be useful, but 
//  WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY 
//  or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License 
//  for more details.
//
//  You should have received a copy of the GNU General Public License along 
//  with this program; if not, see <http://www.gnu.org/licenses>.
//
////////////////////////////////////////////////////////////////////////////////

package merapi.examples.screencapture.handlers;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.imageio.ImageIO;

import merapi.examples.screencapture.messages.ScreenCaptureMessage;
import merapi.handlers.MessageHandler;
import merapi.messages.IMessage;

public class ScreenCaptureHandler extends MessageHandler
{
    //--------------------------------------------------------------------------
    //
    //  Constructor
    //
    //--------------------------------------------------------------------------

    /**
     *  Constructor.
     */ 
    public ScreenCaptureHandler() 
    {
        super( ScreenCaptureMessage.TAKE_SCREEN_SHOT );
    }

    //--------------------------------------------------------------------------
    //
    //  Methods
    //
    //--------------------------------------------------------------------------

    /**
     *  Handles the ScreenCaptureMessage.TAKE_SCREEN_SHOT message type.
     */ 
    public void handleMessage( IMessage message )
    {
    	if ( message instanceof ScreenCaptureMessage )
        {
        	ScreenCaptureMessage scMessage = ( ScreenCaptureMessage ) message;
        	try{
    			/*
    			 * read the storage directory from the scMessage object
    			 */ 
        		scMessage.setImagePath(takeShot(scMessage.getStoragePath()));
        		scMessage.send();
    		} catch (Exception e){
    			e.printStackTrace();
    		}
            
        }
    }
    /*
	* taking the screen shot
	*/ 
    public String takeShot(String storageDirectory) throws
		 	AWTException, IOException, Exception {
		/*
		* capture the whole screen
		*/ 
		BufferedImage screencapture = new Robot().createScreenCapture(
			new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()) );
		/*
		* Create a new file using the incoming storage directory 
		* and a unique time stamp
		* Save as a png
		*/
		Date d = new Date();
		File file = new File(storageDirectory + "sc_" + d.getTime() + ".png");
		ImageIO.write(screencapture, "png", file);
		/*
		* return the absolute file path
		*/ 
		return file.getAbsolutePath();
	}
}
