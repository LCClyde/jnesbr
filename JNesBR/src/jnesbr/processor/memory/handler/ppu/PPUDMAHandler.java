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

import jnesbr.core.Emulator;
import jnesbr.processor.memory.Memory;
import jnesbr.processor.memory.handler.Handler;
import jnesbr.video.Ppu2C02;
import jnesbr.video.sprite.SpriteRAM;

/**
 * @author dreampeppers99
 */
public final class PPUDMAHandler implements Handler {
    private Memory memory = Memory.getMemory();
    private Ppu2C02 ppu = Ppu2C02.getInstance();
    private SpriteRAM sprMemory= SpriteRAM.getInstance();
    private short address;
//todo: understand this
/*Specifies the destination address 
 in Sprite RAM for use with Port 2004h (Single byte write),
 and Port 4014h (256 bytes DMA transfer).*/
    public final void writeAt(final int address,final short value) {
        memory.writeUnhandled(address, value);
        fillSpriteRAM(value * 0x100);
        Emulator.getInstance().getCpu().cycles += 512;
    }

    public final short readFrom(final int address) {
        return memory.readUnhandled(address);
    }

    private final void fillSpriteRAM(final int firstAddress) {
        address = ppu.ppuOAMAddress.address;
        int max = firstAddress + 0xFF;
        for (int index = firstAddress; index <= max; index++) {
            sprMemory.add((short)(address & 0xFF) ,memory.readUnhandled(index));
            address++;
        }
    }
}
