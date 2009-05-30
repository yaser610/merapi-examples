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

package merapi.examples.voice;

import merapi.Bridge;
import merapi.examples.voice.handlers.VoiceHandler;;

public class VoiceRunner
{
    //--------------------------------------------------------------------------
    //
    //  Static methods
    //
    //--------------------------------------------------------------------------
    
    /**
     *  The main method that starts the Bridge and instantiates the VoiceHandler instance.
     */
    public static void main( String[] args )
    {
        Bridge.open();
        
        new VoiceHandler();
    }

}
