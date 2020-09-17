package instruments;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;
public class TestAgent {
	
	public static void premain( String args, Instrumentation instrumentation) {
		
		System.out.println(" Test Agent RUNNING");
//	instrumentation.addTransformer(transformer);
	
	instrumentation.addTransformer(new ClassFileTransformer(){
		
		@SuppressWarnings("unused")
		public byte[] transform(Module module,
								ClassLoader loader,
								String name,
								Class<?> typeIfLoaded,
								ProtectionDomain domain,
								byte[] buffer) {
									
					
					System.out.println("Class was loaded:" + name);
					System.out.println("Loader usedd" + loader);
					
					return null;
					
					
		}
								
		
		
		
		
	});
	
	//System.out.println(instrumentation.isRetransformClassesSupported());
	
	
	}

}
//Premain-Class: instruments.TestAgent