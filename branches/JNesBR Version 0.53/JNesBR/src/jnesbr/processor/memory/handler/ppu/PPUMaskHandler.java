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
package jnesbr.processor.memory.handler.ppu;

import jnesbr.processor.memory.Memory;
import jnesbr.processor.memory.MemoryMap;
import jnesbr.processor.memory.handler.Handler;
import static jnesbr.util.JNesUtil.*;
import jnesbr.video.PPUMask;
import jnesbr.video.Ppu2C02;

/**
 * @author dreampeppers99
 */
public class PPUMaskHandler implements Handler {

    private PPUMask ppuMask;

    public void writeAt(int address, short value) {
        ppuMask = Ppu2C02.getInstance().ppuMask;
        ppuMask.intensifyBlues = giveMeBit7From(value);
        ppuMask.intensifyGreens = giveMeBit6From(value);
        ppuMask.intensifyReds = giveMeBit5From(value);
        ppuMask.spriteRenderingEnable = giveMeBit4From(value);
        ppuMask.backgroundRenderingEnable = giveMeBit3From(value);
        ppuMask.enableSpriteInLeftmost = giveMeBit2From(value);
        ppuMask.enableBackgroundInLeftmost = giveMeBit1From(value);
        ppuMask.grayscale = giveMeBit0From(value);
        Memory.getMemory().writeUnhandled(address, value);
        mirror(address, value);

    }

    private void mirror(int address, short value) {
        while ((address + 0x08) <= MemoryMap.IO_MIRROR_END) {
            Memory.getMemory().writeUnhandled(address + 0x08, value);
            address += 8;
        }
    }

    public short readFrom(int address) {
        return Memory.getMemory().readUnhandled(address);
    }
}