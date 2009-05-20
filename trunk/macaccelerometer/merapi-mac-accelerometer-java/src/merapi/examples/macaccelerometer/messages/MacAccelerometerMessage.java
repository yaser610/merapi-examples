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

package merapi.examples.macaccelerometer.messages;

import merapi.messages.Message;

/**
 *  The <code>HelloWorldMessage</code> class extends <code>Message</code> as an example of a 
 *  custom Merapi message.
 *
 *  @see merapi.messages.Message;
 */
public class MacAccelerometerMessage extends Message
{
    //--------------------------------------------------------------------------
    //
    //  Constants
    //
    //--------------------------------------------------------------------------

    /**
     *  Message type for a Hello World message.
     */
    public static final String MAC_ACCELEROMETER_CHANGE = "macAccelerometerChange";
     
            
    //--------------------------------------------------------------------------
    //
    //  Constructor
    //
    //--------------------------------------------------------------------------

    /**
     *  Constructor.
     */     
    public MacAccelerometerMessage() 
    {
        super( MAC_ACCELEROMETER_CHANGE );
    }
    
    
    //--------------------------------------------------------------------------
    //
    //  Properties
    //
    //--------------------------------------------------------------------------

    //----------------------------------
    //  tiltX
    //----------------------------------

    /**
     *  The tilt of the machine in the x plane
     */     
    public double tiltX = -1;
    
    //----------------------------------
    //  tiltY
    //----------------------------------

    /**
     *  The tilt of the machine in the y plane
     */     
    public double tiltY = -1;
    
    //----------------------------------
    //  acceleration
    //----------------------------------

    /**
     *  The acceleration of the machine
     */     
    public double acceleration = -1;
    
}

