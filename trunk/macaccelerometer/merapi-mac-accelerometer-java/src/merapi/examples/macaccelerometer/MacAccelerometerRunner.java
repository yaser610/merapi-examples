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

package merapi.examples.macaccelerometer;

import sms.Unimotion;
import merapi.Bridge;
import merapi.examples.macaccelerometer.messages.MacAccelerometerMessage;

/**
 *  The main class that starts the SMS Merapi service.
 */
public class MacAccelerometerRunner
{
    //--------------------------------------------------------------------------
    //
    //  Static methods
    //
    //--------------------------------------------------------------------------
    
    /**
     *  The main method that starts the Bridge and reports changes from the SMS sensor.
     */
    public static void main( String[] args )
    {
        Bridge.open();

        new MacAccelerometerReaderThread().start();
    }
}

/**
 *  A sub class of thread that checks the values of the SMS sensor every 250ms.
 */
class MacAccelerometerReaderThread extends Thread
{
    //--------------------------------------------------------------------------
    //
    //  Methods
    //
    //--------------------------------------------------------------------------
    
    /**
     *  Overriding the run method of Thread, which is called by invoking start() on
     *  an instance.
     */
    public void run() 
    {
        //  Instantiate a message that will be reused to send change noticifactions
        MacAccelerometerMessage message = new MacAccelerometerMessage();

        while ( true )
        {
            message.tiltX = Unimotion.getSMSX();
            message.tiltY = Unimotion.getSMSY();
            message.acceleration = Unimotion.getSMSZ();
            message.send();

            try
            {
                sleep( 250 );
            }
            catch ( Exception e )
            {}
        }        
    }
}
