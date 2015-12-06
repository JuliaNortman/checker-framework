import org.checkerframework.checker.nullness.qual.*;
import org.checkerframework.checker.initialization.qual.*;

public class NotOnlyInitializedTest {

    @NotOnlyInitialized NotOnlyInitializedTest f;
    NotOnlyInitializedTest g;

    public NotOnlyInitializedTest() {
    	f = new NotOnlyInitializedTest();
    	g = new NotOnlyInitializedTest();
    }
    
    public NotOnlyInitializedTest(char i) {
    	// we can store something that is under initialization (like this) in f, but not in g
    	f = this;
    	//:: error: (assignment.type.incompatible)
    	g = this;
    }
    
    static void testDeref(NotOnlyInitializedTest o) {
    	// o is fully iniatlized, so we can dereference it's fields
    	o.f.toString();
    	o.g.toString();
    }
    
    static void testDeref2(@UnderInitialization NotOnlyInitializedTest o) {
    	// o is not fully iniatlized, so we cannot dereference it's fields
    	//:: error: (dereference.of.nullable)
    	o.f.toString();
    	//:: error: (dereference.of.nullable)
    	o.g.toString();
    }
}
