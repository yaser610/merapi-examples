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

package merapi.examples.screencapture.messages
{

import merapi.messages.Message;

[RemoteClass( alias="merapi.examples.screencapture.messages.ScreenCaptureMessage" )]
/**
 *  The <code>ScreenCaptureMessage</code> class extends <code>Message</code> as an example of a 
 *  custom Merapi message.
 *  @author Rich Tretola everythingflex.com twitter @richtretola
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
     *  Message type for a Screen Capture message.
     */
    public static const TAKE_SCREEN_SHOT : String = "takeScreenShot";
     
            
    //--------------------------------------------------------------------------
    //
    //  Constructor
    //
    //--------------------------------------------------------------------------

    /**
     *  Constructor.
     */     
    public function ScreenCaptureMessage() 
    {
        super( TAKE_SCREEN_SHOT );
    }
    
    
    //--------------------------------------------------------------------------
    //
    //  Properties
    //
    //--------------------------------------------------------------------------

    //----------------------------------
    //  filePath
    //----------------------------------

    /**
     *  A custom data property that contains the storage path
     *  for the screen shots
     */     
    public var storagePath : String = null;
    
    //----------------------------------
    //  imagePath
    //----------------------------------

    /**
     *  A custom data property that contains the image path
     */     
    public var imagePath : String = null;
    
    
} //  end class
} //  end package

