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
package jnesbr.video;

import java.util.HashMap;
import java.util.Map;
import jnesbr.core.Emulator;

/**
 * @author dreampeppers99
 */
public class Ppu2C02 {
    private short[] spriteMemory = new short[0x100];
    private static Ppu2C02 instance;
    public PPUControll ppuControl = new PPUControll();
    public PPUStatus ppuStatus = new PPUStatus();
    public PPUMask ppuMask = new PPUMask();
    private Map<Integer, int[][]> patternTable = new HashMap<Integer, int[][]>();

    public static Ppu2C02 getInstance() {
        if (instance == null) {
            instance = new Ppu2C02();
        }
        return instance;
    }

    public void reset(){
        
    }
    private Ppu2C02() {
    }

    public void initPatternTable() {
        if (Emulator.getInstance().haveTablePattern()) {
            short[] chr_rom = Emulator.getInstance().giveMeTablePattern();
            int addressComplement = 0;
            for (int index = 0; index < chr_rom.length; addressComplement += 16, index += 16) {
                int[][] tile = new int[8][8];
                for (byte row = 0; row < 8; row++) {
                    for (byte collumn = 7; collumn >= 0; collumn--) {
                        tile[row][collumn] = ((chr_rom[row + addressComplement + 8] >> collumn & 0x1) << 1) | (chr_rom[row + addressComplement] >> collumn & 0x1);
                    }
                }
                getPatternTable().put(addressComplement / 16, tile);
            }

        }
    }

    public Map<Integer, int[][]> getPatternTable() {
        return patternTable;
    }
}