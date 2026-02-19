package compiler;

import compiler.AST.*;
import compiler.lib.*;
import compiler.exc.*;

public class PrintEASTVisitor extends BaseEASTVisitor<Void,VoidException> {

    PrintEASTVisitor() { super(false,true); }

    @Override
    public Void visitNode(ProgLetInNode n) {
        printNode(n);
        for (Node dec : n.declist) visit(dec);
        visit(n.exp);
        return null;
    }

    @Override
    public Void visitNode(ProgNode n) {
        printNode(n);
        visit(n.exp);
        return null;
    }

    @Override
    public Void visitNode(FunNode n) {
        printNode(n,n.id);
        visit(n.retType);
        for (ParNode par : n.parlist) visit(par);
        for (Node dec : n.declist) visit(dec);
        visit(n.exp);
        return null;
    }

    @Override
    public Void visitNode(ParNode n) {
        printNode(n,n.id);
        visit(n.getType());
        return null;
    }

    @Override
    public Void visitNode(VarNode n) {
        printNode(n,n.id);
        visit(n.getType());
        visit(n.exp);
        return null;
    }

    @Override
    public Void visitNode(PrintNode n) {
        printNode(n);
        visit(n.exp);
        return null;
    }

    @Override
    public Void visitNode(IfNode n) {
        printNode(n);
        visit(n.cond);
        visit(n.th);
        visit(n.el);
        return null;
    }

    @Override
    public Void visitNode(AndNode n) {
        printNode(n);
        visit(n.left);
        visit(n.right);
        return null;
    }

    @Override
    public Void visitNode(OrNode n) {
        printNode(n);
        visit(n.left);
        visit(n.right);
        return null;
    }

    @Override
    public Void visitNode(NotNode n) {
        printNode(n);
        visit(n.exp);
        return null;
    }

    @Override
    public Void visitNode(EqualNode n) {
        printNode(n);
        visit(n.left);
        visit(n.right);
        return null;
    }

    @Override
    public Void visitNode(LessEqualNode n) {
        printNode(n);
        visit(n.left);
        visit(n.right);
        return null;
    }

    @Override
    public Void visitNode(GreaterEqualNode n) {
        printNode(n);
        visit(n.left);
        visit(n.right);
        return null;
    }

    @Override
    public Void visitNode(TimesNode n) {
        printNode(n);
        visit(n.left);
        visit(n.right);
        return null;
    }

    @Override
    public Void visitNode(DivNode n) {
        printNode(n);
        visit(n.left);
        visit(n.right);
        return null;
    }

    @Override
    public Void visitNode(PlusNode n) {
        printNode(n);
        visit(n.left);
        visit(n.right);
        return null;
    }

    @Override
    public Void visitNode(MinusNode n) {
        printNode(n);
        visit(n.left);
        visit(n.right);
        return null;
    }

    @Override
    public Void visitNode(CallNode n) {
        printNode(n,n.id+" at nestinglevel "+n.nl);
        visit(n.entry);
        for (Node arg : n.arglist) visit(arg);
        return null;
    }

    @Override
    public Void visitNode(IdNode n) {
        printNode(n,n.id+" at nestinglevel "+n.nl);
        visit(n.entry);
        return null;
    }

    @Override
    public Void visitNode(BoolNode n) {
        printNode(n,n.val.toString());
        return null;
    }

    @Override
    public Void visitNode(IntNode n) {
        printNode(n,n.val.toString());
        return null;
    }

    @Override
    public Void visitNode(ArrowTypeNode n) {
        printNode(n);
        for (Node par: n.parlist) visit(par);
        visit(n.ret,"->");
        return null;
    }

    @Override
    public Void visitNode(BoolTypeNode n) {
        printNode(n);
        return null;
    }

    @Override
    public Void visitNode(IntTypeNode n) {
        printNode(n);
        return null;
    }

    @Override
    public Void visitSTentry(STentry entry) {
        printSTentry("nestlev "+entry.nl);
        printSTentry("type");
        visit(entry.type);
        printSTentry("offset "+entry.offset);
        return null;
    }

    @Override
    public Void visitNode(EmptyTypeNode n) {
        if (print) printNode(n);
        return null;
    }

    @Override
    public Void visitNode(EmptyNode n) {
        if (print) printNode(n);
        return null;
    }

    @Override
    public Void visitNode(NewNode n) {
        printNode(n, n.id);
        visit(n.entry);
        for (Node arg : n.arglist) visit(arg);
        return null;
    }

    @Override
    public Void visitNode(RefTypeNode n) {
        if (print) printNode(n, n.id);
        return null;
    }

    @Override
    public Void visitNode(ClassTypeNode n) {
        if (print) printNode(n);
        for (TypeNode f : n.allFields) visit(f);
        for (ArrowTypeNode m : n.allMethods) visit(m);
        return null;
    }

    @Override
    public Void visitNode(ClassNode n) {
        if (print) printNode(n, n.id + (n.superId != null ? " extends " + n.superId : ""));
        for (FieldNode f : n.fieldNodes) visit(f);
        for (MethodNode m : n.methodNodes) visit(m);
        return null;
    }

    @Override
    public Void visitNode(FieldNode n) {
        if (print) printNode(n, n.id + " offset " + n.getOffset());
        visit(n.getType());
        return null;
    }

    @Override
    public Void visitNode(MethodNode n) {
        if (print) printNode(n, n.id + " offset " + n.getOffset());
        visit(n.retType);
        for (ParNode p : n.parlist) visit(p);
        for (DecNode d : n.declist) visit(d);
        visit(n.exp);
        return null;
    }

    @Override
    public Void visitNode(ClassCallNode n) {
        printNode(n, n.id1 + "." + n.id2 + " at nestinglevel " + n.nl);
        visit(n.entry);
        for (Node arg : n.arglist) visit(arg);
        return null;
    }

}
