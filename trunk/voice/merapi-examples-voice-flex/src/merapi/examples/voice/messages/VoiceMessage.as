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

package merapi.examples.voice.messages
{

import merapi.messages.Message;

[RemoteClass( alias="merapi.examples.voice.messages.VoiceMessage" )]
/**
 *  The <code>VoiceMessage</code> class extends <code>Message</code> as an example of a 
 *  custom Merapi message.
 *  @author Rich Tretola everythingflex.com twitter @richtretola
 *  @see merapi.messages.Message;
 */
public class VoiceMessage extends Message
{
    //--------------------------------------------------------------------------
    //
    //  Constants
    //
    //--------------------------------------------------------------------------

    /**
     *  Message type for a Voice message.
     */
    public static const SAY_IT : String = "sayIt";
     
            
    //--------------------------------------------------------------------------
    //
    //  Constructor
    //
    //--------------------------------------------------------------------------

    /**
     *  Constructor.
     */     
    public function VoiceMessage() 
    {
        super( SAY_IT );
    }
    
    
    //--------------------------------------------------------------------------
    //
    //  Properties
    //
    //--------------------------------------------------------------------------

    //----------------------------------
    //  text
    //----------------------------------

    /**
     *  A custom data property that contains the text to speak
     */     
    public var text : String = null;
      
    
} //  end class
} //  end package

