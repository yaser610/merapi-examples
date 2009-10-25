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

package merapi.examples.excel.messages
{
	import merapi.messages.Message;

	[RemoteClass(alias="merapi.examples.excel.messages.ExcelMessage")]
	/**
	 *  The ExcelMessage provides notifications about udpates from Excel
	 *  or requests to Excel via Flex.
	 *
	 *  @author Adam Flater
	 */
	public class ExcelMessage extends Message
	{
		//--------------------------------------------------------------------------
		//
		//  Constants
		//
		//--------------------------------------------------------------------------

		/**
		 *  The cell update type notifies when a cell's value has changed.
		 */
		public static const CELL_UPDATE:String = "cellUpdate";

		/**
		 *  The edit in Excel type notifies the excel app to edit the contents
		 *  of a DataGrid in Excel.
		 */
		public static const EDIT_IN_EXCEL:String = "editInExcel";

		//--------------------------------------------------------------------------
		//
		//  Properties
		//
		//--------------------------------------------------------------------------

		/**
		 *  A set of cell data to edit in Excel.
		 */
		public var cellData:Array = null;

		/**
		 *  The row of the cell that was updated.
		 */
		public var row:int = -1;

		/**
		 *  The column of the cell that was updated.
		 */
		public var col:int = -1;

		/**
		 *  The value of the cell that was updated.
		 */
		public var val:Object = null;
	}
}