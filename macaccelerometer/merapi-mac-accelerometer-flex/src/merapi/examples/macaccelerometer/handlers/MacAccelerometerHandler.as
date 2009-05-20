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

package merapi.examples.macaccelerometer.handlers
{

import flash.events.Event;

import merapi.examples.macaccelerometer.messages.MacAccelerometerMessage;
import merapi.handlers.mxml.MessageHandler;
import merapi.messages.IMessage;

import mx.utils.ObjectUtil;

//--------------------------------------
//  Events
//--------------------------------------

/**
 *  Signals a change in the tiltX, tiltY, and acceleration values.
 *
 *  @type flash.events.Event
 */
[Event(name="change", type="flash.events.Event")]	
	
[Bindable]
/**
 *  The <code>HelloWorldMessage</code> class extends <code>Message</code> as an example of a 
 *  custom Merapi message.
 *
 *  @see merapi.messages.Message;
 */
public class MacAccelerometerHandler extends MessageHandler
{
    //--------------------------------------------------------------------------
    //
    //  Constants
    //
    //--------------------------------------------------------------------------

    /**
     *  Message type for a Hello World message.
     */
    public static const MAC_ACCELEROMETER_CHANGE : String = "macAccelerometerChange";
     
            
    //--------------------------------------------------------------------------
    //
    //  Constructor
    //
    //--------------------------------------------------------------------------

    /**
     *  Constructor.
     */     
    public function MacAccelerometerHandler() 
    {
        super( MacAccelerometerMessage.MAC_ACCELEROMETER_CHANGE );
        
        connectMerapi();
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
    public var tiltX : Number = NaN;
    
    //----------------------------------
    //  tiltY
    //----------------------------------

    /**
     *  The tilt of the machine in the y plane
     */     
    public var tiltY : Number = NaN;
    
    //----------------------------------
    //  acceleration
    //----------------------------------

    /**
     *  The acceleration of the machine
     */     
    public var acceleration : Number = NaN;
    

    //--------------------------------------------------------------------------
    //
    //  Methods
    //
    //--------------------------------------------------------------------------

	override public function handleMessage( message : IMessage ) : void
	{
		if ( message is MacAccelerometerMessage )
		{
			var maMessage : MacAccelerometerMessage = message as MacAccelerometerMessage;
		
			tiltX 			= maMessage.tiltX;
			tiltY 			= maMessage.tiltY;
			acceleration 	= maMessage.acceleration;
			
			dispatchEvent( new Event( Event.CHANGE ) );
		}
	}
    
} //  end class
} //  end package

