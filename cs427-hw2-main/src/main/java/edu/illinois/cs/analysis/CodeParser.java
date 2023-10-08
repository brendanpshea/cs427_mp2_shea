package edu.illinois.cs.analysis;
import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Modifier;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;


public class CodeParser extends VoidVisitorAdapter
{
	int methNum = 0;

	/**
	 * Following the visitor pattern design, this visit function will be
	 * automatically applied to all method declarations within the given
	 * compilation unit (i.e., Java files).
	 */
	@Override
	public void visit(MethodDeclaration n, Object arg) {
		super.visit(n, arg);
		
		 // Constraint 1: Method has an actual body declaration
		 boolean hasBody = n.getBody().isPresent();

		 // Constraint 2: Method has at least one input parameter
		 boolean hasParameter = !n.getParameters().isEmpty();
 
		  // Constraint 3: Method is public
		 boolean isPublic = n.isPublic();

		  // Constraint 4: Method is not static
		 boolean isNotStatic = !n.isStatic();
 
		 // Constraint 5: Method has a return type (i.e., not void)
		 boolean hasReturnType = !n.getType().toString().equals("void");
 
		 if (hasBody && hasParameter && isPublic && isNotStatic && hasReturnType) {

			methNum++;
		 }
	}

}
