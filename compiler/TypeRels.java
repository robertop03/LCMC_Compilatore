package compiler;

import compiler.AST.*;
import compiler.lib.*;

public class TypeRels {

	// valuta se il tipo "a" e' <= al tipo "b", dove "a" e "b" sono tipi di base: IntTypeNode o BoolTypeNode
	public static boolean isSubtype(TypeNode a, TypeNode b) {

		// uguali
		if (a.getClass().equals(b.getClass())) return true;

		// bool <= int
		if ((a instanceof BoolTypeNode) && (b instanceof IntTypeNode)) return true;

		// null <= RefType (cioè null assegnabile a qualunque classe)
		if (a instanceof EmptyTypeNode && b instanceof RefTypeNode) return true;

		// null <= null
		if (a instanceof EmptyTypeNode && b instanceof EmptyTypeNode) return true;

		return false;
	}

}
