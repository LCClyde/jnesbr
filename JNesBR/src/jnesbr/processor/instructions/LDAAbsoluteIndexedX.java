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
package jnesbr.processor.instructions;

import jnesbr.processor.Cpu2A03;
import jnesbr.processor.instructions.types.AbsoluteIndexedInstruction;
import jnesbr.processor.memory.Memory;
import jnesbr.util.JNesUtil;

/**
 * @author dreampeppers99
 */
public class LDAAbsoluteIndexedX extends AbsoluteIndexedInstruction {

    private byte cycles;

    public LDAAbsoluteIndexedX(Cpu2A03 cpu) {
        super(cpu);
    }

    @Override
    public void interpret() {
        cycles = 4;
        if (((cpu.programCounter + getOperand(cpu.registerX)) & 0xFF00) != (cpu.programCounter & 0xFF00)) {
            cycles++;
        }
        cpu.programCounter += 3;
        cpu.accumulator = Memory.getMemory().read(getOperand(cpu.registerX));
        cpu.setupFlagSign(cpu.accumulator);
        cpu.setupFlagZero(cpu.accumulator);
    }

    @Override
    public String disassembler() {
        return "LDA $" + JNesUtil.fillIfNeedsWith(4, "0", Integer.toHexString(JNesUtil.get16BitLittleEndian(Memory.getMemory().read(cpu.programCounter+1), Memory.getMemory().read(cpu.programCounter+2)))).toUpperCase() + " ,X ";
    }

    @Override
    public short cycles() {
        return cycles;
    }
}