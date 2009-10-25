////////////////////////////////////////////////////////////////////////////////////
//
//  This program is free software; you can redistribute it and/or modify 
//  it under the terms of the GNU Lesser General Public License as published 
//  by the Free Software Foundation; either version 3 of the License, or (at 
//  your option) any later version.
//
//  This program is distributed in the hope that it will be useful, but 
//  WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY 
//  or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public 
//  License for more details.
//
//  You should have received a copy of the GNU Lesser General Public License 
//  along with this program; if not, see <http://www.gnu.org/copyleft/lesser.html>.
//
////////////////////////////////////////////////////////////////////////////////////

using merapi.examples.excel.messages;
using merapi.messages;
using merapi.examples.excel;
using Merapi.Handlers;
using System;

namespace merapi.example.excel.handlers
{
    /**
     *  Handles edit in excel messages from Flex
     *  
     *  @author Adam Flater
     */
    class ExcelMessageHandler : MessageHandler
    {
        //--------------------------------------------------------------------------
        //
        //  Constructor
        //
        //--------------------------------------------------------------------------

        /**
         *  Constructor.
         */
        public ExcelMessageHandler()
        {
            //  Listen for editInExcel messages
            AddMessageType(ExcelMessage.EDIT_IN_EXCEL);
        }


        //--------------------------------------------------------------------------
        //
        //  Methods
        //
        //--------------------------------------------------------------------------

        /**
         *  @override
         *  
         *  Overriding the handleMessage method to respond to the
         *  editInExcel message.
         */
        public override void HandleMessage(IMessage message)
        {
            if (ExcelMessage.EDIT_IN_EXCEL == message.type)
            {
                ExcelMessage excelMessage = (ExcelMessage)message;

                //  Note: Excel rows/cols start at 1 not 0
                int rowIdx = 1;
                int colIdx = 1;
                
                //  Iterate the data set from Flex
                foreach (object[] arr in excelMessage.cellData)
                {
                    //  Start inserting at the first col for each value
                    colIdx = 1;
                    foreach (Object val in arr)
                    {
                        ExcelProxy.SetCell(rowIdx, colIdx, val.ToString());
                        colIdx++;
                    }
                    rowIdx++;
                }

                ExcelProxy.SetExcelVis(true);
            }
        }
    }
}
