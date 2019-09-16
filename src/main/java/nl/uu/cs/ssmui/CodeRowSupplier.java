/* 
	Title:			Simple Stack Machine Runner
	Author:			atze
	Description:	
*/

package nl.uu.cs.ssmui;

interface CodeRowSupplier {
    int memLocOfRow(int row);

    void setInstrArgAt(int row, int argOffset, int val);

}
