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

using Merapi;
using merapi.examples.excel;
using merapi.example.excel.handlers;
using System;
namespace ExcelTest
{
    /**
     *  The main program for the Excel Automation Proxy
     *  
     *  @author Adam Flater
     */
    class Program
    {
        static void Main(string[] args)
        {
            Bridge.Open();
            new ExcelMessageHandler();
            Console.ReadLine();
        }
    }
}
