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

import jnesbr.processor.Cpu2A03;
import jnesbr.processor.memory.Memory;
import jnesbr.util.JNesUtil;

/**
 * @author dreampeppers99
 */
//TODO: CHECK ALL SUBCLASSES...
public abstract class IndirectIndexedInstruction extends GeneralInstruction {
    int bb,xx,yy,op;
    public IndirectIndexedInstruction(Cpu2A03 cpu) {
        super(cpu);
    }

    @Override
    public int getOperandAddress() {
        return memory.read(cpu.programCounter + 1);
    }

    @Override
    public short getOperand() {
        bb = memory.read(cpu.programCounter + 1);
        xx = memory.read((bb));
        yy = memory.read((bb + 1));
        op = JNesUtil.get16BitLittleEndian(xx, yy);
        return memory.read(op + cpu.registerY);
    }

    protected boolean pageChanged() {
        bb = memory.read(cpu.programCounter + 1);
        xx = memory.read((bb));
        yy = memory.read((bb + 1));
        op = JNesUtil.get16BitLittleEndian(xx, yy);
        return (((op & 0xFF) + cpu.registerY) > 0xFF);
    }
}
