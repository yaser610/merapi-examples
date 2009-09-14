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

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Merapi.Handlers;
using merapi.examples.helloworld.messages;
using merapi.messages;

namespace merapi.examples.helloworld.handlers
{
    public class HelloWorldHandler : MessageHandler
    {
        //--------------------------------------------------------------------------
        //
        //  Constructor
        //
        //--------------------------------------------------------------------------

        /**
         *  Constructor.
         */
        public HelloWorldHandler()
        {
            AddMessageType( HelloWorldMessage.HELLO );
        }

        //--------------------------------------------------------------------------
        //
        //  Methods
        //
        //--------------------------------------------------------------------------

        /**
         *  Handles the HelloWorldMessage.HELLO message type.
         */
        public void handleMessage( IMessage message )
        {
            if ( message is HelloWorldMessage )
            {
                HelloWorldMessage hwMessage = ( HelloWorldMessage ) message;
                Console.Out.WriteLine( hwMessage.helloText );

                hwMessage.helloText = hwMessage.helloText + " - response - " +
                                        DateTime.Now.ToString();
                hwMessage.send();
            }
        }
    }
}
