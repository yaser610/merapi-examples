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

using merapi.messages;
using System;

namespace merapi.examples.excel.messages
{
    /**
     *  The ExcelMessage provides notifications about udpates from Excel
     *  or requests to Excel via Flex.
     *  
     *  @author Adam Flater
     */
    class ExcelMessage : Message
    {
        //--------------------------------------------------------------------------
        //
        //  Constants
        //
        //--------------------------------------------------------------------------

        /**
         *  The cell update type notifies when a cell's value has changed.
         */
        public const String CELL_UPDATE = "cellUpdate";

        /**
         *  The edit in Excel type notifies the excel app to edit the contents
         *  of a DataGrid in Excel.
         */
        public const String EDIT_IN_EXCEL = "editInExcel";


        //--------------------------------------------------------------------------
        //
        //  Properties
        //
        //--------------------------------------------------------------------------

        /**
         *  A set of cell data to edit in Excel.
         */
        public object[] cellData;

        /** 
         *  The row of the cell that was updated.
         */
        public int row = -1;

        /** 
         *  The column of the cell that was updated.
         */
        public int col = -1;

        /**
         *  The value of the cell that was updated.
         */
        public Object val = null;
    }
}
