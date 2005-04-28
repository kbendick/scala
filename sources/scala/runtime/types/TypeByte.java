/*                     __                                               *\
**     ________ ___   / /  ___     Scala API                            **
**    / __/ __// _ | / /  / _ |    (c) 2003-2005, LAMP/EPFL             **
**  __\ \/ /__/ __ |/ /__/ __ |                                         **
** /____/\___/_/ |_/____/_/ | |                                         **
**                          |/                                          **
\*                                                                      */

// $Id$

package scala.runtime.types;

import scala.runtime.RunTime;
import scala.Type;
import scala.Array;
import scala.Byte;

public class TypeByte extends ValueType {
    private final Byte ZERO = RunTime.box_bvalue((byte)0);
    public Object cast(Object o) {
        assert scala.runtime.types.Statistics.incTypeCast();
        if (! (o == null || o instanceof scala.Byte))
            throw new ClassCastException(); // TODO error message
        return o;
    }
    public Object defaultValue() { return ZERO; }
    public boolean isSameAsJavaType(Class that) {
        return that == java.lang.Byte.TYPE;
    }
    public String toString() { return "scala.Byte"; }
    public int hashCode() { return 0x77777777; }

    // Make TypeByte a serializable singleton
    public static TypeByte INSTANCE = new TypeByte();
    protected TypeByte() { /* exists only to that instantiation */ }
    private Object readResolve() { return INSTANCE; }
}
