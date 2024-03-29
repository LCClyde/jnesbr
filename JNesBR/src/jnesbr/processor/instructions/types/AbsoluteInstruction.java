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
package jnesbr.processor.instructions.types;

import jnesbr.gui.debugger.DisassemblerUtil;
import jnesbr.processor.Cpu2A03;
import jnesbr.util.JNesUtil;

/**
 * @author dreampeppers99
 */

public abstract class AbsoluteInstruction extends GeneralInstruction {

    public AbsoluteInstruction(Cpu2A03 cpu) {
        super(cpu);
    }

    @Override
    public int getOperandAddress() {
        return JNesUtil.get16BitLittleEndian(memory.read(cpu.programCounter + 1), memory.read(cpu.programCounter + 2));
    }

    @Override
    public short getOperand() {
        return memory.read(getOperandAddress());
    }

    public String complement(){
        return DisassemblerUtil.giveMeComplementIfNeeds(getOperandAddress());
    }
}
