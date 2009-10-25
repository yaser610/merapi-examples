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

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Microsoft.Office.Interop.Excel;
using System.Reflection;
using merapi.examples.excel.messages;

namespace merapi.examples.excel
{
    /**
     *  A proxy class used to automate Excel via the COM api.
     *  
     *  @author - Adam Flater
     */
    public class ExcelProxy
    {
        //--------------------------------------------------------------------------
        //
        //  Constants
        //
        //--------------------------------------------------------------------------

        /**
         *  A reference to the active Excel worksheet
         */
        private static Microsoft.Office.Interop.Excel.Worksheet Worksheet;

        /**
         *  A reference to the active Excel application
         */
        private static Microsoft.Office.Interop.Excel.Application Excel;


        //--------------------------------------------------------------------------
        //
        //  Static constructor
        //
        //--------------------------------------------------------------------------

        /**
         *  Constructor.
         */
        static ExcelProxy()
        {
            Init();
        }

        static void Init()
        {
            Microsoft.Office.Interop.Excel._Workbook workbook = null;
            DocEvents_ChangeEventHandler worksheetChangeHandler = null;

            try
            {
                //  Start Excel and get Application object.
                Excel = new Microsoft.Office.Interop.Excel.Application();
                Excel.Visible = false;

                //  Get a new workbook.
                workbook = (Microsoft.Office.Interop.Excel._Workbook)
                    (Excel.Workbooks.Add(Missing.Value));

                //  Get the active worksheet
                Worksheet = (Microsoft.Office.Interop.Excel.Worksheet)workbook.ActiveSheet;

                //  Instantiate a change handler
                worksheetChangeHandler = new DocEvents_ChangeEventHandler(CellChange);

                //  Add the change handler to the worksheet
                Worksheet.Change += worksheetChangeHandler;
            }
            catch (Exception theException)
            {
                String errorMessage;
                errorMessage = "Error: ";
                errorMessage = String.Concat(errorMessage, theException.Message);
                errorMessage = String.Concat(errorMessage, " Line: ");
                errorMessage = String.Concat(errorMessage, theException.Source);

                Console.WriteLine(errorMessage);
            }

        }


        //--------------------------------------------------------------------------
        //
        //  Static methods
        //
        //--------------------------------------------------------------------------

        /**
         *  Sets the visibility of the Excel application
         */
        public static void SetExcelVis(bool vis)
        {
            Excel.Visible = vis;
        }

        /**
         *  Sets the value of the cell at row, col
         */
        public static void SetCell(int row, int col, Object val)
        {
            try
            {
                Worksheet.Cells[row, col] = val;
            }
            catch (Exception exception)
            {
                Init();
                SetCell(row, col, val);
            }
        }

        /**
         *  The change handler for updates from Excel
         */
        public static void CellChange(Range Target)
        {
            //  Instantiate a new ExcelMessage to 
            //  notify Flex about the change
            ExcelMessage message = new ExcelMessage();
            message.type = ExcelMessage.CELL_UPDATE;
            message.row = Target.Row;
            message.col = Target.Column;
            if (Target.Value2 != null)
            {
                message.val = Target.Value2;
            }
            else
            {
                message.val = Target.Formula.ToString();

            }
            message.send();
        }

    }
}
