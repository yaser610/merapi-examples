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

package merapi.examples.screencapture.messages;

import merapi.messages.Message;

/**
 *  The <code>ScreenCaptureMessage</code> class extends <code>Message</code> as an example of a 
 *  custom Merapi message.
 *
 *  @see merapi.messages.Message;
 */
public class ScreenCaptureMessage extends Message
{
    //--------------------------------------------------------------------------
    //
    //  Constants
    //
    //--------------------------------------------------------------------------

    /**
     *  Message type for a TAKE_SCREEN_SHOT message.
     */
    public static final String TAKE_SCREEN_SHOT = "takeScreenShot";
     
            
    //--------------------------------------------------------------------------
    //
    //  Constructor
    //
    //--------------------------------------------------------------------------

    /**
     *  Constructor.
     */     
    public ScreenCaptureMessage() 
    {
        super();
    }
    
    
    //--------------------------------------------------------------------------
    //
    //  Properties
    //
    //--------------------------------------------------------------------------

    //----------------------------------
    //  storagePath
    //----------------------------------

    /**
     *  A custom data property that contains the Screen Shot 
     *  Storage Path set from AIR
     */     
    public String getStoragePath() { return __storagePath; }
    public void setStoragePath( String val ) { __storagePath = val; }

    
    //----------------------------------
    //  imagePath
    //----------------------------------

    /**
     *  A custom data property that contains the Image Path 
     *  returned to AIR
     */     
    public String getImagePath() { return __imagePath; }
    public void setImagePath( String val ) { __imagePath = val; }

    
    //--------------------------------------------------------------------------
    //
    //  Variables
    //
    //--------------------------------------------------------------------------
    
    private String __imagePath = null;
    private String __storagePath = null;
} 

