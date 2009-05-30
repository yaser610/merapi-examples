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

package merapi.examples.voice.handlers
{

import flash.events.Event;

import merapi.examples.voice.messages.VoiceMessage;
import merapi.handlers.mxml.MessageHandler;
import merapi.messages.IMessage;

//--------------------------------------
//  Events
//--------------------------------------

/**
 *  Signals a change in the filePath value.
 *
 *  @type flash.events.Event
 */
[Event(name="change", type="flash.events.Event")]	
	
[Bindable]
/**
 *  The <code>VoiceHandler</code> class extends <code>Message</code> as an example of a 
 *  custom Merapi message.
 *
 *  @see merapi.messages.Message;
 */
public class VoiceHandler extends MessageHandler
{
    //--------------------------------------------------------------------------
    //
    //  Constants
    //
    //--------------------------------------------------------------------------

    /**
     *  Message type for a Voice message.
     */
    public static const MESSAGE_SENT : String = "messageSent";
     
            
    //--------------------------------------------------------------------------
    //
    //  Constructor
    //
    //--------------------------------------------------------------------------

    /**
     *  Constructor.
     */     
    public function VoiceHandler() 
    {
        super( VoiceHandler.MESSAGE_SENT );
        connectMerapi();
    }
    
    //--------------------------------------------------------------------------
    //
    //  Methods
    //
    //--------------------------------------------------------------------------

	override public function handleMessage( message : IMessage ) : void
	{
		if ( message is VoiceMessage )
		{
			var vMessage : VoiceMessage = message as VoiceMessage;
			dispatchEvent( new Event( Event.CHANGE ) );
		}
	}
    
} //  end class
} //  end package

