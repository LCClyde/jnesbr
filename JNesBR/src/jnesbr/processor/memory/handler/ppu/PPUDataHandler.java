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
import jnesbr.processor.memory.handler.Handler;
import jnesbr.video.PPUControll;
import jnesbr.video.Ppu2C02;
import jnesbr.video.memory.VideoMemory;

/**
 * @author dreampeppers99
 */
public final class PPUDataHandler implements Handler {

    private short buffer = 0xBF; //the first read will bring ?? value
    private short returnValue;
    private Ppu2C02 ppu;
    private Memory mainMemory;
    private VideoMemory videoMemory;

    public PPUDataHandler(){
        ppu = Ppu2C02.getInstance();
        mainMemory = Memory.getMemory();
        videoMemory = VideoMemory.getMemory();
    }

    public final void writeAt(final int address, final short value) {
        ppu.pPUData.data = value;
        videoMemory.write(ppu.pPUAddress.completeAddress, ppu.pPUData.data);
        if (ppu.ppuControl.port2007AddressIncrement == PPUControll.IncrementBy1) {
            ppu.pPUAddress.completeAddress++;
        } else {
            ppu.pPUAddress.completeAddress += 32;
        }
        mainMemory.writeUnhandled(address, value);
    }

    public final short readFrom(final int address) {
        if (ppu.pPUAddress.completeAddress >= 0x000 & ppu.pPUAddress.completeAddress <= 0x3EFF){
            returnValue = buffer;
            buffer = read();
        }else{
            returnValue = read();
        }
        return returnValue;
    }

    private final short read() {
        returnValue = videoMemory.readUnhandled(ppu.pPUAddress.completeAddress);
        if (ppu.ppuControl.port2007AddressIncrement == PPUControll.IncrementBy1) {
            ppu.pPUAddress.completeAddress++;
        } else {
            ppu.pPUAddress.completeAddress += 32;
        }
        return returnValue;
    }
}
