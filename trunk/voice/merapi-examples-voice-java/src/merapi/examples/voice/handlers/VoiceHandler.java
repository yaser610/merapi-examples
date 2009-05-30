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

////////////////////////////////////////////////////////////////////////////////
//
// Voice example was written by Rich Tretola
// http://www.twitter.com/richtretola
// http://blog.everythingflex.com
// http://www.happytoad.com
//
////////////////////////////////////////////////////////////////////////////////

package merapi.examples.voice.handlers;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

import merapi.examples.voice.messages.VoiceMessage;
import merapi.handlers.MessageHandler;
import merapi.messages.IMessage;

public class VoiceHandler extends MessageHandler
{
    //--------------------------------------------------------------------------
    //
    //  Constructor
    //
    //--------------------------------------------------------------------------

    /**
     *  Constructor.
     */ 
    public VoiceHandler() 
    {
        super( VoiceMessage.SAY_IT );
    }

    //--------------------------------------------------------------------------
    //
    //  Methods
    //
    //--------------------------------------------------------------------------

    /**
     *  Handles the VoiceMessage.SAY_IT message type.
     */ 
    public void handleMessage( IMessage message )
    {
    	if ( message instanceof VoiceMessage )
        {
    		VoiceMessage vMessage = ( VoiceMessage ) message;
    		VoiceManager voiceManager = VoiceManager.getInstance();
    		Voice voice = voiceManager.getVoice("kevin16");
    		voice.allocate();
    		voice.speak(vMessage.getText());
        }
    }
}
