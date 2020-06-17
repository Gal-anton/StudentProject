package edu.galichin.studentorder.validator;

import edu.galichin.studentorder.domain.children.AnswerChildren;
import edu.galichin.studentorder.domain.StudentOrder;

public class ChildrenValidator {
    public AnswerChildren checkChildren(StudentOrder studentOrder) {
        return new AnswerChildren();
    }
}
