/*
This file is part of JNesBR.

JNesBR is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

JNesBR is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with JNesBR.  If not, see <http://www.gnu.org/licenses/>.
 */
package jnesbr.debugger;

/**
 * @author dreampeppers99
 */
public class AssemblerLine {
    public int pc;
    public String asm6502Code;

    public AssemblerLine(int programCounter, String actualLineASM6502) {
        this.pc = programCounter;
        this.asm6502Code = actualLineASM6502;
    }
}
