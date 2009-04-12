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

import java.util.ArrayList;
import java.util.List;

/**
 * @author dreampeppers99
 */
public class Debugger {

    public static final String DEBUGGER_CHR = "♦";
    private static List<Breakpoint> breakpoints = new ArrayList<Breakpoint>();

    public static void add(Breakpoint b) {
        breakpoints.add(b);
    }

    public static void remove(Breakpoint b) {
        breakpoints.remove(b);
    }

    public static boolean isBreakpointed(int address) {
        return breakpoints.contains(new Breakpoint(address));
    }
}
